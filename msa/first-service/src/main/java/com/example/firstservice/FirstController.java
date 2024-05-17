package com.example.firstservice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/first-service")
public class FirstController {

    private final Environment environment;

    public FirstController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/welcome")
    public String hello() {
        return "first";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info(header);
        return "message first service";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("server port={}", request.getServerPort());
        return "port="+environment.getProperty("local.server.port");
    }
}
