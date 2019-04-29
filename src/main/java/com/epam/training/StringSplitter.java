package com.epam.training;

import java.util.regex.Pattern;

public class StringSplitter {
    public String[] getMathOperationsFromString(String line) {
         return line.split("[0-9]+");
    }
    public String[] getNumbersFromString(String line) {
        return line.split("[" + Pattern.quote("+-*/") + "]");
    }
}
