package view;

import model.Card;
import model.Suit;

import java.util.Map;

public class CardPrinter {

    private char getSuitPictogram(Suit suit) {
       switch (suit) {
           case SPADES:
               return '\u2660';
           case CLUBS:
               return '\u2663';
           case DIAMONDS:
               return '\u2666';
           case HEARTS:
               return '\u2764';
           case JOKER:
               return 'J';
           default:
               return '\uD83C'; //albo uDCCF
       }
    }

    private String getValueSymbol(int value) {
        StringBuilder sb = new StringBuilder();
        if (value == 10) {
            sb.append(value);
        } else {
            sb.append(" ");
            if (value == 11) {
                sb.append("J");
            } else if (value == 12) {
                sb.append("Q");
            } else if (value == 13) {
                sb.append("K");
            } else if (value == 14) {
                sb.append("A");
            } else if (value == 15 ) {
                sb.append("$");
            } else sb.append(value);}

            return sb.toString();
    }

    char getCardBack() {
        return '\u9608';
    }

    public void printHand(Map<Integer, Card> handMap) {
        StringBuilder cardFaces = new StringBuilder();
        char pipe = '|';
        String top = " ___";
        cardFaces.append(top.repeat(handMap.keySet().size()));
        cardFaces.append('\n');
        for (int i = 0; i < handMap.keySet().size(); i++) {
            Card card = handMap.get(i);
            Suit suit = card.getSuit();
            char suitChar = getSuitPictogram(suit);
            int value = card.getValue();
            String valueSymbol = getValueSymbol(value);
            cardFaces.append(pipe).append(valueSymbol).append(suitChar);
        }
        cardFaces.append(pipe).append('\n');

        for (int i = 0; i < handMap.keySet().size(); i++) {
            if (i < 10) cardFaces.append("  ").append(i).append(" ");
            else cardFaces.append(" ").append(i).append(" ");
        }

        System.out.println(cardFaces.toString());
    }

    String getSimpleCardString(Card card) {
        StringBuilder sb = new StringBuilder();
        if (!card.getSuit().equals(Suit.JOKER)) {
            sb.append(getValueSymbol(card.getValue())).append(" of ").append(getSuitPictogram(card.getSuit()));
        } else return "JOKER";
        return sb.toString();
    }
}
