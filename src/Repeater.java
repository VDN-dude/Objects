public class Repeater {
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleReader reader = new ConsoleReader();
    public boolean repeatApp(){
        while (true) {
            writer.writeln("Want to continue? [0]No , [1]Yes : ");
            int replay = reader.readInt();
            switch (replay) {
                case 0:
                    return false;
                case 1:
                    return true;
                default:
                    writer.writeln("Selection not found, try again.");
            }
        }
    }
}
