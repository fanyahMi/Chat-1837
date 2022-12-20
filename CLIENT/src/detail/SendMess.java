/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package detail;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import client.CLIENT;
/**
 *
 * @author rakot
 */
public class SendMess extends Thread{
    DataOutputStream output;

    public SendMess(DataOutputStream out) {
        this.output = out;
    }

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                output.writeUTF(CLIENT.nom +": "+scan.next());

            } catch (IOException err) {
                throw new RuntimeException(err);
            }
        }
    }
}
