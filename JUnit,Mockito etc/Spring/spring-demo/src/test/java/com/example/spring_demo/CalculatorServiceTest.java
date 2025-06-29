package com.example.spring_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    
    private CalculatorService calculatorService;
    
    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }
    
    @Test
    void testAdd() {
        // Arrange
        int a = 5;
        int b = 3;
        
        // Act
        int result = calculatorService.add(a, b);
        
        // Assert
        assertEquals(8, result);
    }
}