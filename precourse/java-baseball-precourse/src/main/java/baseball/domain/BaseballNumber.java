package baseball.domain;

import baseball.common.Constants;
import baseball.common.MessageType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumber {
    private final List<Integer> baseballNumbers;

    public BaseballNumber(List<Integer> baseballNumbers) {
        validateNullOrEmpty(baseballNumbers);
        validateZeroNumber(baseballNumbers);
        validateSize(baseballNumbers);
        validateDuplicate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validateNullOrEmpty(List<Integer> baseballNumbers) {
        if (baseballNumbers == null || baseballNumbers.isEmpty()) {
            throw new IllegalArgumentException(MessageType.ERROR_EMPTY.getMessage());
        }
    }

    private void validateZeroNumber(List<Integer> baseballNumbers) {
        if (baseballNumbers.contains(0)) {
            throw new IllegalArgumentException(MessageType.ERROR_ZERO.getMessage());
        }
    }

    private void validateSize(List<Integer> baseballNumbers) {
        if (baseballNumbers.size() != Constants.BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException(MessageType.ERROR_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> baseballNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(baseballNumbers);
        if (nonDuplicateNumbers.size() != Constants.BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException(MessageType.ERROR_DUPLICATE_NUM.getMessage());
        }
    }

    public BaseballResultVO matchBaseballNumber(BaseballNumber otherNumbers) {
        int strikeCount = getStrikeCount(otherNumbers);
        int ballCount = getBallCount(otherNumbers);
        return new BaseballResultVO(strikeCount, ballCount);
    }

    private int getBallCount(BaseballNumber otherNumbers) {
        List<Integer> copyNumbers = new ArrayList<>(baseballNumbers);
        copyNumbers.retainAll(otherNumbers.baseballNumbers);
        return copyNumbers.size() - getStrikeCount(otherNumbers);
    }

    private int getStrikeCount(BaseballNumber otherNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < Constants.BASEBALL_NUMBER_SIZE; ++i) {
            strikeCount += baseballNumbers.get(i).equals(otherNumbers.baseballNumbers.get(i)) ? 1 : 0;
        }
        return strikeCount;
    }
}