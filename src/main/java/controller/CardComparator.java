package controller;

import model.Card;

public interface CardComparator {

    boolean compareSuit(Card card1, Card card2);

    boolean compareValue(Card card1, Card card2);

    boolean areCardsDiscardable(Card card1, Card card2);
}