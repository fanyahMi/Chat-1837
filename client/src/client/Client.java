/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

import aff.Fenetre;
import detail.MessageUI;
import detail.ReceveMess;
import detail.SendMess;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rakot
 */
public class CLIENT {
        public static String nom;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String ip = JOptionPane.showInputDialog(null, "Entrer l'ip du server");
            nom = JOptionPane.showInputDialog(null, "Entrer votre nom");
            // TODO code application logic here
            Socket so = new Socket(ip, 5000);
            DataOutputStream out = new DataOutputStream(so.getOutputStream());
            DataInputStream input =new DataInputStream(so.getInputStream());
            
            out.writeUTF(nom);    
            SendMess mess = new SendMess(out);
            MessageUI messUI=new MessageUI();
            new ReceveMess(input,messUI);
            
            Fenetre f = new Fenetre(out, input,messUI);
            
            f.init();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
