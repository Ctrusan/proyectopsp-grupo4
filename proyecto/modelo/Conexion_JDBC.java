package proyecto.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion_JDBC {

        public static Connection conexion = null;

        public static Connection conectar() {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/calendario", "root", "");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return conexion;
        }

        public static void desconectar() {
            try {
                conexion.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

}
