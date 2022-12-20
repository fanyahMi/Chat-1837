/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lisner;

import client.CLIENT;
import detail.MessageUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author rakot
 */
public class Lisner implements ActionListener{

    public Lisner(JTextField text, DataOutputStream output, DataInputStream input) {
        this.text = text;
        this.output = output;
        this.input = input;
    }
   public  MessageUI messageUI;
    JTextField text;
    DataOutputStream output;
    DataInputStream input;

    @Override
    public void actionPerformed(ActionEvent e) {
        String message=text.getText();
        try {
            output.writeUTF(CLIENT.nom +": "+message+"\n");
            output.flush();
            text.setText("");
            messageUI.afficherMessUi( message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
