/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 *
 * @author rakot
 */
public class FileMessageFormat implements MessageInterface, Serializable{
    private String fileName;
    private  String data; 
    
    public static FileMessageFormat setMessage(File file, String name ) throws FileNotFoundException, IOException{
      
        FileMessageFormat temp = new FileMessageFormat() ;
        temp.fileName = name;

        FileInputStream dataInFile = new FileInputStream(file);
        byte fileData[] = new byte[(int) file.length()];
        dataInFile.read(fileData);
        String dataFileString = encodeFile(fileData);
        dataInFile.close();

        temp.data = dataFileString;
        
        return temp;
    }  
    
    public static void getFile(FileMessageFormat mess) throws IOException{
        
        byte[] dataByte = FileMessageFormat.decodeFile( mess.data);
        
        Path path = Paths.get("D:\\"+mess.fileName);
        Files.write(path, dataByte);
        
        System.out.println("file"
                + "");
    }
    
    public static String encodeFile(byte[] dataByteArray) {
        return Base64.getEncoder().encodeToString(dataByteArray);
    }
    public static byte[] decodeFile(String str) {
        return Base64.getDecoder().decode(str);
    }
     public String toShow(){
         return this.fileName;
     }
}
