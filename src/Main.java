import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleApplication app = new ConsoleApplication();
        ConsoleAppRepeater repeater = new ConsoleAppRepeater();
        app.run();
        repeater.repeatApp();
    }
}