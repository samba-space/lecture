package hello;

import hello.config.MyDataSourceConfigV1;
import hello.config.MyDataSourceValueConfig;
import hello.config.MyDatasourceEnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

//@Import(MyDatasourceEnvConfig.class)
//@Import(MyDataSourceValueConfig.class)
@Import(MyDataSourceConfigV1.class)
@ConfigurationPropertiesScan
@SpringBootApplication(scanBasePackages = "hello.datasource")
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }

}
