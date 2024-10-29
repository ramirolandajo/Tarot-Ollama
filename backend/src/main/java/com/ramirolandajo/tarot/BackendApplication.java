package com.ramirolandajo.tarot;

import io.github.ollama4j.OllamaAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);

        String host = "http://localhost:11434/";
        OllamaAPI ollamaAPI = new OllamaAPI(host);
        try {
            ollamaAPI.createModelWithFilePath("tarot", "/modelfile");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
