/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lisner;

import detail.Message;
import detail.MessageHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 *
 * @author rakot
 */
public class AjoutFile implements ActionListener{
    public JTextField text;
    public MessageHandler messageHandler;
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            text.setText(selectedFile.getName());     
            messageHandler.setMessage(new Message());
            try {
                messageHandler.getMessage().initFile( selectedFile,  selectedFile.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}


