package com.example;

public class Cards {

    enum Rank {
        TWO(2), THREE(3), FOUR(4),
        SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), ELEVEN(11);

        private int value;

        Rank(int value) {
            this.value = value;
        }
    }

    enum Suit {
        WORMS, SPADES, CROSSES, BOUBIES
    }

    public final Suit suit;
    public final Rank rank;
    public final int value;

    public Cards(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = this.rank.value;
    }

    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }
}
