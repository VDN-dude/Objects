import java.time.LocalDateTime;
import java.util.Arrays;
public class Calculator {
    public Operation calculate(Operation operation){
        switch (operation.getType()){
            case SUM:
                operation.setTime(LocalDateTime.now());
                return operation.setResult(operation.getNum1() + operation.getNum2());
            case SUB:
                operation.setTime(LocalDateTime.now());
                return operation.setResult(operation.getNum1() - operation.getNum2());
            case MUL:
                operation.setTime(LocalDateTime.now());
                return operation.setResult(operation.getNum1() * operation.getNum2());
            case DIV:
                operation.setTime(LocalDateTime.now());
                return operation.setResult(operation.getNum1() / operation.getNum2());
        }
        return operation;
    }
}

