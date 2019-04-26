package com.epam.training;

import java.util.regex.Pattern;

public class StringSplitter {
    String[] getOperationsFromString(String line) {
         return line.split("[0-9]+");
    }
    String[] getNumbersFromString(String line) {
        return line.split("[" + Pattern.quote("+-*/") + "]");
    }
}
