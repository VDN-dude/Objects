
public class ConsoleNumSelector {
    private final ConsoleReader reader = new ConsoleReader();
    private final ConsoleWriter writer = new ConsoleWriter();

    public double selectNum1(){
        writer.writeln("Enter number 1: ");
        return reader.readDouble();
    }
    public double selectNum2(){
        writer.writeln("Enter number 2: ");
        return reader.readDouble();
    }
}