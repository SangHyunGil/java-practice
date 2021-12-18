package main.util;

import main.exception.ExceptionMessage;

public class StringUtil {
    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static String[] split(String input) {
        validateInput(input);
        String[] result = input.split(" ");
        return result;
    }

    private static void validateInput(String input) {
        if (hasNoInput(input))
            throw new IllegalArgumentException(ExceptionMessage.EXPRESSION_BLANK);
    }

    private static boolean hasNoInput(String input) {
        return input == null || input.trim().isEmpty();
    }
}
