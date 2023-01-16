package com.example;

public class Croupier {

    Deck deck;

    int count_player;
    int count_croipier;
    int indexCardCroupier;
    int indexCardPlayer;

    public void Full() {
        deck = new Deck();
    }

    // The method that starts the game
    public void Battle() {
        CardCroupier();
        CardPlayer();
    }

    // The method of obtaining a player card
    public void CardPlayer() {
        indexCardPlayer = deck.GetRandomCard();
        count_player += deck.card[indexCardPlayer].value;
    }

    // The method of obtaining a croupier's card
    private void CardCroupier() {
        indexCardCroupier = deck.GetRandomCard();
        count_croipier += deck.card[indexCardCroupier].value;
    }

    // The dealer's extra card method
    void Extraction() {
        CardCroupier();
    }

}
