package main.domain;

import main.exception.ExceptionMessage;
import main.util.StringUtil;

public class StringCalculator {
    public static int calculateResult(String expression) {
        String[] splitResult = StringUtil.split(expression);
        int result = calculate(splitResult);
        return result;
    }

    private static int calculate(String[] splitResult) {
        int result = StringUtil.toInt(splitResult[0]);
        for (int i = 1; i < splitResult.length-1; i += 2) {
            result = Operator.calculate(result, splitResult[i], StringUtil.toInt(splitResult[i+1]));
        }
        return result;
    }
}
