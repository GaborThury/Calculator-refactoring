package com.epam.training;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCalculator {

    @Test
    public void testConvertForNormal() {
        // Given
        String[] stringArray = {" ", "+", "-"};
        int[] numbers = {5, 2, 1};
        // When
        int result = Calculator.calculate(stringArray, numbers);
        // Then
        assertEquals("5 + 2 - 1 should be 6", 6, result);
    }

    @Test
    public void testConvertForNegativeNumbers() {
        // Given
        String[] stringArray = {" ", "+", "-"};
        int[] numbers = {-5, -2, -1};
        // When
        int result = Calculator.calculate(stringArray, numbers);
        // Then
        assertEquals("-5 + (-2) - (-1) should be -6", -6, result);
    }

    @Test
    public void testForAllOperators() {
        // Given
        String[] stringArray = {" ", "+", "/", "*", "-"};
        int[] numbers = {2, 6, 3, 3, 1};
        // When
        int result = Calculator.calculate(stringArray, numbers);
        // Then
        assertEquals(7, result);
    }
}
