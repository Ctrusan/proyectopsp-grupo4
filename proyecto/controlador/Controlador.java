package proyecto.controlador;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import proyecto.ClienteSMTP;
import proyecto.FTP;
import proyecto.Hilo_IniciarSesion;
import proyecto.UDPMultiChat;
import proyecto.modelo.CalendarioVO;
import proyecto.modelo.Modelo_Usuario;
import proyecto.modelo.UsuarioVO;
import proyecto.vista.*;
import servidores.clienteFicheros;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controlador implements ActionListener, ListSelectionListener {

    ArrayList<String> calendario = new ArrayList<String>();
    Modelo_Usuario modelo;
    IniciarSesion vista;
    VistaAlumno vistaAlumno;
    VistaProfesor2 vistaProfesor;
    VistaAgregarCalendario vistaAgregarCalendario;
    VistaEnviarCorreo vistaEnviarCorreo;
    UDPMultiChat vistaChat;
    UsuarioVO usuario = new UsuarioVO();
    String usuario2 = "";
    UsuariosConectados usConectados = new UsuariosConectados();
    Hilo_IniciarSesion hilo1 = null;


    Scanner sc = new Scanner(System.in);

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

    public void setHilo(Hilo_IniciarSesion hilo) {
        this.hilo1 = hilo;
    }

    public Hilo_IniciarSesion getHilo1() {
        return hilo1;
    }

    public void setVista(UDPMultiChat vista) {
        this.vistaChat = vista;
    }

    public void setVista(VistaEnviarCorreo vistaEnviarCorreo) { this.vistaEnviarCorreo = vistaEnviarCorreo; }

    @Override
    public void actionPerformed(ActionEvent e) {


        String aux = e.getActionCommand();


        if (aux.equals("Iniciar sesion")) {

            usuario = new UsuarioVO(vista.getTextFieldUsuario(), vista.getTextFieldContrasena());

            this.setHilo(new Hilo_IniciarSesion(usConectados, usuario));
            hilo1.start();

            if (modelo.comprobar(usuario) == true) {
                usuario2 = this.modelo.comprobarTipo(usuario);

                if (usuario2.equals("alumno")) {
                    this.setVista(new VistaAlumno(this));

                    if (hilo1.getConectados().get() <= 4) {
                        calendario = modelo.listaCalendario();
                        vistaAlumno.actualizarCalendario(calendario);
                        vistaAlumno.setVisible(true);
                    } else {

                        JOptionPane.showMessageDialog(null, "No se pueden conectar más de 3 alumnos a la vez.", "Error en iniciar sesión", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    this.setVista((new VistaProfesor2(this)));
                    calendario = modelo.listaCalendario();
                    vistaProfesor.actualizarCalendario(calendario);
                    vistaProfesor.setVisible(true);

                }
            }
        } else if (aux.equals("Crear calendario")) {

            this.setVista(new VistaAgregarCalendario(this));
            vistaAgregarCalendario.setVisible(true);
        } else if (aux.equals("Crear")) {

            CalendarioVO calendario = new CalendarioVO();
            calendario.setNombre(vistaAgregarCalendario.getTextFieldNombreCalendario());
            calendario.setContenido(vistaAgregarCalendario.getTextFieldDescripcionCalendario());

            this.setModelo(new Modelo_Usuario());
            modelo.añadirCalendario(calendario);
        } else if (aux.equals("Cancelar")) {

            vistaAgregarCalendario.dispose();
        } else if (aux.equals("Cerrar sesion")) {
/*
            vistaAlumno.dispose();
            this.hilo1.getConectados().setCantidad(this.hilo1.getConectados().get());
            try {
                ClienteSMTP.main(null);
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
            //System.exit(0);*/
        } else if (aux.equals("Chat")) {

            try {
                UDPMultiChat chatuser = new UDPMultiChat("user");
                System.out.println("Entrando ususario");
                String nombrechat = usuario.getNombre();
                // Se crea el socket multicast

                chatuser.setMs(new MulticastSocket(12345));
                chatuser.setGrupo(InetAddress.getByName("225.0.0.1"));// Grupo

                // Nos unimos al grupo
                chatuser.getMs().joinGroup(chatuser.getGrupo());
                if (!nombrechat.trim().equals("")) {
                    UDPMultiChat server = new UDPMultiChat(nombrechat);
                    server.setBounds(0, 0, 540, 400);
                    server.setVisible(true);
                    new Thread(server).start();

                }
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }


        } else if (aux.equals("FTP")) {

            try {
                FTP.main(null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if ( aux.equals("Serv Archivos")){


            try{
                clienteFicheros.main(null);
            }catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "El servidor no está habilitado, inténtelo más tarde"," Error", JOptionPane.WARNING_MESSAGE);

            }
        } else if(aux.equals("Enviar Correo")){

                this.setVista(new VistaEnviarCorreo(this));
                vistaEnviarCorreo.setVisible(true);

        } else if( aux.equals("Enviar")){
            String to= vistaEnviarCorreo.getTo();
            String asunto= vistaEnviarCorreo.getAsunto();
            String mensaje= vistaEnviarCorreo.getMensaje();

            ClienteSMTP cliente = new ClienteSMTP();
            cliente.enviarCorreo(to,asunto,mensaje);



        }

    }
    @Override
    public void valueChanged(ListSelectionEvent e) {


    }
}
