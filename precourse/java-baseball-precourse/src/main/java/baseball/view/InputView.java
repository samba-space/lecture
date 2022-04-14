package baseball.view;

import baseball.common.Constants;
import baseball.common.MessageType;
import baseball.domain.BaseballNumber;
import baseball.util.BaseballUtil;
import nextstep.utils.Console;

import java.util.List;

public class InputView {
    public static BaseballNumber input() {
        System.out.print(MessageType.INPUT_BASEBALL_NUMBER.getMessage());
        try {
            List<Integer> inputNumbers = BaseballUtil.stringNumbersToList(Console.readLine());
            return new BaseballNumber(inputNumbers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return input();
        }
    }

    public static boolean restartInput() {
        System.out.println(MessageType.INPUT_RESTART_NUMBER.getMessage());
        String input = Console.readLine();
        if (!(Constants.GAME_RESTART_INPUT.equals(input) || Constants.GAME_EXIT_INPUT.equals(input))) {
            System.out.println(MessageType.ERROR_RESTART_NUMBER.getMessage());
            return restartInput();
        }
        return Constants.GAME_RESTART_INPUT.equals(input);
    }
}
