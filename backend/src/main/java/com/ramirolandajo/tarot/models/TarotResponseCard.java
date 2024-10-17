package com.ramirolandajo.tarot.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class TarotResponseCard {
    private ETarotCard tarotCard;
    private String message;
}
