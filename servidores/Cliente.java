package servidores;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String [] args) throws IOException {

       /* int puerto = 44441;
        Socket s = new Socket("localhost", puerto);
        clienteFicheros hiloC = new ClienteFicheros(s);
        hiloC.setBounds(0,0,540,500);
        hiloC.setVisible(true);
        new Thread(hilOC).start();
    }

    static Socket socket;
    EstructuraFicheros nodo = null;
    ObjectInputStream inObjeto;
    ObjectOutputStream outObjeto;
    EstructuraFicheros Raiz;

    static JList lisaDirec = new JList();

    static String direcSelec = "";
    static String ficheroSelec = "";
    static String ficherocompleto = "";

    public clienteFicheros(Socket s) throws IOException {

        super("SERVIDOR DE FICHEROS BÁSICOS");
        socket = s;

        try {

            outObjeto = new ObjectOutputStream(socket.getOutputStream());
            inObjeto = new ObjectInputStream(socket.getInputStream());

        } catch(IOException e) {

            e.printStackTrace();
            System.exit(0);
        }
    */}
}
