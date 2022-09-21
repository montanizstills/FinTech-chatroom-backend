package io.github.montanizstills;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final Integer port;
    private Socket socket;
    private ServerSocket serverSocket;

    private DataInputStream dataInputStream;


    public Server(Integer port) {
        this.port = port;
    }


    /**
     * Will attempt to close the ServerSocket of this instance.
     */
    public void close() {
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            System.out.println("Failed closing server socket..\n");
            throw new Error(e);
        }
    }

    /**
     * Will attempt to establish a connection between the server and the client.
     */
    private void accept(Integer port) {
        try {
            this.serverSocket = new ServerSocket(port);
            this.socket = this.serverSocket.accept();
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    /**
     * Facade -- accept(int port)
     */
    public void accept() {
        this.accept(this.port);
    }

    /**
     * Will read the contents of the DataInputStream and convert into a String.
     *
     * @return The decoded String version of the DataInputStream's contents.
     */
    public String read() {
        String message;
        try {
            this.dataInputStream = new DataInputStream(this.socket.getInputStream());
            message = this.dataInputStream.readUTF();
        } catch (IOException e) {
            throw new Error(e);
        }
        return message;
    }

    /**
     * A socket is an endpoint for communications between machines.
     * Will retrieve the Socket for this instance of a server.
     *
     * @return The instance's socket.
     */
    public Socket getSocket() {
        return this.socket;
    }

    /**
     * Will retrieve the ServerSocket for this instance.
     *
     * @return This instance's ServerSocket.
     */
    public ServerSocket getServerSocket() {
        return this.serverSocket;
    }

    /**
     * Will retrieve the DataInput stream for this instance.
     *
     * @return This instance's DataInputStream.
     */
    public DataInputStream getDataInputStream() {
        return dataInputStream;
    }

    public Integer getPort() {
        return port;
    }

    public static void main(String[] args) {
        Server server = new Server(1234);
        String message;
        server.accept();
        while (true) {
            System.out.println(message=server.read());
            if ("q".equalsIgnoreCase(message)){
                server.close();
            }
        }
    }

}

