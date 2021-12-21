package com.movieland;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication(scanBasePackages = "com.movieland")




//@Controller

@EnableAutoConfiguration
public class MyApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(MyApplication.class);
    }

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(MyApplication.class)
                .run(args);
    }
}
