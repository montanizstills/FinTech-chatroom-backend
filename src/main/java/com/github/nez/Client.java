package com.github.nez;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    Scanner clientWriter = new Scanner(System.in);
    PrintWriter out;
    BufferedReader in;
    Socket socket;
    int portnumber = 8081;

    public Client(Socket socket){
        this.socket=socket;
    }

    public void establishConnection(){
        try{
            this.socket = new Socket("localhost",portnumber);
        }
        catch(Exception e ){
            System.err.println("Fatal Connection error!");
            throw new Error(e);
        }
    }

    @Override
    public void run(){
        establishConnection();
        try{
             this.out = new PrintWriter(socket.getOutputStream(),true);
             this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             while(!socket.isClosed()){
                 String input = this.clientWriter.nextLine();
                 System.out.println("you say: "+input);
                 out.write(input);
             }
        }
        catch(Exception e ){
            System.out.println("Error running client...");
        }
    }

    public static void main(String[] args) {
        Client client = new Client(new Socket());
        client.run();
    }

}//End Client class
