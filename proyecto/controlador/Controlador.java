package proyecto.controlador;



import proyecto.*;
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
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class Controlador implements ActionListener, ListSelectionListener {


    Modelo_Usuario modelo;
    IniciarSesion vista = new IniciarSesion(this);
    VistaAlumno vistaAlumno;
    VistaProfesor1 vistaProfesor;
    VistaAgregarCalendario vistaAgregarCalendario;
    UDPMultiChat vistaChat;
    UDPMultiChat2 vistaChat2;
    UsuarioVO usuario;
    String usuario2="";

    public void setModelo(Modelo_Usuario modelo) {
        this.modelo = modelo;
    }
    public void setVista(IniciarSesion vista) {
        this.vista = vista;
    }
    public void setVista(VistaAlumno vista) {
        this.vistaAlumno = vista;
    }
    public void setVista(VistaProfesor1 vista) {
        this.vistaProfesor = vista;
    }
    public void setVista(VistaAgregarCalendario vista) {
        this.vistaAgregarCalendario = vista;
    }
    public void setVista(UDPMultiChat vista) { this.vistaChat = vista; }
    public void setVista(UDPMultiChat2 vista) { this.vistaChat2 = vista; }


    @Override
    public void actionPerformed(ActionEvent e) {

        String aux = e.getActionCommand(), nombre = vista.getTextFieldUsuario().toString();

        usuario = new UsuarioVO(vista.getTextFieldUsuario(), vista.getTextFieldContrasena());
        usuario2=vista.getTextFieldUsuario();

        switch (aux) {

            case "Iniciar sesion":

                try {


                    Hilo_IniciarSesion hilo1= new Hilo_IniciarSesion(usuario);

                    // nombre = vista.getTextFieldUsuario().toString();
                    hilo1.start();


                } catch(Exception m) {

                    m.printStackTrace();
                }



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

                try {
                    ClienteSMTP.main(null);
                    System.exit(0);

                } catch (NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                } catch (UnrecoverableKeyException ex) {
                    ex.printStackTrace();
                } catch (KeyStoreException ex) {
                    ex.printStackTrace();
                } catch (InvalidKeyException ex) {
                    ex.printStackTrace();
                } catch (InvalidKeySpecException ex) {
                    ex.printStackTrace();
                }

                break;

            case "Chat":

              /* vistaChat= new UDPMultiChat(usuario.getNombre());
                vistaChat.setVisible(true);*/
                try {
                    UDPMultiChat.main(null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                break;

            case "Chat Alumno":
                try {
                    UDPMultiChat2.main(null);
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


