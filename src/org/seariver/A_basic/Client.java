package org.seariver.A_basic;

import java.io.IOException;
import java.net.Socket;

import static java.lang.System.out;

public class Client {

    public static void main(String[] args) throws IOException {

        var socket = new Socket("localhost", 9090);

        var input = socket.getInputStream();
        var output = socket.getOutputStream();

        output.write("Hello from CLIENT".getBytes());

        var response = new byte[1024];
        input.read(response);

        out.println("From SERVER: " + new String(response).trim());

        input.close();
        output.close();
        socket.close();
    }
}
