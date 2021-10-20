package com.playerstage.playerstage.config;

import java.net.URI;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SpringBootWebMvcConfigurer implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        URI uri = Paths.get("upload").toUri();
        registry.addResourceHandler("/files/**").addResourceLocations(uri.toString());
    }
}