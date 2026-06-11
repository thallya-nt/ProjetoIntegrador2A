package projeto2A.principal.conFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {


    //SE NECESSÁRIO, FAVOR ALTERAR USER E/OU PASSWORD

    private static final String url = "jdbc:mysql://localhost:3306/agendatelefonica";
    private static final String user = "root";
    private static final String password = " ";

    public static Connection conn;

    public static Connection getConexao() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
