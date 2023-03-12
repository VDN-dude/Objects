package by.tms.http;

import by.tms.entity.Operation;
import by.tms.entity.OperationType;
import by.tms.service.CalculatorService;
import by.tms.storage.JDBCOperationStorage;
import by.tms.storage.OperationStorage;
import by.tms.validator.CalculatorValidator;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

public class HttpCalcHandler implements HttpHandler {
    CalculatorService calculator = new CalculatorService();
    CalculatorValidator validator = new CalculatorValidator();
    OperationStorage storage = new JDBCOperationStorage();
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String[] split = exchange.getRequestURI().getQuery().split("&");

        String num1 = split[0].split("=")[1];
        String num2 = split[1].split("=")[1];
        String type = split[2].split("=")[1];

        if(validator.isValidNum(num1) & validator.isValidNum(num2) & validator.isValidOperationType(type.toUpperCase())) {

            double dNum1 = Double.parseDouble(num1);
            double dNum2 = Double.parseDouble(num2);
            OperationType opType = OperationType.valueOf(type.toUpperCase());

            Operation operation = new Operation(dNum1, dNum2, opType);
            Optional<Operation> result = calculator.calculate(operation);

            String sResult = String.valueOf(result.get().getResult());

            storage.save(result.get());

            exchange.sendResponseHeaders(200, sResult.length());
            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(sResult.getBytes());
            responseBody.flush();
            responseBody.close();

        }else {
            String error = "Request error";
            exchange.sendResponseHeaders(200, error.length());
            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(error.getBytes());
            responseBody.flush();
            responseBody.close();
        }

    }
}
