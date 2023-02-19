package by.tms.storage;

import by.tms.entity.OperationType;
import by.tms.entity.Operation;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOperationStorage implements OperationStorage {

    @Override
    public void save(Operation operation) throws IOException {
        String result = String.format("%s,%s,%s,%s,%s",operation.getNum1(), operation.getType(), operation.getNum2(), operation.getResult(),operation.getTime());
        FileOutputStream fileOutputStream = new FileOutputStream("history.csv", true);
        fileOutputStream.write(result.getBytes());
        fileOutputStream.write(10);
        fileOutputStream.close();
    }

    @Override
    public List<Operation> findAll() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("history.csv"));
        List<Operation> operationList = new ArrayList<>();
        String operations;
        while ((operations = bufferedReader.readLine()) != null){
            operationList.add(convertToOperation(operations));
        }
        Stream<Operation> stream = operationList.stream();
        operationList = stream.sorted().collect(Collectors.toList());
        return operationList;
    }
    private Operation convertToOperation(String operation) {
        String[] s = operation.split(",");
        double num1 = Double.parseDouble(s[0]);
        OperationType type = OperationType.valueOf(s[1]);
        double num2 = Double.parseDouble(s[2]);
        double result = Double.parseDouble(s[3]);
        LocalDateTime time = LocalDateTime.parse(s[4]);
        return new Operation(num1, type, num2, result, time);
    }
}
