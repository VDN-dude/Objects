public class ConsoleOperationTypeSelector {
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleReader reader = new ConsoleReader();
    private OperationType opType;
    private boolean t = true;

    public OperationType select() {
        while (t) {
            writer.writeln("Select operation type ([0]sum, [1]sub, [2]mul, [3]div) :");
            String type = reader.readString();
            switch (type) {
                case "0":
                    t = false;
                    opType = OperationType.SUM;
                    break;
                case "1":
                    t = false;
                    opType = OperationType.SUB;
                    break;
                case "2":
                    t = false;
                    opType = OperationType.MUL;
                    break;
                case "3":
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
