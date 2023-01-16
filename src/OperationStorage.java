public interface OperationStorage {
    void save(Operation operation);

    Operation[] findAll();

}
