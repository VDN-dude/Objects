import java.util.List;

public class HistoryShower {
    private final ConsoleReader reader = new ConsoleReader();
    private final ConsoleWriter writer = new ConsoleWriter();

    public void showHistory(List<Operation> operations) {
        while (true) {
            writer.writeln("Want to see history? [0]No , [1]Yes : ");
            int history = reader.readInt();
            switch (history) {
                case 0:
                    return;
                case 1:
                    writer.writeOpSt(operations);
                    return;
                default:
                    writer.writeln("Selection not found, try again.");
            }
        }
    }
}
