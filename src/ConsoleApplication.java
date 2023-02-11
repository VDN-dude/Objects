import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ConsoleApplication{
    private final Calculator calculator = new Calculator();
    private final ConsoleReader reader = new ConsoleReader();
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleOperationTypeSelector typeSelector = new ConsoleOperationTypeSelector();
    private final OperationStorage storage = new FileOperationStorage();
    private final ConsoleNumSelector numSelector = new ConsoleNumSelector();
    private final HistoryShower shower = new HistoryShower();
    public void run() {
        boolean t = true;
        while (t) {
            writer.writeln("Enter number 1: ");
            double num1 = numSelector.selectNum();
            writer.writeln("Enter number 2: ");
            double num2 = numSelector.selectNum();
            OperationType type = typeSelector.select();

            Operation operation = new Operation(num1, num2, type);
            Optional<Operation> result = calculator.calculate(operation);
            List<Operation> operations;

            try {
                storage.save(result.get());
                operations = storage.findAll();
            } catch (IOException e) {
                writer.writeln("File not found.");
                continue;
            }

            writer.writeln("Result: " + result);

            shower.showHistory(operations);
            t = repeat();
        }
    }
    public boolean repeat(){
        while (true) {
            writer.writeln("Want to continue? [0]No , [1]Yes : ");
            String replay = reader.readString();
            switch (replay) {
                case "0":
                    return false;
                case "1":
                    return true;
                default:
                    writer.writeln("Selection not found, try again.");
            }
        }
    }
}

