/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detail;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author rakot
 */
public class MessageUI {    
    ArrayList<String> messages = new ArrayList<>();
    public JTextArea textArea = new JTextArea(50, 50);
     public MessageUI() {
        this.messages = new ArrayList<>();
        
    }

    public void afficherMessUi(String message) {
        messages.add(message);
        System.out.println("impiry");
        this.textArea.append(message + "\n");
        
    }
}
