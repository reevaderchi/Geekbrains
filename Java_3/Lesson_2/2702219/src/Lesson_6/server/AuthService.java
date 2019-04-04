package Lesson_6.server;

import java.sql.*;

public class AuthService {

    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:userDB.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String showHistory() throws SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection("jdbc:sqlite:history.db");
        Statement  stmt = connection.createStatement();
        String history = "";
        ResultSet ars = stmt.executeQuery("SELECT * FROM main");


        while (ars.next()) {
            history = history + ars.getString(2) + "\n";
        }

        return history;

    }

    public static void saveToHistory(String text) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection("jdbc:sqlite:history.db");
        Statement  stmt = connection.createStatement();
        String sql = String.format("INSERT INTO main (text) VALUES ('%s')", text);
        stmt.executeUpdate(sql);
    }

//    public static void clearHistory() throws SQLException {
//        try {
//            Class.forName("org.sqlite.JDBC");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Connection connection = DriverManager.getConnection("jdbc:sqlite:history.db");
//        Statement  stmt = connection.createStatement();
//        stmt.executeUpdate("DELETE FROM main");
//    }

    public static String getNickByLoginAndPass(String login, String pass) throws SQLException {
        String sql = String.format("SELECT nickname FROM main where " +
                "login = '%s' and password = '%s'", login, pass);
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            return rs.getString(1);
        }

        return null;
    }


    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
