//package com.github.nez;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//
//public class Server implements Runnable {
//
//    private ServerSocket serverSocket;
//    private PrintWriter out;
//    private BufferedReader in;
//    private Socket socket;
//    boolean listening = true;
//    private ArrayList<Client> connectedClients;
//
//    public Server() {
//        try {
//            this.serverSocket = new ServerSocket(4444);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void run() {
//        while (true) {
//            try {
//                this.socket = this.serverSocket.accept();
//                System.out.println(in.readLine());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//
//    public static void main(String args []) {
//        Server server = new Server();
//        server.run();
//    }
//
//}
