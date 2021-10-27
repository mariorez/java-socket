package org.seariver.B_single_threaded;

import java.io.IOException;
import java.net.Socket;

import static java.lang.System.out;

public class Client {

    public static void main(String[] args) throws IOException {

        var socket = new Socket("localhost", 9090);
        out.println("Connected to server");

        var input = socket.getInputStream();
        var output = socket.getOutputStream();

        out.println("Sending message");
        var product = "xxx";
        output.write(product.getBytes());

        var response = new byte[1024];
        input.read(response);
        var quote = new String(response).trim();
        out.println("Received quote: " + quote);

        socket.close();
    }
}
