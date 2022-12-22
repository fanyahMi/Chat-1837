/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aff;

import detail.MessageHandler;
import detail.MessageUI;
import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import lisner.Lisner;
import lisner.AjoutFile;

/**
 *
 * @author rakot
 */
public class Fenetre extends JFrame{
    JTextField text;
    public MessageUI messUI;
    public MessageHandler messageHandler = new MessageHandler();
    
    
    public Fenetre(ObjectOutputStream output,ObjectInputStream input,MessageUI messUI ){
        JPanel Panel = new JPanel();
        text=new JTextField();
        this.messUI = messUI;
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(messUI.textArea);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        Lisner lisn=new Lisner(text, output, input);
        lisn.messageUI = this.messUI;
        lisn.messageHandler = this.messageHandler;
        AjoutFile ajout= new AjoutFile();
        ajout.messageHandler = this.messageHandler;
        ajout.text = text;
        
        
        JButton envoie=new JButton("Envoyer");
        JButton fichier=new JButton("FILE");
        envoie.addActionListener(lisn);
        fichier.addActionListener(ajout);
        
        text.setBounds(50, 50, 300, 30);
        envoie.setBounds(350, 50, 70, 30);
        fichier.setBounds(420, 50, 70, 30);
        
        
        Panel.add(text);
        Panel.add(envoie);
        Panel.add(fichier);  
        Panel.add(pane);
        
        
        
        Panel.setLayout(null);
        Panel.setBorder(border);
        Panel.setBounds(50, 50, 700, 700);
        pane.setBounds(50, 125, 500, 500);
        
        
        this.add(Panel);
        
    }

    public void init() {
        this.setLayout(null);
        this.setSize(900, 900);
        this.setVisible(true);
    }
}
