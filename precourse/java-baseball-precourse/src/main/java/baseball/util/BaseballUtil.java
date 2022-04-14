package baseball.util;

import baseball.common.MessageType;

import java.util.ArrayList;
import java.util.List;

public class BaseballUtil {
    private BaseballUtil() {
    }

    public static List<Integer> stringNumbersToList(String stringNumber) {
        stringNumber = stringNumber != null ? stringNumber.trim() : null;
        validateNullOrEmpty(stringNumber);
        validateNumberFormat(stringNumber);
        List<Integer> result = new ArrayList<>();
        String[] splitStr = stringNumber.split("");
        for (String singleStr : splitStr) {
            result.add(Integer.parseInt(singleStr));
        }
        return result;
    }

    private static void validateNullOrEmpty(String stringNumbers) {
        if (stringNumbers == null || stringNumbers.isEmpty()) {
            throw new IllegalArgumentException(MessageType.ERROR_EMPTY.getMessage());
        }
    }

    private static void validateNumberFormat(String stringNumbers) {
        try {
            Integer.parseInt(stringNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageType.ERROR_NUMBER_FORMAT.getMessage());
        }
    }
}