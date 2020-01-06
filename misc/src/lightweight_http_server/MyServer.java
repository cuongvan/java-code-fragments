/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lightweight_http_server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 *
 * @author cuong
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", MyServer::handleIndex);
        server.start();
        System.out.println("Started"); // will run
    }
    
    public static void handleIndex(HttpExchange exchange) throws IOException {
        String response = "<h1>Hello, Cuong</h1>";
        byte[] res = response.getBytes();
        exchange.getResponseHeaders().add("content-type", "text/html; charset=UTF-8");
        exchange.sendResponseHeaders(200, res.length);
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(res);
        }
    }
}
