public class Calculator {
    public Operation calculate(Operation operation){
        switch (operation.getType()){
            case SUM:
                return operation.setResult(operation.getNum1() + operation.getNum2());
            case SUB:
                return operation.setResult(operation.getNum1() - operation.getNum2());
            case MUL:
                return operation.setResult(operation.getNum1() * operation.getNum2());
            case DIV:
                return operation.setResult(operation.getNum1() / operation.getNum2());
        }
        return operation;
    }
}
