package baseball;

import baseball.service.BaseballService;

public class Application {
    public static void main(String[] args) {
        BaseballService service = new BaseballService();
        do {
            service.play();
        } while (service.isRestart());

    }
}
