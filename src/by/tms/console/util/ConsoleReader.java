package by.tms.console.util;

import by.tms.util.Reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    ConsoleReaderValidator validator = new ConsoleReaderValidator();
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String readString() {
        return scanner.next();
    }
    @Override
    public double readDouble(){
        while (true) {
            String num = scanner.next();
            if (validator.checkReadDouble(num)) {
                return Double.parseDouble(num);
            }
        }
    }
}
