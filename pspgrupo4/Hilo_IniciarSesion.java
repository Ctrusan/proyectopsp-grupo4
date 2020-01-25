import modelo.UsuarioVO;

import java.util.Scanner;

public class Hilo_IniciarSesion extends Thread {

    Scanner s = new Scanner(System.in);
    UsuarioVO usuario = new UsuarioVO();

    public Hilo_IniciarSesion(UsuarioVO usuario) {

        this.usuario = usuario;
    }

    public void run() {

        try {

        if (comprobarUsuarioContraseña(usuario.getNombre(), usuario.getContrasena()) == true) {

                sleep(2000);
                System.out.println("Bienvenidx a la aplicación.");
        }

        else {

            System.out.println("Usuario o contraseña incorrecto. Vuelva a intentarlo.");
        }

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public boolean comprobarUsuarioContraseña(String nombreUsuario, String contraseña) {

        //Comprobación de que el usuario exista en la aplicación.
        //Consultar en la base de datos y devolver true si existe.
        return true;
    }
}
