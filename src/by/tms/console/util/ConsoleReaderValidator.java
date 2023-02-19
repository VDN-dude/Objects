package by.tms.console.util;

import by.tms.util.Writer;
import by.tms.validator.DoubleValidator;

public class ConsoleReaderValidator {
    Writer writer = new ConsoleWriter();
    DoubleValidator validator = new DoubleValidator();
    boolean checkReadDouble(String num){
        if (validator.isValidDouble(num)){
            return true;
        }else {
            writer.writeln("Num invalid, try again.");
            return false;
        }
    }
}
