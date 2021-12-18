package main.domain;

import main.exception.ExceptionMessage;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        validateDenominator(num2);
        return num1 / num2;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    private static void validateDenominator(int s1) {
        if (s1 == 0)
            throw new IllegalArgumentException(ExceptionMessage.DIVIDE_BY_ZERO);
    }

    public static int calculate(int result, String operator, int num) {
        return findProperOperator(operator).expression.apply(result, num);
    }

    private static Operator findProperOperator(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.HAS_NO_PROPER_OPERATOR));
    }
}
