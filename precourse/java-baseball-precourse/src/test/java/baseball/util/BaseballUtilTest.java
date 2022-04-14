package baseball.util;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BaseballUtilTest {
    @DisplayName("number format 인 stringNumber 입력 일 경우 정상 변환된다.")
    @Test
    void 정상_stringNumbers_입력() {
        //given
        String stringNumber = "123";
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3);

        //when
        List<Integer> numbers = BaseballUtil.stringNumbersToList(stringNumber);

        //then
        assertThat(numbers).isEqualTo(expectedNumbers);
    }

    @DisplayName("number format 아닌 stringNumber 입력 일 경우 IllegalArgumentException 발생한다.")
    @ParameterizedTest(name = "[{index}] stringNumber={0}")
    @ValueSource(strings = {"a23", "1 3"})
    void 숫자형식_아닌_StringNumbers_입력_예외발생(String stringNumber) {
        assertThatThrownBy(() -> BaseballUtil.stringNumbersToList(stringNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 형식이 아닙니다.");
    }

    @DisplayName("null 또는 empty stringNumber 입력 일 경우 IllegalArgumentException 발생한다.")
    @ParameterizedTest(name = "[{index}] stringNumber={0}")
    @NullAndEmptySource
    void null_empty_StringNumbers_입력_예외발생(String stringNumber) {
        assertThatThrownBy(() -> BaseballUtil.stringNumbersToList(stringNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 값을 입력할 수 없습니다.");
    }
}