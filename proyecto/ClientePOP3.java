package proyecto;

import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;

import java.io.BufferedReader;
import java.io.IOException;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;

public class ClientePOP3 {

    public static void main(String [] args) {

        String server = "localhost", username = "usu1", password = "usu1";
        int puerto = 110;

        POP3SClient pop3 = new POP3SClient();

        try {

            pop3.connect(server, puerto);
            System.out.println("Conexión realizada al servidor POP3 " +server);

            if(!pop3.login(username, password)) {

                System.err.println("Error al hacer login");
            }

            else {

                POP3MessageInfo [] men = pop3.listMessages();

                if (messages == null)

                    System.out.println("Imposible recperar mensajes.");

                else

                    System.out.println("Nº de mensajes: " + men.length);
                    pop3.logout();
            }

            pop3.disconnect();
        } catch (IOException e) {

            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        System.exit(0);
    }

    private static void Recuperarmensajes(POP3MessageInfo [] men, POP3SClient pop3) throws IOException {

        for (int i = 0; i  < men.length; i++)  {

            System.out.println("Mensajes: " + (i+1));
            POP3MessageInfo msginfo = men[i];
            System.out.println("Identificador: " +msginfo.identifier + ", Number: " +msginfo.number + " , tamaño: " +msginfo.size);
            System.out.println("Prueba de listUniqueIdentifier: ");
            POP3MessageInfo pmi = pop3.listUniqueIdentifier(i+1);
            System.out.println("\tIdentificador: " +pmi.identifier + " , number: " +pmi.number + " , tamaño: " +pmi.size);
        }
    }

    private static void RecuperarCabeceras(POP3MessageInfo [] men, POP3SClient pop3) throws IOException {

        for(int i = 0; i < men.length; i++) {

            System.out.println("Mensajes: " + (i+1));
            POP3MessageInfo msginfo = men[i];

            System.out.println("Cabecera del mensaje:" );
            BufferedReader reader = (BufferedReader) pop3.retrieveMessageTop(msginfo.number, 0);
            String linea;
            while ((linea = reader.readLine()) != null)

                System.out.println(linea.toString());
                reader.close();
        }
    }
}
