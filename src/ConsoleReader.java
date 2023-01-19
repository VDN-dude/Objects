import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner = new Scanner(System.in);

    public String readString() {
        return scanner.next();
    }
    public double readDouble() {return scanner.nextDouble();}
}
