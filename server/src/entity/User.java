/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Ni
 */
public class User {
    private String ip;
    private String id;
    private String name;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public User() {
    }

    /*
    * parametre user = {
    *   ip: ip,
    *   id: id,
    *   name: nom
    *}{id:fa,nom:fanyh}otrzao ny omena
    *
    */
    public static User getUser(String userStr){
        User newUser = null;
        if(isUser(userStr)){
            newUser = new User(); 
            //enlever les espaces
            userStr= userStr.trim();
            // transformer string user en objet user

            String[] userTab = userStr.substring(0, userStr.length()-1).split(",");
            
            for(String u :  userTab){
                System.out.println(u);
            }
            newUser.ip= userTab[0].substring(userTab[0].indexOf(":")+1);
            newUser.id= userTab[1].substring(userTab[1].indexOf(":")+1);
        }
        return newUser ;
     
    }
    
    public static boolean isUser(String userStr){
        return userStr.contains("id") && userStr.contains("ip");
    }
    
    
    
}
