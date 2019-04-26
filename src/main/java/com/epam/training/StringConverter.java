package com.epam.training;

public class StringConverter {
    int[] convertStringToInt(String[] numbers) {
        int[] numbersConverted = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersConverted[i] = Integer.valueOf(numbers[i]);
        }

        return numbersConverted;
    }
}
