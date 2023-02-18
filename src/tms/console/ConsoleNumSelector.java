package tms.console;

import tms.console.util.ConsoleReader;
import tms.console.util.ConsoleWriter;

public class ConsoleNumSelector {
    private ConsoleReader reader = new ConsoleReader();
    private final ConsoleWriter writer = new ConsoleWriter();

    public double selectNum() {
        while (true) {
            try {
                return reader.readDouble();
            } catch (RuntimeException e) {
                writer.writeln("Wrong entered number, try again");
                reader = new ConsoleReader();
            }
        }
    }
}