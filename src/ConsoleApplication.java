import java.io.IOException;
import java.util.List;

public class ConsoleApplication{
    private final Calculator calculator = new Calculator();
    private final ConsoleReader reader = new ConsoleReader();
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleOperationTypeSelector typeSelector = new ConsoleOperationTypeSelector();
    private final OperationStorage storage = new FileOperationStorage();
    private final ConsoleNumSelector numSelector = new ConsoleNumSelector();
    private final HistoryShower shower = new HistoryShower();
    public void run() throws IOException {
        double num1 = numSelector.selectNum1();
        double num2 = numSelector.selectNum2();
        OperationType type = typeSelector.select();

        Operation operation = new Operation(num1, num2, type);
        Operation result = calculator.calculate(operation);
        storage.save(result);
        writer.writeln("Result: " + result.getResult());
        List<Operation> operations = storage.findAll();

        shower.showHistory(operations);
        repeat();

    }
    private void repeat() throws IOException {
        while (true) {
            writer.writeln("Want to continue? [0]No , [1]Yes : ");
            int replay = reader.readInt();
            switch (replay) {
                case 0:
                    return;
                case 1:
                    run();
                    break;
                default:
                    writer.writeln("Selection not found, try again.");
            }
        }
    }
}
