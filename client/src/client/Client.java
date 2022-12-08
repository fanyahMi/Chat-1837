/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Ni
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)  {
        try {
            Socket socket= new Socket("localhost",6666);
            
            DataInputStream  input  = new DataInputStream(System.in);
            DataOutputStream out    = new DataOutputStream(socket.getOutputStream());
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            
           
            
            new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        String line="";
                        while (!line.equals("Over")){
                                try {
                                    line=input.readLine();
                                    out.writeUTF(line);
                                } catch (Exception e) {
                                     e.printStackTrace();
                                }

                            }
                    }
                }
            ).start();
            new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        String line="";
                       
                        while (!line.equals("Over")){
                             System.out.println("lasaaaaa");
                                try {
                                    line=inStream.readLine();
                                    System.out.println(line);
                                } catch (Exception e) {
                                     e.printStackTrace();
                                }

                            }
                    }
                }
            ).start();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
    }
    
}
