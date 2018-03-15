package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import domain.Task;
import repository.DBHelper;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "Tasks", urlPatterns = "/TodoList")
public class TodoServlet extends HttpServlet {
    private DBHelper dbHelper;

    @Override
    public void init() {
        dbHelper = new DBHelper();
    }

    private String convertToJson(ArrayList<Task> tasks) {
        Gson gson = new Gson();
        return gson.toJson(tasks);
    }

    private ArrayList<Task> convertFromJson(String data) {
        Gson gson = new Gson();
        Type taskType = new TypeToken<ArrayList<Task>>(){}.getType();
        return gson.fromJson(data, taskType);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        ServletOutputStream out = resp.getOutputStream();
        ArrayList<Task> tasks = dbHelper.getAll();
        String output = convertToJson(tasks);
        out.print(output);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonData = req.getReader().readLine();
        convertFromJson(jsonData).forEach(dbHelper::add);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonData = req.getReader().readLine();
        convertFromJson(jsonData).forEach(dbHelper::delete);
    }

    @Override
    public void destroy() {
        try {
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
