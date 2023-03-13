package by.tms.http;

import by.tms.entity.Operation;
import by.tms.storage.JDBCOperationStorage;
import by.tms.storage.OperationStorage;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HttpCalcHistoryHandler implements HttpHandler {
    OperationStorage storage = new JDBCOperationStorage();
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        List<Operation> operations = storage.findAll();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");
        StringBuilder httpBuilder = new StringBuilder();

        for (Operation operation : operations) {
            String s = operation.getNum1() + " " + operation.getType() + " " + operation.getNum2() + " result " + operation.getResult() + " - time: " + operation.getTime().format(formatter);
            httpBuilder.append(s);
            httpBuilder.append("\n");
        }

        String history = httpBuilder.toString();
        exchange.sendResponseHeaders(200, history.length());
        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(history.getBytes());
        responseBody.flush();
        responseBody.close();
    }
}
