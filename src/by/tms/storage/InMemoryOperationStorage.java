package by.tms.storage;

import by.tms.entity.Operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryOperationStorage implements OperationStorage {
    private final List<Operation> operations = new ArrayList<>();
    @Override
    public void save(Operation operation) {
        operations.add(operation);
    }
    @Override
    public List<Operation> findAll() {
        List<Operation> operationList = new ArrayList<>(operations);
        Collections.reverse(operationList);
        return operationList;
    }
}
