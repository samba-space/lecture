package hello.servlet.web.frontcontroller.v5;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public interface ControllerV5 {

    String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException;
}
