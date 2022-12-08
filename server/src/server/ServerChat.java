
package server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import link.Server;

/**
 *
 * @author Ni
 */
public class ServerChat {

    public static void main(String[] args)  {
        try {
            Server server= new Server(6666);
            server.run();
            
        } catch (IOException ioe) {
            
            ioe.printStackTrace();
        }
       
       
        /*try{
            ServerSocket    ServerChat = new ServerSocket(6666);
       Socket  socket = ServerChat.accept();
       
       DataInputStream in = new DataInputStream( new BufferedInputStream(socket.getInputStream()));
       
       String line = "";
       
       while(!line.equals("Over")){
           try {
               line= in.readUTF();
               System.out.println(line);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       }catch(IOException ioEx){
          ioEx.printStackTrace();
       }*/
      
    }
    
}
