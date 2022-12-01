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

/**
 *
 * @author Rakot
 */
public class Server {
    
    private ServerSocket serverSocket;
    private List<HostHandler> hostHandlerList= new ArrayList<>();
    
    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }
    
    public  void addHost(Host host){
        HostHandler handler = new HostHandler(host);
        handler.run() ;
        System.out.println("link.Server.addHost()");
        this.hostHandlerList.add(handler);
        
    }
    
    public void run(){
        try{
            while(!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                //System.out.println("link.Server.run()");
                Host newHost= new Host(socket);
                
                System.out.println("Une nouvelle connexion");
                this.addHost( newHost);
            }
        }catch(IOException EX){
            EX.getStackTrace();
        }
    }
    
    public void close() throws IOException{
        for( HostHandler temp : this.hostHandlerList){
            temp.getHost().disconnect();
        }
    }
}
