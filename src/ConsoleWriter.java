import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConsoleWriter {
    public void write(String message) {System.out.print(message);}
    public void writeln(String message) {System.out.println(message);}
    public void writeOpSt(List<Operation> storage){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");
        for (Operation operation : storage) {
            if (operation != null) {
                System.out.println(operation.getNum1() + " " + operation.getType() + " " + operation.getNum2() + " result " + operation.getResult() + " - time: " + operation.getTime().format(formatter));
            }
        }
    }
}
