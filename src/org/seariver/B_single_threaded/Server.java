package org.seariver.B_single_threaded;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;

import static java.lang.System.out;

public class Server {

    public static void main(String[] args) throws IOException {

        var quoteService = new QuoteService();
        var serverSocket = new ServerSocket(9090);
        out.println("Server listening 9090");

        while (true) {
            out.println("Waiting for client");
            var socket = serverSocket.accept();
            out.println("Client connected");

            var input = socket.getInputStream();
            var output = socket.getOutputStream();

            var request = new byte[1024];
            input.read(request);
            var product = new String(request).trim();
            out.println("Request: " + product);

            var price = quoteService.getQuote(product);
            output.write(String.format("%s = %s", product, price).getBytes());

            out.println("Closing connection");
            socket.close();
        }
    }
}

class QuoteService {

    Map<String, String> productInfo = Map.of(
            "shirt", "100",
            "pants", "200",
            "shoes", "300"
    );

    public String getQuote(String product) {
        return productInfo.getOrDefault(product, "Product not found");
    }
}
