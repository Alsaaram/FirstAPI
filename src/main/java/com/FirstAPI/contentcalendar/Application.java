package com.FirstAPI.contentcalendar;

import com.FirstAPI.config.ContentCalendarProperties;
import com.FirstAPI.contentcalendar.model.Content;
import com.FirstAPI.contentcalendar.model.Status;
import com.FirstAPI.contentcalendar.model.Type;
import com.FirstAPI.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
