package proyecto;


import proyecto.controlador.Controlador;
import proyecto.controlador.UsuariosConectados;
import proyecto.modelo.CalendarioVO;
import proyecto.modelo.UsuarioVO;
import proyecto.vista.VistaAlumno;
import proyecto.modelo.Modelo_Usuario;
import proyecto.vista.VistaProfesor;
import proyecto.vista.VistaProfesor2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Hilo_IniciarSesion extends Thread {

    UsuarioVO usuario = new UsuarioVO();
    Controlador controlador= new Controlador();
    VistaAlumno vistaAlumno= new VistaAlumno(controlador);
    VistaProfesor2 vistaProfesor= new VistaProfesor2(controlador);
    Modelo_Usuario modelo= new Modelo_Usuario();
    UsuariosConectados conectados = new UsuariosConectados();

    public Hilo_IniciarSesion(UsuariosConectados usConectados, UsuarioVO usuario) {
        this.usuario = usuario;
        this.conectados=usConectados;
    }

    public void run() {

        try {

           if( modelo.comprobar(usuario)==true){
             String tipo=  modelo.comprobarTipo(usuario);
             ArrayList<String> calendario= new ArrayList<String>();
               if(tipo.equals("alumno")){
                   System.out.println("hola probando");
                   conectados.put();
                   System.out.println("hola p2"+conectados.get());
                   if(conectados.get()<=3) {
                       calendario = modelo.listaCalendario();
                       vistaAlumno.actualizarCalendario(calendario);
                       sleep(2000);
                       vistaAlumno.setVisible(true);
                   };

               }else if(tipo.equals("profesor")){
                   calendario= modelo.listaCalendario();
                   vistaProfesor.actualizarCalendario(calendario);
                   sleep(2000);
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
