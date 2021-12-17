package main.util;

public class StringUtil {
    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static String[] split(String s) {
        return s.split(" ");
    }
}
