import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String userName = "postgres";
        String password = "rootroot";
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password)) {
            if (connection != null)
                System.out.println("We are connected");
            else
                System.out.println("Connection filed");
        } catch (SQLException e) {
            System.out.println("Connection failure");
            e.printStackTrace();
        }
    }
}