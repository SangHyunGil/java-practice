package test;

import main.domain.StringCalculator;
import main.util.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


class StringUtilTest {

    @DisplayName("문자를 숫자로 변경한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "112 : 112",
            "119 : 119",
            "12345 : 12345"
    }, delimiter = ':')
    public void toInt(final String num, final int result) throws Exception {
        //given

        //when
        int ActualResult = StringUtil.toInt(num);

        //then
        Assertions.assertEquals(result, ActualResult);
    }

    @DisplayName("빈 입력은 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void calc_fail(String expression) throws Exception {
        //given

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> StringUtil.split(expression));

    }

    @DisplayName("연산 문자열의 사이즈가 3이하라면 입력은 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 3 +", "2 + "})
    public void calc_fail2(String expression) throws Exception {
        //given

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> StringUtil.split(expression));
    }

    @DisplayName("연산 문자열의 사이즈가 3이하라면 입력은 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    public void calc_fail3(String expression) throws Exception {
        //given

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> StringUtil.split(expression));
    }

    @DisplayName("문자열을 공백을 기준으로 나눈다.")
    @Test
    public void toInt() throws Exception {
        //given
        String s = "1 + 2";

        //when
        String[] ActualResult = StringUtil.split(s);

        //then
        Assertions.assertArrayEquals(new String[]{"1", "+", "2"}, ActualResult);
    }
}