import java.sql.*;

public class Workers {

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {

            // CREATE через интерфейс DB
            connect();

            // READ
            ResultSet rs = statement.executeQuery("SELECT * FROM main WHERE SALARY >= 1000");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " +
                        rs.getString("salary"));
            }

            // UPDATE
            statement.executeUpdate("INSERT INTO main (id, name, salary) VALUES (6, 'Kevin', 1100)");
            statement.executeUpdate("INSERT INTO main (id, name, salary) VALUES (7, 'Mike', 2300)");

            statement.executeUpdate("UPDATE main SET salary = 1200 WHERE id = 3");

            // DELETE
            // statement.executeUpdate("DELETE FROM main WHERE id = 4");

            connection.commit();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " +
                        rs.getString("salary"));
            }

            disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:WorkersDB.db");
        statement = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
