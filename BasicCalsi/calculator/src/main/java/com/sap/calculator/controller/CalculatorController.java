package com.sap.calculator.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private int addCount = 0;
    private int subtractCount = 0;
    private int multiplyCount = 0;
    private int divideCount = 0;

    @GetMapping("/calculate")
    public String calculate(@RequestParam String expression) {
        try {
            double result = evaluateExpression(expression);
            return String.valueOf(result);
        } catch (Exception e) {
            return "Error";
        }
    }

    @GetMapping("/stats")
    public String getStats() {
        return String.format("Add: %d, Subtract: %d, Multiply: %d, Divide: %d", addCount, subtractCount, multiplyCount, divideCount);
    }

    private double evaluateExpression(String expression) {
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double operand = Double.parseDouble(tokens[i + 1]);
            switch (operator) {
                case "+":
                    result = add(result, operand);
                    break;
                case "-":
                    result = subtract(result, operand);
                    break;
                case "*":
                    result = multiply(result, operand);
                    break;
                case "/":
                    result = divide(result, operand);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }
        return result;
    }

    private double add(double a, double b) {
        addCount++;
        return a + b;
    }

    private double subtract(double a, double b) {
        subtractCount++;
        return a - b;
    }

    private double multiply(double a, double b) {
        multiplyCount++;
        return a * b;
    }

    private double divide(double a, double b) {
        divideCount++;
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }
}
