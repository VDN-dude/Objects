import java.util.Scanner;

public class ConsoleReader implements Reader {
    Scanner scanner = new Scanner(System.in);
    @Override
    public String readString() {
        return scanner.next();
    }
    @Override
    public double readDouble() {
        return scanner.nextDouble();
    }
}
