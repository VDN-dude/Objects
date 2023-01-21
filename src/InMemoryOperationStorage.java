public class InMemoryOperationStorage {
    private int index = 0;
    private final int length = 10;
    private final Operation[] operations = new Operation[length];
    public void save(Operation operation) {
        if (index < length) {
                operations[index] = operation;
                index++;
        } else {
            for (int i = 0; i < length - 1; i++) {
                operations[i] = operations[i + 1];
            }
            operations[index-1] = operation;
        }
    }
    public Operation[] findAll() {return operations;}
}
