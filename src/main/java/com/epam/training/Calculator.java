
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

        String[] operations = stringSplitter.getMathOperationsFromString(line);
        System.out.println(Arrays.toString(operations));

        String[] numbers = stringSplitter.getNumbersFromString(line);
        System.out.println(Arrays.toString(numbers));

        int[] numbersConverted = stringConverter.convertStringArrayToIntArray(numbers);
        System.out.println(Arrays.toString(numbersConverted));

        int result = calculate(operations, numbersConverted);
        System.out.println(result);
    }

    private static int[] convert(String[] numbers) {
        int[] numbersConverted = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Integer.valueOf(numbers[i]);
        }

        return numbersConverted;
    }

    public static int calculate(String[] operations, int[] numbers) {
        performMultipliesAndDivides(operations, numbers);
        performSumsAndSubtractions(operations, numbers);
        return numbers[0];
    }

    private static void performMultipliesAndDivides(String[] operations, int[] numbers) {
        performOperations(operations, numbers, "*", "/");
    }

    private static void performSumsAndSubtractions(String[] operations, int[] numbers) {
        performOperations(operations, numbers, "+", "-");
    }

    private static void performOperations(String[] operations, int[] numbers, String firstOperator, String secondOperator) {
        int length = operations.length;
        int index = 1;
        while (index < length) {
            String operation = operations[index];
            if (currentOperationMatchesForInput(operation, firstOperator, secondOperator)) {
                performSingleOperation(numbers, index, operation.charAt(0));
                moveElementsInArraysToLeft(index, length, operations, numbers);
                length--;
            } else {
                index++;
            }
        }
    }

    private static boolean currentOperationMatchesForInput(String operation, String firstOperator, String secondOperator) {
        return (firstOperator.equals(operation)) || (secondOperator.equals(operation));
    }

    private static void performSingleOperation(int[] numbers, int index, char operator) {
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

    private static void moveElementsInArraysToLeft(int index, int length, String[] operations, int[] numbers) {
        for (int j = index; j < length - 1; j++) {
            numbers[j] = numbers[j + 1];
            operations[j] = operations[j + 1];
            operations[j + 1] = null;
        }
    }

}
