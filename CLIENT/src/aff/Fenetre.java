/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aff;

import detail.MessageUI;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
    public Fenetre(DataOutputStream output,DataInputStream input,MessageUI messUI ){
        JPanel Panel = new JPanel();
        text=new JTextField();
        this.messUI = messUI;
        JScrollPane pane = new JScrollPane();
        pane.setViewportView(messUI.textArea);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        Lisner lisn=new Lisner(text, output, input);
        lisn.messageUI = this.messUI;
        AjoutFile ajout= new AjoutFile();
        
        
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
        this.setSize(1000, 1000);
        this.setVisible(true);
    }
}
