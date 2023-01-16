public class ConsoleApplication implements Application{
    Calculator calculator = new Calculator();
    Reader reader = new ConsoleReader();
    Writer writer = new ConsoleWriter();
    OperationStorage storage = new InMemoryOperationStorage();
    private boolean t = true;
    @Override
    public void run() {
        while (true) {
            writer.writeln("Enter number 1: ");
            double num1 = reader.readDouble();
            writer.writeln("Enter number 2: ");
            double num2 = reader.readDouble();
            writer.writeln("Select operation type (sum, sub, mul, div) :");
            String type = reader.readString();

            Operation operation = new Operation(num1, num2, type);
            Operation result = calculator.calculate(operation);
            storage.save(result);
            writer.writeln("Result: " + result.getResult());

            while (t) {
                writer.writeln("Display history? [Y]es , [N]o : ");
                String history = reader.readString();
                switch (history) {
                    case "n":
                        t = false;
                        break;
                    case "y":
                        storage.findAll();
                        t = false;
                    default:
                        writer.writeln("Selection not found, try again.");
                }
            }

            while (!t) {
                writer.writeln("Want to continue? [Y]es , [N]o : ");
                String replay = reader.readString();
                switch (replay) {
                    case "n":
                        return;
                    case "y":
                        t = true;
                        break;
                    default:
                        writer.writeln("Selection not found, try again.");
                }
            }
        }
    }
}
