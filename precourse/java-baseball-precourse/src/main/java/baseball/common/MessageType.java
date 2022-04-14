package baseball.common;

public enum MessageType {
    ERROR_EMPTY("[ERROR] 빈 값을 입력할 수 없습니다."),
    ERROR_ZERO("[ERROR] 0 값은 입력할 수 없습니다."),
    ERROR_NUMBER_SIZE(String.format("[ERROR] %d자리 수가 아닙니다.", Constants.BASEBALL_NUMBER_SIZE)),
    ERROR_DUPLICATE_NUM("[ERROR] 중복된 수는 입력할 수 없습니다."),
    ERROR_NUMBER_FORMAT("[ERROR] 숫자 형식이 아닙니다."),
    ERROR_RESTART_NUMBER(String.format("[ERROR] %s 또는 %s가 아닙니다.", Constants.GAME_RESTART_INPUT, Constants.GAME_EXIT_INPUT)),
    INPUT_BASEBALL_NUMBER("숫자를 입력해주세요 : "),
    INPUT_RESTART_NUMBER(String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", Constants.GAME_RESTART_INPUT, Constants.GAME_EXIT_INPUT)),
    RESULT_GAME_OVER(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 끝", Constants.BASEBALL_NUMBER_SIZE)),
    RESULT_NOTING("낫싱");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
