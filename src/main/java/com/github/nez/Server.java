package com.github.nez;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nez.FinancialObjects.SpecializedFinanicalObjectShort.Quote;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable {

    private ServerSocket serverSocket = null;
    private PrintWriter out;
    private BufferedReader in;
    private Socket socket;
    boolean listening = true;
    private ArrayList<Client> connectedClients;

    public Server() {
    }

    public void run() {
        try {
            this.serverSocket = new ServerSocket(8081);
            while (listening) {
                this.socket = serverSocket.accept();
                in = socket.getInputStream()
            }
        } catch (Exception e) {
            throw new Error("could not listen on port: " + serverSocket.getLocalPort());
        }
    }

    private void acceptClients() {
        try {

        }
        catch (Exception e) {
            System.out.println("Accept failed on: " + this.serverSocket.getLocalPort());
        }
    }

    public void speak(){
        try{
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response=in.readLine();
            if(!"".equals(response)){
                System.out.println(response);
            }
        }
        catch(Exception e){
            throw new Error(e);
        }
    }
//    public String decipherMessage(String message) {
//        String response = "";
//        String[] messageArray = message.split(" ");
//        for (String word : messageArray) {
//            if (word.matches("\\$[a-zA-Z]+\\.[a-zA-Z]+")) {
//                String[] requestArray = word.split("[$|.]");
//                String companyName = requestArray[1];
//                String serviceName = requestArray[2];
//
//                Quote quote = new Quote();
//                quote.populateJsonObject(companyName, "quote");
//
//                try {
//                    ObjectMapper objectMapper = new ObjectMapper();
//                    quote = (Quote) objectMapper.readValue(quote.getJsonObject().toString(), quote.getObjectClass());
//                } catch (Exception e) {
//                    System.out.println("Something is off in the ObjectMapping.");
//                }
//
//                try {
//                    Method method = quote.getClass().getMethod(serviceName);
//                    response += " " + method.invoke(quote, null).toString();
//                } catch (Exception e) {
//                    System.out.println("Something is off getting the method. Returning word");
//                    response += " " + word;
//                }
//            } else {
//                response += " " + word;
//            }
//        }
//        return response;
//    }

    public static void main(String args []) {
        Server server = new Server();
        server.run();
    }

}
