package pspgrupo4;

import java.util.Scanner;

public class Hilo_IniciarSesion extends Thread {

    Scanner s = new Scanner(System.in);

    String nombreUsuario;
    String contraseña;

    public Hilo_IniciarSesion(String nombreUsuario) {

        super(nombreUsuario);
    }

    public void run() {

        System.out.println("Escriba la contraseña.");
        contraseña = s.next();

        if (comprobarUsuarioContraseña(this.nombreUsuario, this.contraseña) == true) {

            System.out.println("Bienvenidx a la aplicación.");
        }

        else {

            System.out.println("Usuario o contraseña incorrecto. Vuelva a intentarlo.");
        }
    }

    public boolean comprobarUsuarioContraseña(String nombreUsuario, String contraseña) {

        //Comprobación de que el usuario exista en la aplicación.
        return true;
    }
}
