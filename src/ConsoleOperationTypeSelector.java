public class ConsoleOperationTypeSelector {
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleReader reader = new ConsoleReader();
    public OperationType select() {
        while (true) {
            writer.writeln("Select operation type ([0]sum, [1]sub, [2]mul, [3]div) :");
            String type = reader.readString();
            switch (type) {
                case "0":
                    return OperationType.valueOf("+");
                case "1":
                    return OperationType.valueOf("-");
                case "2":
                    return OperationType.valueOf("*");
                case "3":
                    return OperationType.valueOf("/");
                default:
                    writer.writeln("Wrong operation, try again!");
            }
        }
    }
}
