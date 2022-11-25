
package socket;

import datos.RecaudoDAO;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorSocket {

        public static void main(String[] args) {

            new ServidorS();
        /*ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        
        RecaudoDAO recaudoDao = new RecaudoDAO();

        //puerto de nuestro servidor
        final int PUERTO = 1000;

        try {
            //Creamos el socket del servidor
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            //Siempre estara escuchando peticiones
            while (true) {

                //Espero a que un cliente se conecte
                sc = servidor.accept();

                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                //Leo el mensaje que me envia
                String mensaje = in.readUTF();

                System.out.println(recaudoDao.selectByRef(mensaje));

                //Le envio un mensaje
                //out.writeUTF(recaudoDao.selectByRef(mensaje));
                out.writeUTF("Envio prueba3");
                //Cierro el socket
                sc.close();
                //servidor.close();
                System.out.println("Cliente desconectado");

            }
            
           
            
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        */

    }
}
