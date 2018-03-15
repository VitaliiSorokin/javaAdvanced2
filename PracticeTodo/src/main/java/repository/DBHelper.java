package repository;

import domain.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {
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

    public DBHelper() {
        addMySQLToClassPath();
        try {
            con = getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Task task) {
        try (PreparedStatement statement = con.prepareStatement("INSERT INTO todos (item) VALUES ('" + task.getTodo() + "')")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Task task) {
        try (Connection dbConnection = getConnection();
             PreparedStatement statement = dbConnection.prepareStatement("DELETE FROM todos WHERE id=?")) {
            statement.setInt(1, task.getId());
            statement.executeUpdate();
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> getAll() {
        ArrayList<Task> result = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM todos");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(new Task(rs.getInt("id"), rs.getString("item")));
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
