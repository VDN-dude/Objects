import java.io.IOException;
import java.util.List;

public class ConsoleApplication{
    private final Calculator calculator = new Calculator();
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

    }
}
