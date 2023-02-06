import java.io.IOException;

public class ConsoleAppRepeater {
    ConsoleApplication app = new ConsoleApplication();
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleReader reader = new ConsoleReader();
    public void repeatApp() throws IOException {
        while (true) {
            writer.writeln("Want to continue? [0]No , [1]Yes : ");
            int replay = reader.readInt();
            switch (replay) {
                case 0:
                    return;
                case 1:
                    app.run();
                    break;
                default:
                    writer.writeln("Selection not found, try again.");
            }
        }
    }
}
