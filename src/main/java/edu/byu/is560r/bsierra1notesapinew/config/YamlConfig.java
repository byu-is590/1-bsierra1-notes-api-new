package edu.byu.is560r.bsierra1notesapinew.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("server")
public class YamlConfig {
    private String name;
    private String environment;
    private boolean enabled;
    private final List<String> servers = new ArrayList<>();

    // standard getters and setters
}