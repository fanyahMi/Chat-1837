/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detail;

import java.io.ObjectInputStream;

/**
 *
 * @author rakot
 */
public class ReceveMess extends Thread{
ObjectInputStream input;
MessageUI messageUI;
    public ReceveMess(ObjectInputStream input,MessageUI messUI) {
        this.input = input;
        this.messageUI = messUI;
        start();
    }
    

    @Override
    public void run(){
        //String message;
        Message message;
        while (true) {            
            try {
                message = (Message) input.readObject();
                /*message=input.readUTF();
                System.out.print(message);
                messageUI.afficherMessUi( message);*/
                messageUI.afficherMessUi( message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
