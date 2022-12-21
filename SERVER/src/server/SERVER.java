/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import link.Client;
import link.Operation;

/**
 *
 * @author rakot
 */
public class SERVER {

   public static List<Client> allClient=new ArrayList<>();
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket server = new ServerSocket(5000);
            Socket sc;
            /// ObjectInputStream in;
            Client c;
            System.out.println("serever pret");
            while (true) {

                sc = server.accept();
                ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
                out.flush();
                ObjectInputStream in = new ObjectInputStream(sc.getInputStream());
                //System.out.print(in);
                c = new Client();
                c.setNom(in.readUTF());
                c.setIn(in);
                c.setOut(out);
                System.out.println("nouveau client ajouter");
                
                new Operation(c);
                allClient.add(c);
      
            }
        } catch (Exception err) {
            err.printStackTrace();
        }

    }
    
}
