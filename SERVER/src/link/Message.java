/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package link;

/**
 *
 * @author rakot
 */
import java.io.IOException;
import server.SERVER;
public class Message extends Thread{
    Client c;
    public Message(Client c) {
        this.c = c;
        start();
    }

    @Override
    public void run() {
        while (true) {            
            try {
                String mess = this.c.getIn().readUTF();
                sendMessage(mess);
            } catch (IOException e) {
                SERVER.allClient.remove(c);
                e.printStackTrace();
            }
        }
    }
    
    private void sendMessage(String mess) throws IOException{
        for (Client client : SERVER.allClient) {
            if(!this.c.equals(client)){
                 client.getOut().writeUTF(mess);
            }
           
        }
    }
    
    
    
}
