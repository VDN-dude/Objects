public class PrintOperationStorage {
    public void printAll(InMemoryOperationStorage storage){
        for (int i = 0; i < storage.findAll().length; i++) {
            if (storage.findAll()[i] != null) {
                System.out.println("result " + storage.findAll()[i].getResult());
            }
        }
    }
}
