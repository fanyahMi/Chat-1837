/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detail;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author rakot
 */
public class Message  implements Serializable{
    
    public static int FILE_TYPE = 0;
    public static int TEXT_TYPE = 1;
    
    
    private String utilisateur;
    private int type;
    private MessageInterface body;
    private String simpleMessage;

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public MessageInterface getBody() {
        return body;
    }

    public void setBody(MessageInterface body) {
        this.body = body;
    }

    public String getSimpleMessage() {
        return simpleMessage;
    }

    public void setSimpleMessage(String simpleMessage) {
        this.simpleMessage = simpleMessage;
    }
    
    public void initFile(File file, String name) throws IOException{
        this.type = Message.FILE_TYPE;
        this.body = FileMessageFormat.setMessage(file,  name );
    }
    
    public void initText(String mess) {
        this.type = Message.TEXT_TYPE;
        this.simpleMessage = mess;
    }
    
}
