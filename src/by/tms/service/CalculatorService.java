package by.tms.service;

import by.tms.entity.Operation;

import java.time.LocalDateTime;
import java.util.Optional;

public class CalculatorService {
    public Optional<Operation> calculate(Operation operation){
        switch (operation.getType()){
            case SUM:
                operation.setTime(LocalDateTime.now());
                return Optional.ofNullable(operation.setResult(operation.getNum1() + operation.getNum2()));
            case SUB:
                operation.setTime(LocalDateTime.now());
                return Optional.ofNullable(operation.setResult(operation.getNum1() - operation.getNum2()));
            case MUL:
                operation.setTime(LocalDateTime.now());
                return Optional.ofNullable(operation.setResult(operation.getNum1() * operation.getNum2()));
            case DIV:
                operation.setTime(LocalDateTime.now());
                return Optional.ofNullable(operation.setResult(operation.getNum1() / operation.getNum2()));
        }
        return Optional.empty();
    }
}

