package by.tms.http;

import by.Application;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpApplication implements Application {

    @Override
    public void run() {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080),0);
            httpServer.createContext("/calc", new HttpCalcHandler());
            httpServer.createContext("/calc/history", new HttpCalcHistoryHandler());
            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
