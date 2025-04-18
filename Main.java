import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String userName = "postgres";
        String password = "rootroot";
        String connectionUrl = "jdbc:postgresql://localhost:5432/test";
        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password)) {
            if (connection != null)
                System.out.println("We are connected");
            else
                System.out.println("Connection filed");
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS Books");
            statement.executeUpdate("CREATE TABLE Books (" +
                    "id SERIAL PRIMARY KEY," +
                    " name VARCHAR(30) NOT NULL)");
            statement.executeUpdate("insert into Books (name) values('Inferno')");
        } catch (SQLException e) {
            System.out.println("Connection failure");
            e.printStackTrace();
        }
    }
}