package main.util;

import main.exception.ExceptionMessage;

public class StringUtil {
    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static String[] split(String input) {
        validateInput(input);
        String[] result = input.split(" ");
        validateSizeDown3(result);
        validateSizeEven(result);
        return result;
    }

    private static void validateInput(String input) {
        if (hasNoInput(input))
            throw new IllegalArgumentException(ExceptionMessage.EXPRESSION_BLANK);
    }

    private static boolean hasNoInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static void validateSizeDown3(String[] result) {
        if (result.length < 3)
            throw new IllegalArgumentException(ExceptionMessage.SIZE_DOWN_3);
    }

    private static void validateSizeEven(String[] result) {
        if (result.length % 2 == 0)
            throw new IllegalArgumentException(ExceptionMessage.SIZE_EVEN);
    }
}
