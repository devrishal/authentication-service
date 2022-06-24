package com.rds.utility;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;
import java.util.Properties;

@RequiredArgsConstructor
@Slf4j
public class ApplicationRunner {
    private final Class<?> application;
    @Getter
    private String port;
    @Getter
    private ConfigurableApplicationContext configurableApplicationContext;

    public void stop() {
        if (null != configurableApplicationContext) {
            configurableApplicationContext.close();
            log.info("Application Shutting Down");
        } else {
            log.info("No Running Application found.");
        }
    }

    public void start(final Map<String, String> applicationProperties) {
        start(applicationProperties, new String[]{});
    }

    private void start(Map<String, String> applicationProperties, String[] args) {
        log.info("Starting local application.");
        final SpringApplication springApplication = new SpringApplication(application);
        final Properties properties = new Properties();
        properties.putAll(applicationProperties);

        springApplication.setDefaultProperties(properties);
        this.configurableApplicationContext = springApplication.run(args);

        final Environment environment = configurableApplicationContext.getBean(Environment.class);
        this.port = environment.getProperty("local.server.port");
        log.info("Application started: port {}", port);
    }
}
