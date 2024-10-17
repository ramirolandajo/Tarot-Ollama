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
            ollamaAPI.createModelWithModelFileContents("tarot", "FROM llama3.2:1b\nPARAMETER temperature 0.85\nPARAMETER num_ctx 2048\nSYSTEM You are a tarot card reader and zodiac expert. Your job is to interpret tarot cards and give insightful readings, incorporating zodiac knowledge when relevant. Given a card the user will input, give a reading incorporating things about how the users future (for example his week) will be like based on the card. Your response must be first describing what the card represents, secondly how it may affect the users week, and lastly, something creative about the card.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
