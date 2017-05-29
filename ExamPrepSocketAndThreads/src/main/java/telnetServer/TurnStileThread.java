/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter Henriksen
 */
public class TurnStileThread extends Thread {
    Socket socket;
    finalCount fc = new finalCount();
    public TurnStileThread(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try{
            PrintWriter pw;
            Scanner sc;
            boolean stop = false;
            pw = new PrintWriter(socket.getOutputStream(), true);
            sc = new Scanner(socket.getInputStream());
            TurnStile t = new TurnStile();
            pw.println("hello counter " + Runner.ID);
            Runner.ID++;
            while(true) {
                pw.println("How many spectators did you count today? ");
                String answer = sc.nextLine();//blocking call 
                fc.countSum(Integer.parseInt(answer));
                pw.println("Thanks! press any button to see the total amount of spectators");
                String answer2 = sc.nextLine();
                pw.println("The total amount of spectators on Liberty Stadium is " + fc.getCount());
                String answer3 = sc.nextLine();
                pw.println("Succesfully logged out");
                System.out.println("counter " + Runner.ID + " logged out" );
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
