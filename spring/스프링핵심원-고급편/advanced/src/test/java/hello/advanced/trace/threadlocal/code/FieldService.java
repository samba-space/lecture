package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name) {

        log.info("์ ์ฅ name={} -> nameStore={}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("์กฐํ name={} -> nameStore={}", name, nameStore);
        return name;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
