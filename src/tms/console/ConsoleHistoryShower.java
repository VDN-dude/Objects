package tms.console;

import tms.console.util.ConsoleReader;
import tms.console.util.ConsoleWriter;
import tms.entity.Operation;

import java.util.List;

public class ConsoleHistoryShower {
    private final ConsoleReader reader = new ConsoleReader();
    private final ConsoleWriter writer = new ConsoleWriter();

    public void showHistory(List<Operation> operations) {
        while (true) {
            writer.writeln("Want to see history? [0]No , [1]Yes : ");
            String history = reader.readString();
            switch (history) {
                case "0":
                    return;
                case "1":
                    writer.writeOpSt(operations);
                    return;
                default:
                    writer.writeln("Selection not found, try again.");
            }
        }
    }
}
