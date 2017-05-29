/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Peter Henriksen
 */
public class Runner {
        static String IP = "localhost";
        static int port = 8080;
        ServerSocket ss;
        public static int ID = 1;
        
        public void startServer() throws IOException {
            ss = new ServerSocket();
            ss.bind(new InetSocketAddress(IP, port));
            System.out.println("listening on " + IP + " : " + port);
            while(true) {
                Socket socket = ss.accept();
                TurnStileThread t1 = new TurnStileThread(socket);
                t1.start();
            }
        }
        public static void main(String[] args) throws IOException {
        Runner run = new Runner();
        run.startServer();
    }
}
