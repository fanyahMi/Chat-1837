/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package link;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ni
 */
public class HostHandler {

   private Host host;

    public HostHandler(Host h) {
        this.host =h ;
    }
    
   
    public void run() {
       try {
           
           this.host.connect();
           System.out.println("mandeha ny connect");
           this.host.readMessage();
           //this.host.sendMessage();
           System.out.println("mandeha ny read");
           
        System.out.println(this.host.client);
           
           
       } catch (IOException ex) {
           try {
               System.out.println("misy blem de midina ato");
               this.host.disconnect();
           } catch (IOException ex1) {
               Logger.getLogger(HostHandler.class.getName()).log(Level.SEVERE, null, ex1);
           }finally{
            System.out.println("hote deconnecter");
            }
           
       }
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }
    
}
