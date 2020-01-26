package proyecto;


import proyecto.controlador.Controlador;
import proyecto.modelo.UsuarioVO;
import proyecto.vista.VistaAlumno;
import proyecto.modelo.Modelo_Usuario;

import java.util.Scanner;

public class Hilo_IniciarSesion extends Thread {

    UsuarioVO usuario = new UsuarioVO();
    Controlador controlador= new Controlador();
    VistaAlumno vistaAlumno= new VistaAlumno(controlador);
    Modelo_Usuario modelo= new Modelo_Usuario();

    public Hilo_IniciarSesion(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public void run() {

        try {
                sleep(2000);
                vistaAlumno.setVisible(true);
                System.out.println("Bienvenidx a la aplicación.");



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
