package com.github.nez;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    Scanner clientWriter = new Scanner(System.in);
    PrintWriter out;
    BufferedReader in;
    Socket socket;
    int portNumber = 4444;

    public Client(){
        establishConnection();
    }

    public void establishConnection(){
        try{
            this.socket = new Socket("localhost",portNumber);
        }
        catch(Exception e ){
            System.err.println("Fatal Connection error!");
            throw new Error(e);
        }
    }

    @Override
    public void run(){
        speak();
    }

    private void speak() {
        try{
//            this.out = new PrintWriter(socket.getOutputStream(),true);
//            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(!socket.isClosed()){
                String input = new Scanner(System.in).nextLine();
//                System.out.println("you say: "+input);
                out.write(input);
                out.flush();
            }
        }
        catch(Exception e ){
            System.out.println("Error running client...");
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

}//End Client class
