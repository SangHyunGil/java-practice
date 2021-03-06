package test;

import main.domain.StringCalculator;
import main.exception.ExceptionMessage;
import main.util.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

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
        assertEquals(result, ActualResult);
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

        //when
        Throwable exception = assertThrows(IllegalArgumentException.class, ()-> StringCalculator.calculateResult(expression));

        //then
        assertEquals(ExceptionMessage.HAS_NO_PROPER_OPERATOR, exception.getMessage());
    }
}
