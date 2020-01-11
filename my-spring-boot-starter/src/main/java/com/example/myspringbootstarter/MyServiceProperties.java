package com.example.myspringbootstarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("mystarter")
public class MyServiceProperties {
    String prefix;
    String suffix;
}
