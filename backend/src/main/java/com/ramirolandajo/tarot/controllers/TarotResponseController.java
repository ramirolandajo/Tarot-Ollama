package com.ramirolandajo.tarot.controllers;

import com.ramirolandajo.tarot.models.TarotResponseCard;
import com.ramirolandajo.tarot.services.TarotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarot")
public class TarotResponseController {

    @Autowired
    TarotService tarotService;

    @GetMapping("/reading")
    public ResponseEntity<?> getTarotReading() {
        try {
            TarotResponseCard tarotResponseCard = tarotService.getTarotCardReading();
            return new ResponseEntity<>(tarotResponseCard, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
