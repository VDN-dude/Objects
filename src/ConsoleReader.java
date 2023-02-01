import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner = new Scanner(System.in);

    public String readString() {
        return scanner.next();
    }
    public double readDouble() throws RuntimeException{
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (RuntimeException e) {
                scanner = new Scanner(System.in);
            }
        }
    }
}
