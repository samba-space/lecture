package hello.config;

import hello.datasource.MyDatasource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

@Slf4j
@Configuration
public class MyDataSourceValueConfig {


    @Value("${my.datasource.url}")
    private String url;

    @Value("${my.datasource.username}")
    private String username;

    @Value("${my.datasource.password}")
    private String password;

    @Value("${my.datasource.etc.max-connection}")
    private int maxConnection;

    @Value("${my.datasource.etc.timeout}")
    private Duration timeout;

    @Value("${my.datasource.etc.options}")
    private List<String> options;

    @Bean
    public MyDatasource myDatasource1() {
        return new MyDatasource(url, username, password, maxConnection, timeout, options);
    }

    @Bean
    public MyDatasource myDatasource2(
            @Value("${my.datasource.url}") String url,
            @Value("${my.datasource.username}") String username,
            @Value("${my.datasource.password}") String password,
            @Value("${my.datasource.etc.max-connection}") int maxConnection,
            @Value("${my.datasource.etc.timeout}") Duration timeout,
            @Value("${my.datasource.etc.options}") List<String> options) {
        return new MyDatasource(url, username, password, maxConnection, timeout, options);
    }

}
