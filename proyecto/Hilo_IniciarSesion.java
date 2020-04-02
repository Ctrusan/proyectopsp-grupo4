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
    static Controlador controlador= new Controlador();
    VistaAlumno  vistaAlumno= new VistaAlumno(controlador);
    VistaProfesor2 vistaProfesor= new VistaProfesor2(controlador);
    Modelo_Usuario modelo= new Modelo_Usuario();
    UsuariosConectados conectados = new UsuariosConectados();

    public Hilo_IniciarSesion(UsuariosConectados usConectados, UsuarioVO usuario) {
        this.usuario = usuario;
        this.conectados=usConectados;
    }

    public UsuariosConectados getConectados() {
        return conectados;
    }



    public void run() {


        if( modelo.comprobar(usuario)==true){
          String tipo=  modelo.comprobarTipo(usuario);

            if(tipo.equals("alumno")){

                conectados.put();

            }else if(tipo.equals("profesor")){


            }

        }else{
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto/s.", "Error en iniciar sesión", JOptionPane.WARNING_MESSAGE);
        }


    }

    public void setHilo(Hilo_IniciarSesion hilo2) {
    }
}
