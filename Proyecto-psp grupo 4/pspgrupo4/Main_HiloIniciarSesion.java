package pspgrupo4;

import java.util.Scanner;

public class Main_HiloIniciarSesion {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Introduzca el nombre usuario.");

        String nombre = s.next();

        Hilo_IniciarSesion h1 = new Hilo_IniciarSesion(nombre);

        h1.start();
    }
}
