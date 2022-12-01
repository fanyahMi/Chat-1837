/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package link;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ni
 */
public class Host {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    public String client;
    
    public Host(){}

    public Host(Socket socket) {
        this.socket = socket;
    }
    
    public void connect() throws IOException{
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        System.out.println("misy soratana");
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
         System.out.println("misy vakina");
        //this.client=bufferedReader.readLine();
        System.out.println(client);
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
            bufferedWriter.write(bufferedReader.readLine());
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);
            if (socket.isConnected()) {
                String mess = scanner.nextLine();
                bufferedWriter.write(client + " : " + mess);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } else{
                    System.out.println("tsy connecter");
                    }
        } catch (IOException e) {
            try {
                disconnect();
            } catch (IOException err) {
                err.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    
    public void readMessage() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {                        
                        String MessGroup = null;
                        if (socket.isConnected()) {
                            try {
                                MessGroup = bufferedReader.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println(MessGroup);
                        }
                    }
                }).start();
    }
    
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("entrer votre nom: ");
        String nom = scanner.nextLine();
        try {
            Socket socket = new Socket("localhost", 1234);
            Host p = new Host(socket);
            
        } catch (Exception err) {
            err.printStackTrace();
        }
    }*/
}
