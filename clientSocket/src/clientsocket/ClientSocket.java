/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientsocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author rakot
 */
public class ClientSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("entrer votre nom: ");
            String nom = scanner.nextLine();
            try {
                Socket sc = new Socket("localhost",1234);
                DataOutputStream dout= new DataOutputStream(sc.getOutputStream());          
                dout.writeUTF(nom);   
                dout.flush();  
                System.out.println("clientsocket.ClientSocket.main()");
            } catch (IOException err) {
            }
        }
    }
       
    
}
