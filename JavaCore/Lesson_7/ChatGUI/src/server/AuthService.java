package server;

import java.sql.*;

public class AuthService {

    private static Connection connection;
    private static Statement statement;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:userDB.db");
            statement = connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPass (String login, String password) throws SQLException {

        String sql = String.format("SELECT nickname FROM main where login = '%s' and password = '%s'", login, password);
        ResultSet rs = statement.executeQuery(sql);

        if (rs.next()) {
            return rs.getString(1);
        }

        return null;

    }


}
