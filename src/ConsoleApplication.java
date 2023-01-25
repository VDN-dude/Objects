public class ConsoleApplication{
    private final Calculator calculator = new Calculator();
    private final ConsoleReader reader = new ConsoleReader();
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleOperationTypeSelector typeSelector = new ConsoleOperationTypeSelector();
    private final InMemoryOperationStorage storage = new InMemoryOperationStorage();
    public void run() {
        while (true) {
            writer.writeln("Enter number 1: ");
            double num1 = reader.readDouble();
            writer.writeln("Enter number 2: ");
            double num2 = reader.readDouble();
            OperationType type = typeSelector.select();

            Operation operation = new Operation(num1, num2, type);
            Operation result = calculator.calculate(operation);
            storage.save(result);
            writer.writeln("Result: " + result.getResult());

            Operation[] operations = storage.findAll();
            writer.writeOpMemory(operations);

            while (true) {
                writer.writeln("Want to continue? [0]Yes , [1]No : ");
                String replay = reader.readString();
                switch (replay) {
                    case "1":
                        return;
                    case "0":
                        break;
                    default:
                        writer.writeln("Selection not found, try again.");
                }
            }
        }
    }
}
