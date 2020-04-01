package proyecto.controlador;



import proyecto.FTP;
import proyecto.Hilo_IniciarSesion;
import proyecto.UDPMultiChat;
import proyecto.modelo.CalendarioVO;
import proyecto.modelo.Modelo_Usuario;
import proyecto.modelo.UsuarioVO;
import proyecto.vista.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class Controlador implements ActionListener, ListSelectionListener {


    Modelo_Usuario modelo;
    IniciarSesion vista;
    VistaAlumno vistaAlumno;
    VistaProfesor2 vistaProfesor;
    VistaAgregarCalendario vistaAgregarCalendario;
    UDPMultiChat vistaChat;
    UsuarioVO usuario = new UsuarioVO();
    String usuario2="";
    UsuariosConectados usConectados = new UsuariosConectados();

    public void setModelo(Modelo_Usuario modelo) {
        this.modelo = modelo;
    }
    public void setVista(IniciarSesion vista) {
        this.vista = vista;
    }
    public void setVista(VistaAlumno vista) {
        this.vistaAlumno = vista;
    }
    public void setVista(VistaProfesor2 vista) {
        this.vistaProfesor = vista;
    }
    public void setVista(VistaAgregarCalendario vista) {
        this.vistaAgregarCalendario = vista;
    }
    public void setVista(UDPMultiChat vista) { this.vistaChat = vista; }

    @Override
    public void actionPerformed(ActionEvent e) {

        String aux = e.getActionCommand();

        switch (aux) {

            case "Iniciar sesion":

                        usuario = new UsuarioVO(vista.getTextFieldUsuario(), vista.getTextFieldContrasena());
                                    usuario2=vista.getTextFieldUsuario();
                                    Hilo_IniciarSesion hilo1= new Hilo_IniciarSesion(usConectados, usuario);

                                    hilo1.start();

                                    break;

            case "Crear calendario":


                        this.setVista(new VistaAgregarCalendario(this));
                        vistaAgregarCalendario.setVisible(true);
                        break;

            case "Crear":

                CalendarioVO calendario= new CalendarioVO();
                calendario.setNombre(vistaAgregarCalendario.getTextFieldNombreCalendario());
                calendario.setContenido(vistaAgregarCalendario.getTextFieldDescripcionCalendario());

                this.setModelo(new Modelo_Usuario());
                        modelo.añadirCalendario(calendario);

                        break;

            case "Cancelar":

                vistaAgregarCalendario.dispose();
                break;

            case "Cerrar sesion":

                System.exit(0);
                break;

            case "Chat":

            //    vistaChat= new UDPMultiChat("");
             //   vistaChat.setVisible(true);
                try {
                    UDPMultiChat.main(null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                break;

            case "FTP":
                try {
                    FTP.main(null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {


    }
}


