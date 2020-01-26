package proyecto;


import proyecto.controlador.Controlador;
import proyecto.modelo.CalendarioVO;
import proyecto.modelo.UsuarioVO;
import proyecto.vista.VistaAlumno;
import proyecto.modelo.Modelo_Usuario;
import proyecto.vista.VistaProfesor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Hilo_IniciarSesion extends Thread {

    UsuarioVO usuario = new UsuarioVO();
    Controlador controlador= new Controlador();
    VistaAlumno vistaAlumno= new VistaAlumno(controlador);
    VistaProfesor vistaProfesor= new VistaProfesor(controlador);
    Modelo_Usuario modelo= new Modelo_Usuario();

    public Hilo_IniciarSesion(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public void run() {

        try {

           if( modelo.comprobar(usuario)==true){
             String tipo=  modelo.comprobarTipo(usuario);
             ArrayList<String> calendario= new ArrayList<String>();
               if(tipo.equals("alumno")){

                   calendario= modelo.listaCalendario();
                   vistaAlumno.actualizarCalendario(calendario);
                   sleep(2000);
                   vistaAlumno.setVisible(true);
               }else if(tipo.equals("profesor")){
                   calendario= modelo.listaCalendario();
                   vistaProfesor.actualizarCalendario(calendario);
                   sleep(5000);
                   vistaProfesor.setVisible(true);

               }

           }else{
               JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto/s.", "Error en iniciar sesión", JOptionPane.WARNING_MESSAGE);
           }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
