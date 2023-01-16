public class ConsoleApplication implements Application{
    Calculator calculator = new Calculator();
    Reader reader = new ConsoleReader();
    Writer writer = new ConsoleWriter();
    OperationStorage storage = new InMemoryOperationStorage();
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

            writer.writeln("Display history? [Y]es , [N]o : ");
            String history = reader.readString();
            switch (history){
                case "n":
                    break;
                case "y":
                    storage.findAll();
            }

            writer.writeln("Want to continue? [Y]es , [N]o : ");
            String replay = reader.readString();
            switch (replay) {
                case "n":
                    return;
                case "y":
                    break;
            }
        }
    }
}
