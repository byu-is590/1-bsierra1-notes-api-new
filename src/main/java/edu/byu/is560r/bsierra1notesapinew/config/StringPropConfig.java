package edu.byu.is560r.bsierra1notesapinew.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableCaching
public class StringPropConfig {

    @Bean(name = "salt")
    public String getDefaultSalt() {
        return System.getenv("SPRING_SALT");
    }

}