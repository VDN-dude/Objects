import java.io.IOException;
import java.util.List;

public class ConsoleApplication{
    private final Calculator calculator = new Calculator();
    private final ConsoleReader reader = new ConsoleReader();
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleOperationTypeSelector typeSelector = new ConsoleOperationTypeSelector();
    private final OperationStorage storage = new InMemoryOperationStorage();
    private final ConsoleNumSelector numSelector = new ConsoleNumSelector();
    public void run() throws IOException {
        while (true) {
            double num1 = numSelector.selectNum1();
            double num2 = numSelector.selectNum2();
            OperationType type = typeSelector.select();

            Operation operation = new Operation(num1, num2, type);
            Operation result = calculator.calculate(operation);
            storage.save(result);
            writer.writeln("Result: " + result.getResult());

            List<Operation> operations = storage.findAll();
            writer.writeOpMemory(operations);

            boolean t = true;
            while (t) {
                writer.writeln("Want to continue? [0]No , [1]Yes : ");
                String replay = reader.readString();
                switch (replay) {
                    case "0":
                        return;
                    case "1":
                        t = false;
                        break;
                    default:
                        writer.writeln("Selection not found, try again.");
                }
            }
        }
    }
}
