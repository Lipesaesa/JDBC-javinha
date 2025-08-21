import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexao {
    private static final String URL = "jdbc:msql://localhost:3306/loja";
    private static final String USER = "root";
    private static final String PASSWORD = "04072127@Fjm";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
