/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detail;

import java.io.DataInputStream;

/**
 *
 * @author rakot
 */
public class ReceveMess extends Thread{
DataInputStream input;
MessageUI messageUI;
    public ReceveMess(DataInputStream input,MessageUI messUI) {
        this.input = input;
        this.messageUI = messUI;
        start();
    }
    

    @Override
    public void run(){
        String message;
        while (true) {            
            try {
                message=input.readUTF();
                System.out.print(message);
                messageUI.afficherMessUi( message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
