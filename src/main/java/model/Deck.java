package model;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private int lowestCardValue;

    public Deck(int lowestCardValue) {
        this.lowestCardValue = lowestCardValue;
    }

    public int getLowestCardValue() {
        return lowestCardValue;
    }

    public void setLowestCardValue(int lowestCardValue) {
        this.lowestCardValue = lowestCardValue;
    }

    public List<Card> init() {
        List<Card> deck = new ArrayList<>();

        for (int i = lowestCardValue; i < 15; i++) {
            deck.add(new Card(Suit.SPADES, i));
        }
        for (int i = lowestCardValue; i < 15; i++) {
            deck.add(new Card(Suit.CLUBS, i));
        }
        for (int i = lowestCardValue; i < 15; i++) {
            deck.add(new Card(Suit.DIAMONDS, i));
        }
        for (int i = lowestCardValue; i < 15; i++) {
            deck.add(new Card(Suit.HEARTS, i));
        }
        deck.add(new Card(Suit.JOKER, 15));
        return deck;
    }
}