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
    private List<Host> listHost;
   private Host host;

    public HostHandler(Host h, List<Host> listHost) {
        this.host =h ;
        this.listHost = listHost;
    }
    
   
    public boolean run() {
       try {
           this.host.connect();
           this.host.readMessage(this.listHost);
           
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           /*try {
               this.host.disconnect();
           } catch (IOException ex1) {
               Logger.getLogger(HostHandler.class.getName()).log(Level.SEVERE, null, ex1);
           }finally{
            System.out.println("hote deconnecter");
            }*/
           
       }
       return false;
    }
    
    /*
    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }*/
    
}
