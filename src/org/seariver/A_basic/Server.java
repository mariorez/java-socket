package org.seariver.A_basic;

import java.io.IOException;
import java.net.ServerSocket;

import static java.lang.System.out;

public class Server {

    public static void main(String[] args) throws IOException {

        var serverSocket = new ServerSocket(9090);

        out.println("SEVER started ...");

        var socket = serverSocket.accept();

        var input = socket.getInputStream();
        var output = socket.getOutputStream();

        var request = new byte[1024];
        input.read(request);
        out.println(new String(request).trim());

        output.write("Hello from SERVER".getBytes());

        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }
}
