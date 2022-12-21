/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lisner;

import client.CLIENT;
import detail.Message;
import detail.MessageHandler;
import detail.MessageUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JTextField;

/**
 *
 * @author rakot
 */
public class Lisner implements ActionListener{

    public MessageHandler messageHandler;
    public Lisner(JTextField text, ObjectOutputStream output, ObjectInputStream input) {
        this.text = text;
        this.output = output;
        this.input = input;
    }
   public  MessageUI messageUI;
    JTextField text;
    ObjectOutputStream output;
    ObjectInputStream input;

    @Override
    public void actionPerformed(ActionEvent e) {
        //String message=text.getText();
         
        try {
            if(messageHandler.getMessage()==null || messageHandler.getMessage().getType()!= Message.FILE_TYPE){
             messageHandler.setMessage(new Message());
             messageHandler.getMessage().initText(text.getText());
            }
            messageHandler.getMessage().setUtilisateur(CLIENT.nom );
            output.writeObject(messageHandler.getMessage());
            output.flush();
            text.setText("");
            
            /*output.writeUTF(CLIENT.nom +": "+message+"\n");
            output.flush();
            text.setText("");*/
            messageUI.afficherMessUi( messageHandler.getMessage());
            messageHandler.setMessage(null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
