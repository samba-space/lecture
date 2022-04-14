package baseball.view;

import baseball.common.Constants;
import baseball.common.MessageType;
import baseball.domain.BaseballResultVO;

public class OutputView {
    public static void output(BaseballResultVO result) {
        System.out.println(getPrintFormat(result));
        if (result.isFinish()) {
            System.out.println(MessageType.RESULT_GAME_OVER.getMessage());
        }
    }

    private static String getPrintFormat(BaseballResultVO result) {
        String printFormat = String.format(Constants.GAME_RESULT_FORMAT, result.getStrike(), result.getBall());
        if (result.isNoting()) {
            return MessageType.RESULT_NOTING.getMessage();
        }
        if (result.isBoth()) {
            return printFormat;
        }
        return result.getStrike() > 0 ? printFormat.split(" ")[0] : printFormat.split(" ")[1];
    }
}