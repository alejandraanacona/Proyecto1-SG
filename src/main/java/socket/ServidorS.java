package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import datos.ClientesDAO;
import datos.RecaudoDAO;

public class ServidorS {


	ServerSocket servidor = null;
    Socket sc = null;
    DataInputStream in;
    DataOutputStream out;

    RecaudoDAO recaudoDao = new RecaudoDAO();
    ClientesDAO clienteDao = new ClientesDAO();

    //puerto de nuestro servidor
    final int PUERTO = 5000;

	public ServidorS() {
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

                //System.out.println(recaudoDao.selectByRef(mensaje));
                String mensaje1=recaudoDao.selectByRef(mensaje);

                String string = mensaje1;
            	String[] parts = string.split(",");
            	String id    = parts[0];
                String noref = parts[1];
            	String valor = parts[2];
            	String fecha = parts[3];

            	String mensaje2 = clienteDao.devolverString(Integer.parseInt(id));
            	System.out.println("este es el mensaje2: " + mensaje2);

            	String mensaje3 = noref + "," + valor + "," + fecha + "," + mensaje2;

                //Le envio un mensaje
                //out.writeUTF(recaudoDao.selectByRef(mensaje));
            	out.writeUTF(mensaje3);
                //out.writeUTF("mensaje de vuelta");
                System.out.println("este es el mensaje 3: "+ mensaje3);

                //Cierro el socket

                //in.close();
                //out.flush();

                //sc.close();
                //servidor.close();

                System.out.println("Cliente desconectado");


            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
	}

}

