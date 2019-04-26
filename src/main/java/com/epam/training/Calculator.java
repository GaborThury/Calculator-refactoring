
package com.epam.training;

import java.io.IOException;
import java.util.Arrays;

public class Calculator {
    public static void main(String[] args) throws IOException {
        ConsoleReader consoleReader = new ConsoleReader();
        StringSplitter stringSplitter = new StringSplitter();
        StringConverter stringConverter = new StringConverter();

        System.out.println("Enter an expression: ");
        String line = consoleReader.readLine();

        String[] operations = stringSplitter.getOperationsFromString(line);
        System.out.println(Arrays.toString(operations));

        String[] numbers = stringSplitter.getNumbersFromString(line);
        System.out.println(Arrays.toString(numbers));

        int[] numbersConverted = stringConverter.convertStringToInt(numbers);
        System.out.println(Arrays.toString(numbersConverted));

        int result = calculate(operations, numbersConverted);
        System.out.println(result);
    }

    // ORIGINAL
    private static int[] convert(String[] numbers) {
        int[] numbersConverted = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Integer.valueOf(numbers[i]);
        }

        return numbersConverted;
    }

    public static int calculate(String[] operations, int[] numbers) {
        int length = operations.length;
        int index = 1;
        while (index < length) {
            if ("*".equals(operations[index])) { // NEM!!! "*" == operations[i]
                performOperation(numbers, index, '*');
                sortElements(index, length, operations, numbers);
                length--;
            } else if ("/".equals(operations[index])) { // NEM!!! "/" == operations[i]
                performOperation(numbers, index, '/');
                sortElements(index, length, operations, numbers);
                length--;
            } else {
                index++;
            }
        }
        index = 1;
        while (index < length) {
            if ("+".equals(operations[index])) { // NEM!!! "+" == operations[i]
                performOperation(numbers, index, '+');
                sortElements(index, length, operations, numbers);
                length--;
            } else if ("-".equals(operations[index])) { // NEM!!! "-" == operations[i]
                performOperation(numbers, index, '-');
                sortElements(index, length, operations, numbers);
                length--;
            } else {
                index++;
            }
        }
        return numbers[0];
    }

    private static void performOperation(int[] numbers, int index, char operator) {
        switch (operator) {
            case '+':
                numbers[index - 1] += numbers[index];
                break;
            case '-':
                numbers[index - 1] -= numbers[index];
                break;
            case '*':
                numbers[index - 1] *= numbers[index];
                break;
            case '/':
                numbers[index - 1] /= numbers[index];
        }
    }

    private static void sortElements(int index, int length, String[] operations, int[] numbers) {
        for (int j = index; j < length - 1; j++) {
            numbers[j] = numbers[j + 1];
            operations[j] = operations[j + 1];
            operations[j + 1] = null;
        }
    }
}
