package com.ramirolandajo.tarot.controllers;

import com.ramirolandajo.tarot.models.TarotResponseCard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarot")
public class TarotResponseController {

    @GetMapping("/reading")
    public ResponseEntity<?> getReading() {
        try {
            TarotResponseCard newReponse = new TarotResponseCard();
            return new ResponseEntity<>(newReponse, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
