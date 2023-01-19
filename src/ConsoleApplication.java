import java.util.Arrays;

public class ConsoleApplication implements Application{
    private Calculator calculator = new Calculator();
    private ConsoleReader reader = new ConsoleReader();
    private ConsoleWriter writer = new ConsoleWriter();
    ReplayerConsoleApplication replayerConsoleApplication = new ReplayerConsoleApplication();
    @Override
    public void run() {
        while (true) {
            writer.writeln("Enter number 1: ");
            double num1 = reader.readDouble();
            writer.writeln("Enter number 2: ");
            double num2 = reader.readDouble();
            writer.writeln("Select operation type (sum, sub, mul, div) :");
            String type = reader.readString();

            Operation operation = new Operation(num1, num2, type.toUpperCase());
            Operation result = calculator.calculate(operation);
            writer.writeln("Result: " + result.getResult());

        }
    }
}
