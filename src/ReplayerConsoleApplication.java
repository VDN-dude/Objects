public class ReplayerConsoleApplication {
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private ConsoleReader consoleReader = new ConsoleReader();
    public void replay(boolean t){
        while (t) {
            consoleWriter.writeln("Want to continue? [Y]es , [N]o : ");
            String replay = consoleReader.readString();
            switch (replay) {
                case "n":
                    return;
                case "y":
                    t = false;
                    break;
                default:
                    consoleWriter.writeln("Selection not found, try again.");
            }
        }
    }
}
