import java.sql.*;
import java.util.ArrayList;

public class ExcelRepository {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test_jdbc";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123qwe";

    private Connection con;

    private static void addMySQLToClassPath() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    public ExcelRepository() {
        addMySQLToClassPath();
        try {
            con = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Table table) {
        try (PreparedStatement statement = con.prepareStatement("INSERT INTO excel (name, value) VALUES ('" +
                table.getName() + "','" + table.getValue() + "')")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Table getTable(String name) {
        Table table = new Table(null, null);
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM excel WHERE name = '" + name + "'");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                table = new Table(rs.getString("name"), rs.getString("value"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }

    public void delete(Table Table) {
        try (Connection dbConnection = getConnection();
             PreparedStatement statement = dbConnection.prepareStatement("DELETE FROM excel WHERE name=?")) {
            statement.setString(1, Table.getName());
            statement.executeUpdate();
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Table> getAll() {
        ArrayList<Table> result = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM excel");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(
                        new Table(rs.getString("name"), rs.getString("value")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void close() throws SQLException {
        con.close();
    }
}
