import controlador.Controlador;
import modelo.Modelo_Usuario;
import modelo.UsuarioVO;
import vista.IniciarSesion;

public class Main {

    public static void main(String []args) {

     /*   UsuarioVO alumno1 = new UsuarioVO("Carlos", "1234", "Alumno");
        UsuarioVO profesor1 = new UsuarioVO("Jose_Luis", "1234", "Profesor");

        Hilo_IniciarSesion hilo1 = new Hilo_IniciarSesion(alumno1);
        hilo1.start();
*/
        Controlador controlador= new Controlador();
        IniciarSesion vista= new IniciarSesion(controlador);
        Modelo_Usuario modelo= new Modelo_Usuario();
         controlador.setModelo(modelo);
         controlador.setVista(vista);

         vista.setVisible(true);


    }
}
