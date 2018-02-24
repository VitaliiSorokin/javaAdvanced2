package school;

import java.sql.*;

public class DBUtils {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test_jdbc?useSSL=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123qwe";

    private static void addMySQLToClassPath() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    public static void createTable() {
        addMySQLToClassPath();
        try (Connection dbConnection = getConnection();
             Statement statement = dbConnection.createStatement()) {
            statement.execute("DROP TABLE `school`");
            statement.execute("CREATE TABLE IF NOT EXISTS school" +
                    "  (id INT NOT NULL AUTO_INCREMENT," +
                    "  class_name VARCHAR(3) NOT NULL," +
                    "  pupils_count INT(3) DEFAULT NULL," +
                    "  principal VARCHAR(255) DEFAULT NULL," +
                    "  PRIMARY KEY (id)" +
                    " )"
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addRow(String[] values) {
        final String addSttmnt = "INSERT INTO school (class_name, pupils_count, principal) VALUES (?, ?, ?)";
        try (Connection dbConnection = getConnection();
             PreparedStatement statement = dbConnection.prepareStatement(addSttmnt)) {
            statement.setString(1, values[0]);
            statement.setInt(2, Integer.parseInt(values[1]));
            statement.setString(3, values[2]);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getClassInfo(String className) {
        final String getSttmnt = "SELECT class_name, pupils_count, principal FROM school WHERE class_name LIKE  ?";
        String classNam = null;
        String classNum = null;
        String classPrinc = null;

        try (Connection dbConnection = getConnection();) {
            PreparedStatement statement = dbConnection.prepareStatement(getSttmnt);
            statement.setString(1, className);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                classNam = rs.getString("class_name");
                classNum = rs.getString("pupils_count");
                classPrinc = rs.getString("principal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (classNam == null) {
            return "The class " + className + " was not found";
        } else {
            return classNam + " " + classNum + " " + classPrinc;
        }
    }
}
