package com.epam.training;

import java.util.Arrays;

public class StringConverter {

    int[] convertStringArrayToIntArray(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
