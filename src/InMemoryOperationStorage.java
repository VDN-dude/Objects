public class InMemoryOperationStorage implements OperationStorage {
    Writer writer = new ConsoleWriter();
    private int index = 0;
    private int length = 10;
    private String[] operations = new String[length];
    public void save(Operation operation) {
        if (index < length) {
            operations[index] = String.valueOf(operation.getNum1()) + " " + operation.getType() + " " + String.valueOf(operation.getNum2())+ " = " + String.valueOf(operation.getResult());
            index++;
        } else {
            for (int i = 0; i < length - 1; i++) {
                operations[i] = operations[i + 1];
            }
            operations[index-1] = String.valueOf(operation.getNum1()) + " " + operation.getType() + " " + String.valueOf(operation.getNum2())+ " = " + String.valueOf(operation.getResult());
        }
    }
    public void findAll() {
        for (int i = (operations.length-1); i >= 0; i--) {
            if (operations[i] != null){
                writer.writeln(operations[i]);
            }
        }
    }
}

