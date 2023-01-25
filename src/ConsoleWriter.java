public class ConsoleWriter {
    public void write(String message) {System.out.print(message);}
    public void writeln(String message) {System.out.println(message);}
    public void writeOpMemory(Operation[] storage){
        for (Operation operation : storage) {
            if (operation != null) {
                System.out.println(operation.getNum1() + " " + operation.getType() + " " + operation.getNum2() + " result " + operation.getResult());
            }
        }
    }
}
