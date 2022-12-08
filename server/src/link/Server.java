/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package link;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.Port;

/**
 *
 * @author Ni
 */
public class Server {
    
   /* private int port;
    private ServerSocket serverSocket;
    private List<HostHandler> hostHandlerList= new ArrayList<HostHandler>();
    
    public Server(int port) {
        try {
            this.port = port;
            this.serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public  void addHost(Host host){
        HostHandler handler = new HostHandler(host);
        this.hostHandlerList.add(handler);
        handler.run() ;
        
        
    }
    
    public void run(){
        try{
            while(!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                Host newHost= new Host(socket);
                this.addHost( newHost);
                System.out.println("Une nouvelle connexion");
            }
        }catch(IOException EX){
            EX.getStackTrace();
        }
    }
    
    public void close() throws IOException{
        for( HostHandler temp : this.hostHandlerList){
            temp.getHost().disconnect();
        }
    }*/
    
    
    private int port=6666;
    private ServerSocket serverSocket=null;
    private List<Host> hosts=null;

    public Server() {
        this.hosts= new ArrayList<Host>();
    }
    
    public Server(int port) throws IOException{
        this.port = port;
        this.serverSocket = new ServerSocket(port);
        this.hosts= new ArrayList<Host>();
    }
    
    public Server(ServerSocket serverSocket) throws IOException{
        this.serverSocket = serverSocket;
        this.port = serverSocket.getLocalPort();
        this.hosts= new ArrayList<Host>();
    }
    
    public boolean hosted(Host host){
        HostHandler handler= new HostHandler(host,this.hosts);
        boolean isCommunicate = handler.run();
        if(isCommunicate){
            this.hosts.add(host);
        }
        
        return isCommunicate;
    }
    
    public void run(){
        try{
            while(!this.serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                Host newHost = new Host(socket);
                if(this.hosted(newHost)){
                    System.out.println("Une nouvelle connexion au server");
                }else{
                    System.out.println("Connexion échouée ");
                }
                
            }
        }catch(Exception e){
            
        }
    }
    
    
    
}
