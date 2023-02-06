import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryOperationStorage implements OperationStorage {
    private final List<Operation> operations = new ArrayList<>();
    public void save(Operation operation) {
        operations.add(operation);
    }
    public List<Operation> findAll() {
        Collections.reverse(operations);
        return operations;
    }
}
