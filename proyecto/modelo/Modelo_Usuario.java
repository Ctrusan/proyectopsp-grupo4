package proyecto.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelo_Usuario {


    public boolean comprobar(UsuarioVO usuario) {
        try {
            Connection conexion = Conexion_JDBC.conectar();
            Statement st = conexion.createStatement();
            String sentencia = "SELECT NOMBRE, CONTRASENA, TIPO FROM USUARIOS";
            ResultSet rs = st.executeQuery(sentencia);
            while(rs.next()) {

                if(rs.getString("NOMBRE").equals(usuario.getNombre())&& rs.getString("CONTRASENA").equals(usuario.getContrasena())) {
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String comprobarTipo(UsuarioVO usuario) {

        try {
            Connection conexion = Conexion_JDBC.conectar();
            Statement st = conexion.createStatement();
            String sentencia = "SELECT NOMBRE, CONTRASENA, TIPO FROM USUARIOS";
            ResultSet rs = st.executeQuery(sentencia);
            while(rs.next()) {
                if(rs.getString("NOMBRE").equals(usuario.getNombre())&& rs.getString("CONTRASENA").equals(usuario.getContrasena())) {
                    return rs.getString("TIPO");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> listaCalendario(){

        try {
            Connection conexion = Conexion_JDBC.conectar();
            Statement st = conexion.createStatement();
            String sentencia = "SELECT CODIGO, NOMBRE, CONTENIDO FROM CALENDARIO";
            ResultSet rs = st.executeQuery(sentencia);
            ArrayList<String> lista= new ArrayList<String>();

            while(rs.next()) {
                lista.add(rs.getString("NOMBRE"));

            }
            return lista;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public void añadirCalendario(CalendarioVO calendario){

        try {
            Connection conexion = Conexion_JDBC.conectar();
            Statement st = conexion.createStatement();
            String aux= "insert into CALENDARIO " + "values ('"+ calendario.getNombre()+"', '"+calendario.getContenido()+"')";
            System.out.println(aux);
            st.executeUpdate("insert into calendario (nombre, contenido) values ('"+ calendario.getNombre()+"', '"+calendario.getContenido()+"')" );
            st.close();

        }catch(Exception e){
            e.printStackTrace();
        }


    }

}
