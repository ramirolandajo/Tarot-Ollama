package com.ramirolandajo.tarot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarotResponseCard {
    private TarotCard tarotCard;
    private String message;

    //modificar constructor para que genere una carta random
}
