/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package link;

import entity.User;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Ni
 */
public class Host {
    /*private Socket socket;
    private DataInputStream bufferedReader;
    private BufferedWriter bufferedWriter;
    private String client;
    
    public Host(){}

    public Host(Socket socket) {
        this.socket = socket;
    }
    
    public void connect() throws IOException{
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        this.bufferedReader =  new DataInputStream( new BufferedInputStream(socket.getInputStream()));
    }
    
    public void disconnect() throws IOException{
        if(socket!= null || socket.isConnected()){
            this.bufferedReader.close();
            this.bufferedWriter.close();
            socket.close();
        }
    }
    public void sendMessage() {
        try {
            bufferedWriter.write(client);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()) {
                String mess = scanner.nextLine();
                bufferedWriter.write(client + " : " + mess);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            try {
                disconnect();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }
    
*/
    

    
    private User user = null;
    private Socket socket;
    private DataInputStream readerStream;
    private DataOutputStream writerStream;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataInputStream getReaderStream() {
        return readerStream;
    }

    public void setReaderStream(DataInputStream readerStream) {
        this.readerStream = readerStream;
    }

    public DataOutputStream getWriterStream() {
        return writerStream;
    }

    public void setWriterStream(DataOutputStream writerStream) {
        this.writerStream = writerStream;
    }

    public Host() {
    }

    public Host(Socket socket) {
        this.socket = socket;
    }
    
    public void connect() {
        try {
            this.readerStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            this.writerStream = new DataOutputStream(socket.getOutputStream());
            this.indentification();
           
        } catch (IOException e) {
            e.printStackTrace();
            try{
                this.closeStream();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
            
        }
      
    }
    
    private void closeStream() throws IOException{
         this.readerStream.close();
         this.writerStream.close();
    }
    
    private void indentification(){
       String line = "";
       int cnx = 0;
       while(this.user == null){
           try {
               line= this.readerStream.readUTF();
               this.user= User.getUser(line);
               cnx++;
           } catch (Exception e) {
               e.printStackTrace();
           }
       }

    }
    
    public void readMessage(List<Host> hosts) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {                        
                        String MessGroup;
                        while (socket.isConnected()) {
                            try {
                                String msg= user.getId()+" = "+readerStream.readUTF();
                                System.out.println("------ " + user.getId());
                                
                                for(int i=0, taille= hosts.size(); i< taille ; i++ ){
                                    if(!hosts.get(i).socket.isClosed() && !hosts.get(i).equals(this)){
                                        hosts.get(i).sendMessage( msg); 
                                    }
                                }
                            } catch (Exception e) {
                                 e.printStackTrace();
                             
                             
                                    
                                
                            }
                        }
                    }
                }).start();
    }
    
    /*public void sendMessage(List<Host> hosts, String msg) {
        try {

            
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    
    public void sendMessage(String msg) throws IOException{
        System.out.println(msg);
        this.writerStream.writeUTF(msg);
        this.writerStream.flush();        
    }
}
