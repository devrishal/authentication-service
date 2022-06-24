package com.rds;

import com.intuit.karate.junit5.Karate;
import com.rds.utility.ApplicationRunner;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;


public class ApplicationTest {
    private static ApplicationRunner applicationRunner;

    @BeforeAll
    static void start() {
        applicationRunner = new ApplicationRunner(Application.class);
        Map<String, String> applicationProperties = new HashMap<>();
        applicationRunner.start(applicationProperties);
    }

    @Karate.Test
    Karate testApplication() {
        return Karate.run("classpath:bdd/rest/").relativeTo(getClass());
    }


}
