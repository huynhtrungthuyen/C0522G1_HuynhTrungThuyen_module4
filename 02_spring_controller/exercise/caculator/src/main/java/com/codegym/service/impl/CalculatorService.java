package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String result(String number1, String number2, String calculator) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            double result = 0;

            switch (calculator) {
                case "Addition":
                    result = num1 + num2;
                    break;
                case "Subtraction":
                    result = num1 - num2;
                    break;
                case "Multiplication":
                    result = num1 * num2;
                    break;
                case "Division":
                    if (num2 == 0) {
                        return "Cannot be divided by 0!";
                    }

                    result = num1 / num2;
                    break;
            }

            return String.valueOf(result);

        } catch (NumberFormatException e) {
            return "Please enter the number!";
        }
    }
}
