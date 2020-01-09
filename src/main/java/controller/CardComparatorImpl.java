package controller;

import model.Card;

public class CardComparatorImpl implements CardComparator {

    @Override
    public boolean compareSuit(Card card1, Card card2) {
        return card1.getSuit() == card2.getSuit();
    }

    @Override
    public boolean compareValue(Card card1, Card card2) {
        return card1.getValue() == card2.getValue();
    }

    @Override
    public boolean areCardsDiscardable(Card card1, Card card2) {
        if (!compareSuit(card1, card2)) {
            return compareValue(card1, card2);
        } else return true;
    }
}
