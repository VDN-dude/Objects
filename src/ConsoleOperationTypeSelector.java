public class ConsoleOperationTypeSelector {
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleReader reader = new ConsoleReader();
    private OperationType opType;
    private boolean t = true;

    public OperationType select() {
        while (t) {
            writer.writeln("Select operation type ([1]sum, [2]sub, [3]mul, [4]div) :");
            String type = reader.readString();
            switch (type) {
                case "1":
                    t = false;
                    opType = OperationType.SUM;
                    break;
                case "2":
                    t = false;
                    opType = OperationType.SUB;
                    break;
                case "3":
                    t = false;
                    opType = OperationType.MUL;
                    break;
                case "4":
                    t = false;
                    opType = OperationType.DIV;
                    break;
                default:
                    writer.writeln("Wrong operation, try again!");
                    break;
            }
        }
        t = true;
        return opType;
    }
}
