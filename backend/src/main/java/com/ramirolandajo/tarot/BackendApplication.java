package com.ramirolandajo.tarot;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BackendApplication {

    public static String[] words;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(BackendApplication.class, args);

        String host = "http://localhost:11434/";

        OllamaAPI ollamaAPI = new OllamaAPI(host);
        ollamaAPI.setRequestTimeoutSeconds(40);
//        OllamaStreamHandler ollamaStreamHandler = (s) -> {
//            System.out.print(s);
//        };

        try {
            ollamaAPI.createModelWithModelFileContents("tarot", "FROM llama3.2:1b\nPARAMETER mirostat_tau 4.5\nPARAMETER top_k 35\nPARAMETER num_predict 128\nSYSTEM you are a tarot and zodiac signs expert and you have to give readings about the past present and future of the users messaging.");
            System.out.println(ollamaAPI.getModelDetails("tarot"));
            OllamaResult result =
                    ollamaAPI.generate(
                            "llama3.2:1b",
                            "What are you?",
                            true,
                            new OptionsBuilder().build()
                    );

            String response = result.getResponse();
            words = response.split("(?<!\\n)\\s+");


        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String word : words) {
            if (word.contains(".")) {
                System.out.println(word);
                Thread.sleep(100);
            } else {
                System.out.print(word + " ");
                Thread.sleep(100);
            }

        }

    }

}
