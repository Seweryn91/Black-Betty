package view;

import model.Card;
import model.Suit;

import java.util.Map;

public class CardPrinter {

    private static final String ANSI_RESET  = "\u001B[0m";
    private static final String ANSI_RED    = "\u001B[31m";
    private static final String ANSI_GREEN  = "\u001B[32m";
    private static final String ANSI_BLACK  = "\u001B[30m";
    private static final String ANSI_BG_WHITE = "\u001B[47m";

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
               return '\uD83C';
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

    public void printHand(Map<Integer, Card> handMap) {
        StringBuilder cardFaces = new StringBuilder();
        String pipe = ANSI_BG_WHITE + ANSI_BLACK + "|" + ANSI_RESET;
        String top = ANSI_BG_WHITE + ANSI_BLACK + " ___" + ANSI_RESET;
        cardFaces.append(top.repeat(handMap.keySet().size()));
        cardFaces.append(ANSI_BG_WHITE).append(" ").append('\n');

        for (int i = 0; i < handMap.keySet().size(); i++) {
            Card card = handMap.get(i);
            Suit suit = card.getSuit();
            char suitChar = getSuitPictogram(suit);
            int value = card.getValue();
            String valueSymbol = getValueSymbol(value);
            cardFaces.append(pipe);
            cardFaces.append(ANSI_BG_WHITE);
            if (suit.equals(Suit.HEARTS) || suit.equals(Suit.DIAMONDS)) {
                cardFaces.append(ANSI_RED);
            } else if (suit.equals(Suit.SPADES) || suit.equals(Suit.CLUBS)) {
                cardFaces.append(ANSI_BLACK);
            } else {
                cardFaces.append(ANSI_GREEN);
            }
            cardFaces.append(valueSymbol).append(suitChar);
        }
        cardFaces.append(pipe).append('\n').append(ANSI_RESET);

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
