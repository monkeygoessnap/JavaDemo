package server;

import java.net.*;
import java.io.*;
import controller.*;

public class Server {

    private static final int portNum = 3333;
    ServerSocket server;
    public static Bank abcBank;

    public void run() {

        abcBank = new Bank();

        try {
            server = new ServerSocket(portNum);
            System.out.println("Starting socket server at port: " + portNum);
            //generate new thread for every connected client
            while (true) {
                Socket s = null;
                try {
                    s = server.accept();
                    System.out.println("A new client is connected: " + s);
                    DataInputStream din = new DataInputStream(s.getInputStream());
                    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                    Thread t = new ClientHandler(s, din, dout, abcBank);
                    t.start();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            System.out.println("Program terminating..");
            System.exit(0);
        }
    }
}
