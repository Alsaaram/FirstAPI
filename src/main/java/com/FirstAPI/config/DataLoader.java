package com.FirstAPI.config;

import com.FirstAPI.contentcalendar.model.Content;
import com.FirstAPI.contentcalendar.repository.ContentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.xml.namespace.QName;
import java.io.InputStream;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        try(InputStream inputStream = TypeReference.class.getResourceAsStream(name:"/data/content.json"))
        repository.saveAll(objectMapper.readValue(inputStream,new TypeReference<List<Content>>(){}));
    }

}
