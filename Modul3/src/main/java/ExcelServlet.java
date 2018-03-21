import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Tables", urlPatterns = "/Excel")
public class ExcelServlet extends HttpServlet {
    private ExcelRepository dbHelper;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        ServletOutputStream out = resp.getOutputStream();
        ArrayList<Table> tables = dbHelper.getAll();
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setHeader("Content-Type", "application/json;charset=utf-8");
        out.write(objectMapper.writeValueAsBytes(tables));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Table table = objectMapper.readValue(req.getInputStream(), Table.class);
        Table tableDB = dbHelper.getTable(table.getName());
        ServletOutputStream out = resp.getOutputStream();
        if (tableDB.getName() == null) {
            dbHelper.save(new Table(table.getName(), table.getValue()));
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setHeader("Content-Type", "application/json;charset=utf-8");
            out.write(objectMapper.writeValueAsBytes(dbHelper.getTable(table.getName())));
        } else {
            resp.setHeader("Content-Type", "application/json;charset=utf-8");
            out.write(objectMapper.writeValueAsBytes(tableDB));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Table table = objectMapper.readValue(req.getInputStream(), Table.class);
        dbHelper.delete(table);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        dbHelper = new ExcelRepository();
    }
}
