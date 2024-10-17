package com.ramirolandajo.tarot.services;

import com.ramirolandajo.tarot.exceptions.TarotCardNotFoundException;
import com.ramirolandajo.tarot.exceptions.TarotOllamaAPIException;
import com.ramirolandajo.tarot.models.ETarotCard;
import com.ramirolandajo.tarot.models.TarotResponseCard;
import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TarotService {

    public TarotResponseCard getTarotCardReading() throws TarotCardNotFoundException, TarotOllamaAPIException {
        TarotResponseCard tarotResponse = new TarotResponseCard();
        tarotResponse.setTarotCard(getRandomCard());
        String tarotMessage = getMessage(tarotResponse.getTarotCard());
        tarotResponse.setMessage(tarotMessage);
        return tarotResponse;
    }

    private ETarotCard getRandomCard() throws TarotCardNotFoundException {
        //weight -> Referring to the chance of the card of appearing
        double totalCardsWeight = 0.0;
        for (ETarotCard card : ETarotCard.values()) {
            totalCardsWeight += card.getRandomness();
        }
        Random random = new Random();
        double randomWeight = random.nextDouble() * totalCardsWeight;

        for (ETarotCard card : ETarotCard.values()) {
            randomWeight -= card.getRandomness();
            if (randomWeight <= 0) {
                return card;
            }
        }
        throw new TarotCardNotFoundException("No card was selected");
    }

    private String getMessage(ETarotCard card) throws TarotOllamaAPIException {
        String host = "http://localhost:11434/";
        OllamaAPI ollamaAPI = new OllamaAPI(host);
        ollamaAPI.setRequestTimeoutSeconds(40);
        try {
            OllamaResult result =
                    ollamaAPI.generate(
                            "llama3.2:1b",
                            "do a reading based on the tarot card: " + card.name() + ". Keep it to under 50 words.",
                            true,
                            new OptionsBuilder().build()
                    );
            String response = result.getResponse();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new TarotOllamaAPIException("Error with OllamaAPI when creating the response message.");
        }
    }
}
