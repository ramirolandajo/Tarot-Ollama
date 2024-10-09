package com.ramirolandajo.tarot.models;

import lombok.Getter;

@Getter
public enum TarotCard {
    THE_FOOL(0.75, "/images/THE_FOOL.png"),
    THE_MAGICIAN(0.7, "/images/THE_MAGICIAN.png"),
    THE_HIGH_PRIESTESS(0.65, "/images/THE_HIGH_PRIESTESS.png"),
    THE_EMPRESS(0.6, "/images/THE_EMPRESS.png"),
    THE_EMPEROR(0.6, "/images/THE_EMPEROR.png"),
    THE_HIEROPHANT(0.55, "/images/THE_HIEROPHANT.png"),
    THE_LOVERS(0.9, "/images/THE_LOVERS.png"),
    THE_CHARIOT(0.65, "/images/THE_CHARIOT.png"),
    STRENGTH(0.7, "/images/STRENGTH.png"),
    THE_HERMIT(0.55, "/images/THE_HERMIT.png"),
    WHEEL_OF_FORTUNE(0.7, "/images/WHEEL_OF_FORTUNE.png"),
    JUSTICE(0.6, "/images/JUSTICE.png"),
    THE_HANGED_MAN(0.3, "/images/THE_HANGED_MAN.png"),
    DEATH(0.05, "/images/DEATH.png"),
    TEMPERANCE(0.7, "/images/TEMPERANCE.png"),
    THE_DEVIL(0.1, "/images/THE_DEVIL.png"),
    THE_TOWER(0.2, "/images/THE_TOWER.png"),
    THE_STAR(0.8, "/images/THE_STAR.png"),
    THE_MOON(0.6, "/images/THE_MOON.png"),
    THE_SUN(0.85, "/images/THE_SUN.png"),
    JUDGEMENT(0.5, "/images/JUDGEMENT.png"),
    THE_WORLD(0.8, "/images/THE_WORLD.png");

    private final double chance;
    private final String imagePath;

    TarotCard(double chance, String imagePath) {
        this.chance = chance;
        this.imagePath = imagePath;
    }
}
