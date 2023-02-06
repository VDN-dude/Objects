import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FileOperationStorage implements OperationStorage{

    @Override
    public void save(Operation operation) throws IOException {
        String result = String.format("%s,%s,%s,%s,%s",operation.getNum1(), operation.getType(), operation.getNum2(), operation.getResult(),operation.getFormattedTime());
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
        Collections.reverse(operationList);
        return operationList;
    }
    private Operation convertToOperation(String operation) {
        String[] s = operation.split(",");
        double num1 = Double.parseDouble(s[0]);
        OperationType type = OperationType.valueOf(s[1]);
        double num2 = Double.parseDouble(s[2]);
        double result = Double.parseDouble(s[3]);
        return new Operation(num1, type, num2, result, s[4]);
    }
}
