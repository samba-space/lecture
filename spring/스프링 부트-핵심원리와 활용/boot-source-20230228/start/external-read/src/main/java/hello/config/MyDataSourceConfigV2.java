package hello.config;

import hello.datasource.MyDataSourcePropertiesV1;
import hello.datasource.MyDataSourcePropertiesV2;
import hello.datasource.MyDatasource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableConfigurationProperties(MyDataSourcePropertiesV2.class)
public class MyDataSourceConfigV2 {

    private final MyDataSourcePropertiesV2 properties;

    public MyDataSourceConfigV2(MyDataSourcePropertiesV2 properties) {
        this.properties = properties;
    }

    @Bean
    public MyDatasource myDatasource() {
        return new MyDatasource(properties.getUrl(), properties.getUsername(), properties.getPassword(), properties.getEtc().getMaxConnection(), properties.getEtc().getTimeout(), properties.getEtc().getOptions());
    }
}
