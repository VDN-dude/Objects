package by.tms.console;

import by.tms.console.util.ConsoleReader;

public class ConsoleNumSelector {
    private final ConsoleReader reader = new ConsoleReader();
    public double selectNum() {return reader.readDouble();}
}