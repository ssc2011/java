package quiz;

public class Calculator {
    double result;
    double calculate(double x, String op, int y) {
        switch (op) {
            case "+":
                result = x + y;
                return result;
            case "-":
                result = x - y;
                return result;
            case "*":
                result = x * y;
                return result;
            case "/":
                result = x / y;
                return result;
        }
        return 0;
    }
}


