package test;

import main.domain.StringCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @DisplayName("빈 입력은 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void calc_fail(String expression) throws Exception {
        //given

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, ()->StringCalculator.calculateResult(expression));

    }

    @DisplayName("계산식에 대한 올바른 계산을 진행한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2 + 3 : 6",
            "4 - 5 + 1 : 0",
            "2 * 4 + 1 : 9",
            "3 / 3 + 1 : 2"
    }, delimiter = ':')
    public void calc(String expression, int result) throws Exception {
        //given

        //when
        int ActualResult = StringCalculator.calculateResult(expression);

        //then
        Assertions.assertEquals(result, ActualResult);
    }

    @DisplayName("올바르지 못한 계산식은 실패한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1 ! 2 + 3 : 6",
            "4 - 5 @ 1 : 0",
            "2 * 4 # 1 : 9",
            "3 / 3 $ 1 : 2"
    }, delimiter = ':')
    public void calc_fail2(String expression, int result) throws Exception {
        //given

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringCalculator.calculateResult(expression));
    }
}
