package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static int toInt(String num) {
        return Integer.parseInt(num);
    }

    public static List<Integer> split(String input) {
        String[] result = input.split("");
        return Arrays.stream(result)
                    .map(r -> StringUtil.toInt(r))
                    .collect(Collectors.toList());
    }
}
