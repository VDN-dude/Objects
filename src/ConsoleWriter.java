import java.util.Arrays;

public class ConsoleWriter {
    public void write(String message) {
        System.out.print(message);
    }

    public void writeln(String message) {
        System.out.println(message);
    }
    public void writeln(Operation message) {System.out.println(message);}
    public void writeln(Operation[] message) {System.out.println(Arrays.toString(message));}

}
