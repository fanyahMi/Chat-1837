/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detail;

import java.util.ArrayList;
import javax.swing.JTextArea;
import client.CLIENT;

/**
 *
 * @author rakot
 */
public class MessageUI {    
    ArrayList<String> messages = new ArrayList<>();
    public JTextArea textArea = new JTextArea(50, 50);
     public MessageUI() {
        this.messages = new ArrayList<>();
        textArea.setEditable(false);
    }

    public void afficherMessUi(String message) {
        messages.add(message);

        this.textArea.append(message + "\n");
        
    }
    
    public void afficherMessUi(Message message) {
        //messages.add(message);
        String nomag="";
        if(!message.getUtilisateur().equals(CLIENT.nom)){
            nomag= message.getUtilisateur()+": ";
        }
        
        if(message.getType()!=Message.TEXT_TYPE){
            this.textArea.append(nomag+message.getBody().toShow() + "\n");
        }else{
            this.textArea.append(nomag+message.getSimpleMessage() + "\n");
        }
        
        
        
    }
}
