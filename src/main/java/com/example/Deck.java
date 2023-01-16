package com.example;

import java.util.ArrayList;
import java.util.Random;

import com.example.Cards.Rank;
import com.example.Cards.Suit;

public class Deck {
    private Random rand = new Random();
    private ArrayList<Cards> numbersInOrder;
    public Cards[] card = new Cards[52];

    public Deck() {
        Refresh();
    }

    // deck update method
    public final void Refresh() {
        int i = 0;
        numbersInOrder = new ArrayList<Cards>();
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                card[i++] = new Cards(s, r);
                numbersInOrder.add(new Cards(s, r));
            }
        }
    }

    // non-repeating random method
    public final int GetRandomCard() {
        int randomIndex = rand.nextInt(numbersInOrder.size());
        numbersInOrder.remove(randomIndex);
        return randomIndex;
    }

}
