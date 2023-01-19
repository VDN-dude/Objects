import java.util.Arrays;

public class ConsoleApplication{
    private Calculator calculator = new Calculator();
    private ConsoleReader reader = new ConsoleReader();
    private ConsoleWriter writer = new ConsoleWriter();
    private  ConsoleOperationTypeSelector selector = new ConsoleOperationTypeSelector();
    public void run() {
        while (true) {
            writer.writeln("Enter number 1: ");
            double num1 = reader.readDouble();
            writer.writeln("Enter number 2: ");
            double num2 = reader.readDouble();
            OperationType type = selector.select();

            Operation operation = new Operation(num1, num2, type);
            Operation result = calculator.calculate(operation);
            writer.writeln("Result: " + result.getResult());

            boolean t = true;
            while (t) {
                writer.writeln("Want to continue? [Y]es , [N]o : ");
                String replay = reader.readString();
                switch (replay) {
                    case "n":
                        return;
                    case "y":
                        t = false;
                        break;
                    default:
                        writer.writeln("Selection not found, try again.");
                }
            }
        }
    }
}
