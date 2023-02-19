package by.tms.validator;

import java.util.regex.Pattern;

public class DoubleValidator {
    private static final Pattern DOUBLE = Pattern.compile("^\\d[.\\d]*$");
    public boolean isValidDouble(String num){return DOUBLE.matcher(num).matches();}
}
