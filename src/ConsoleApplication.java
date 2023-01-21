import java.util.Arrays;

public class ConsoleApplication{
    private final Calculator calculator = new Calculator();
    private final ConsoleReader reader = new ConsoleReader();
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleOperationTypeSelector selector = new ConsoleOperationTypeSelector();
    private final InMemoryOperationStorage storage = new InMemoryOperationStorage();
    PrintOperationStorage printOperationStorage = new PrintOperationStorage();
    public void run() {
        while (true) {
            writer.writeln("Enter number 1: ");
            double num1 = reader.readDouble();
            writer.writeln("Enter number 2: ");
            double num2 = reader.readDouble();
            OperationType type = selector.select();

            Operation operation = new Operation(num1, num2, type);
            Operation result = calculator.calculate(operation);
            storage.save(result);
            writer.writeln("Result: " + result.getResult());
            printOperationStorage.printAll(storage);

            boolean t = true;
            while (t) {
                writer.writeln("Want to continue? [0]Yes , [1]No : ");
                String replay = reader.readString();
                switch (replay) {
                    case "0":
                        return;
                    case "2":
                        t = false;
                        break;
                    default:
                        writer.writeln("Selection not found, try again.");
                }
            }
        }
    }
}
