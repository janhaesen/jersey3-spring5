package org.example.jersey.configuration.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.example.jersey")
@PropertySource("classpath:application.properties")
public class SpringAnnotationConfig {
}
