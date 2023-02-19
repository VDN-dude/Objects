package by.tms.console;

import by.Application;
import by.tms.console.util.*;
import by.tms.entity.Operation;
import by.tms.entity.OperationType;
import by.tms.service.CalculatorService;
import by.tms.storage.FileOperationStorage;
import by.tms.storage.OperationStorage;
import by.tms.util.Reader;
import by.tms.util.Writer;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ConsoleApplication implements Application {
    private final CalculatorService calculator = new CalculatorService();
    private final Reader reader = new ConsoleReader();
    private final Writer writer = new ConsoleWriter();
    private final ConsoleOperationTypeSelector typeSelector = new ConsoleOperationTypeSelector();
    private final OperationStorage storage = new FileOperationStorage();
    private final ConsoleNumSelector numSelector = new ConsoleNumSelector();
    private final ConsoleHistoryShower shower = new ConsoleHistoryShower();
    public void run() {
        boolean t = true;
        while (t) {
            writer.writeln("Enter number 1: ");
            double num1 = numSelector.selectNum();
            writer.writeln("Enter number 2: ");
            double num2 = numSelector.selectNum();
            OperationType type = typeSelector.select();

            Operation operation = new Operation(num1, num2, type);
            Optional<Operation> result = calculator.calculate(operation);
            List<Operation> operations;

            try {
                storage.save(result.get());
                operations = storage.findAll();
            } catch (IOException e) {
                writer.writeln("File not found.");
                continue;
            }

            writer.writeln("Result: " + result.get().getResult());

            shower.showHistory(operations);
            t = repeat();
        }
    }
    public boolean repeat(){
        while (true) {
            writer.writeln("Want to continue? [0]No , [1]Yes : ");
            String replay = reader.readString();
            switch (replay) {
                case "0":
                    return false;
                case "1":
                    return true;
                default:
                    writer.writeln("Selection not found, try again.");
            }
        }
    }
}

