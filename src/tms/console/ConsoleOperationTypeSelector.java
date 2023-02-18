package tms.console;

import tms.console.util.ConsoleReader;
import tms.console.util.ConsoleWriter;
import tms.entity.OperationType;

public class ConsoleOperationTypeSelector {
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleReader reader = new ConsoleReader();
    public OperationType select() {
        while (true) {
            writer.writeln("Select operation type ([0]sum, [1]sub, [2]mul, [3]div) :");
            String type = reader.readString();
            switch (type) {
                case "0":
                    return OperationType.SUM;
                case "1":
                    return OperationType.SUB;
                case "2":
                    return OperationType.MUL;
                case "3":
                    return OperationType.DIV;
                default:
                    writer.writeln("Wrong operation, try again!");
            }
        }
    }
}
