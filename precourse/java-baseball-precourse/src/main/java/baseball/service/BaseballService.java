package baseball.service;

import baseball.common.Constants;
import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResultVO;
import baseball.view.InputView;
import baseball.view.OutputView;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballService {
    public void play() {
        BaseballNumber computerNumbers = new BaseballNumber(createNonDuplicateNumbers());
        BaseballResultVO result;
        do {
            BaseballNumber userNumbers = InputView.input();
            result = computerNumbers.matchBaseballNumber(userNumbers);
            OutputView.output(result);
        } while (!result.isFinish());
    }

    public boolean isRestart() {
        return InputView.restartInput();
    }

    public List<Integer> createNonDuplicateNumbers() {
        Set<Integer> nonDuplicateNumbers = new LinkedHashSet<>();
        while (nonDuplicateNumbers.size() < Constants.BASEBALL_NUMBER_SIZE) {
            nonDuplicateNumbers.add(Randoms.pickNumberInRange(Constants.RANGE_START_NUM, Constants.RANGE_END_NUM));
        }
        return new ArrayList<>(nonDuplicateNumbers);
    }
}
