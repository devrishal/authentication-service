package com.rds.utility.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application.security.jwt")
@Data
public class SecurityProperties {
    private String keyStoreLocation;
    private String keyStoreFile;
    private String keyStorePassword;
    private String keyAlias;
    private String privateKeyPassPhrase;
    private int tokenExpiryInMinutes;
}
