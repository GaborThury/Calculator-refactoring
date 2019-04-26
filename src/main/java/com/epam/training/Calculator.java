
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

    static int calculate(String[] operations, int[] numbers) {
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
        int numberOfOperations = operations.length;
        int index = 1;
        while (index < numberOfOperations) {
            String operation = operations[index];
            if (currentOperationMatchesForInputOperator(operation, firstOperator, secondOperator)) {
                performSingleOperation(numbers, index, operation.charAt(0));
                moveElementsInArraysToLeft(index, numberOfOperations, operations, numbers);
                numberOfOperations--;
            } else {
                index++;
            }
        }
    }

    private static boolean currentOperationMatchesForInputOperator(String operation, String firstOperator, String secondOperator) {
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

    private static void moveElementsInArraysToLeft(int startIndex, int length, String[] operations, int[] numbers) {
        for (int j = startIndex; j < length - 1; j++) {
            numbers[j] = numbers[j + 1];
            operations[j] = operations[j + 1];
            operations[j + 1] = null;
        }
    }

}
