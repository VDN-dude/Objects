package by.tms.console;

import by.tms.console.util.ConsoleReader;
public class ConsoleNumSelector {
    private ConsoleReader reader = new ConsoleReader();
    public double selectNum() {
        while (true) {
            try {
                return reader.readDouble();
            } catch (RuntimeException e) {
                System.out.println("Num was entered incorrect, try again");
                reader = new ConsoleReader();
            }
        }
    }
}