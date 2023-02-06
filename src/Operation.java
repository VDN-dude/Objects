import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operation {
    private final double num1;
    private final double num2;
    private final OperationType type;
    private double result;
    private LocalDateTime time;
    private String formattedTime;
    public Operation(double num1, double num2, OperationType type){
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;

    }

    public Operation(double num1, OperationType type, double num2, double result, LocalDateTime time) {
        this.num1 = num1;
        this.type = type;
        this.num2 = num2;
        this.result = result;
        this.time = time;
    }

    public double getNum1() {
        return num1;
    }
    public double getNum2() {
        return num2;
    }
    public OperationType getType() {
        return type;
    }
    public double getResult() {return result;}
    public Operation setResult(double result) {
        this.result = result;
        return this;
    }

    public void setTime(LocalDateTime time) {this.time = time;}

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "num1=" + num1 +
                ", type=" + type +
                ", num2=" + num2 +
                ", result=" + result +
                ", formattedTime='" + formattedTime + '\'' +
                '}';
    }
}
