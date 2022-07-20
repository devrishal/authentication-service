package com.rds.utility.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {
    private String fromEmail;
    private String fromEmailPersonal;
    private String replyTo;
    private String emailSubject;
}
