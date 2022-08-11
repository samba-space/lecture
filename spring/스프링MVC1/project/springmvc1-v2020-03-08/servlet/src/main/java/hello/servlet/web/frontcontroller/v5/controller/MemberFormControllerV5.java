package hello.servlet.web.frontcontroller.v5.controller;

import hello.servlet.web.frontcontroller.v5.ControllerV5;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV5 implements ControllerV5 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) throws ServletException, IOException {
        return "new-form";
    }
}
