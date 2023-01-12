package com.example;

import java.util.*;

public class Croupier {
    private Random rand = new Random();
    Cards[] card;
    private List<Cards> numbersInOrder;

    int count_player;
    int count_croipier;
    int indexCardCroupier;
    int indexCardPlayer;

    private String[] name = {
            "6 черви", "7 черви", "8 черви", "9 черви", "10 черви", "Валет червей", "Дама червей", "Король червей",
            "Туз червей",
            "6 пики", "7 пики", "8 пики", "9 пики", "10 пики", "Валет пики", "Дама пики", "Король пики", "Туз пики",
            "6 крести", "7 крести", "8 крести", "9 крести", "10 крести", "Валет крести", "Дама крести", "Король крести",
            "Туз крести",
            "6 буби", "7 буби", "8 буби", "9 буби", "10 буби", "Валет бубей", "Дама бубей", "Король бубей", "Туз бубей"

    };
    private int[] price = {
            6, 7, 8, 9, 10, 2, 3, 4, 11,
            6, 7, 8, 9, 10, 2, 3, 4, 11,
            6, 7, 8, 9, 10, 2, 3, 4, 11,
            6, 7, 8, 9, 10, 2, 3, 4, 11
    };

    public Croupier() {
        System.out.println("Добро пожаловать в игру 21 очко!!!");
        Full();
    }

    // Filling the array with maps
    void Full() {
        card = new Cards[36];
        numbersInOrder = new ArrayList<Cards>();
        for (int i = 0; i < card.length; i++) {
            numbersInOrder.add(new Cards(name[i], price[i]));
            card[i] = new Cards(name[i], price[i]);
        }
    }

    // A method of obtaining a random, non-repeating card
    private int GetRandomCard() {
        int randomIndex = rand.nextInt(numbersInOrder.size());
        numbersInOrder.remove(randomIndex);
        return randomIndex;
    }

    // The method that starts the game
    public void Battle() {
        CardCroupier();
        CardPlayer();
    }

    // The method of obtaining a player card
    public void CardPlayer() {
        indexCardPlayer = GetRandomCard();
        count_player += card[indexCardPlayer].price;
    }

    // The method of obtaining a croupier's card
    private void CardCroupier() {
        indexCardCroupier = GetRandomCard();
        count_croipier += card[indexCardCroupier].price;
    }

    // The dealer's extra card method
    void Extraction() {
        CardCroupier();
    }

}
