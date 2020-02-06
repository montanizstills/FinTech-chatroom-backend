package com.github.nez;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketInstance {
    private final ServerSocket serverSocket;
    private final Socket clientSocket = new Socket("localhost",8081);

    public SocketInstance() throws IOException {
        this.serverSocket= new ServerSocket(8081);
    }

    public Socket getSocketInstance(){
        return clientSocket;
    }
}
