package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> hand = new ArrayList<>();

    public List<Card> getCards() {
        return hand;
    }

    public void setCards(List<Card> hand) {
        this.hand = hand;
    }
}