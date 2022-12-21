/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package link;

/**
 *
 * @author rakot
 */
import detail.Message;
import java.io.IOException;
import server.SERVER;
public class Operation extends Thread{
    Client c;
    public Operation(Client c) {
        this.c = c;
        start();
    }

    @Override
    public void run() {
        while (true) {            
            try {
                Message mess = (Message) this.c.getIn().readObject();
                sendMessage(mess);
            } catch (Exception e) {
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
    private void sendMessage(Message mess) throws IOException{
        for (Client client : SERVER.allClient) {
            if(!this.c.equals(client)){
                 client.getOut().writeObject(mess);
            }
           
        }
    }
    
    
    
}
