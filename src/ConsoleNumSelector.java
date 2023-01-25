public class ConsoleNumSelector {
    private final ConsoleReader reader = new ConsoleReader();
    private final ConsoleWriter writer = new ConsoleWriter();

    public ConsoleNumSelector() {
    }

    public double selectNum1() throws RuntimeException {
        while(true) {
            this.writer.writeln("Enter number 1: ");

            try {
                double var1 = this.reader.readDouble();
            } catch (RuntimeException var3) {
                this.writer.writeln(var3.getLocalizedMessage());
            }
        }
    }

    public double selectNum2() {
        this.writer.writeln("Enter number 2: ");
        double num2 = this.reader.readDouble();

        try {
            num2 = this.reader.readDouble();
            return num2;
        } catch (RuntimeException var4) {
            this.writer.writeln(var4.getMessage());
            return this.selectNum2();
        }
    }
}