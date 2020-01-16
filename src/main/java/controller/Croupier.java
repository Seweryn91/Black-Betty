package controller;

import model.Card;
import model.Deck;
import model.Player;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

class Croupier {

    private Deck deck;
    private List<Player> players;

    Croupier(Deck deck, List<Player> players) {
        this.deck = deck; this.players = players;
    }

    void dealCards() {
        List<Card> playableDeck = deck.init();
        Collections.shuffle(playableDeck);

        ListIterator<Card> cardListIterator = playableDeck.listIterator();
        ListIterator<Player> playerListIterator = players.listIterator();

        while (playerListIterator.hasNext()) { //while there is next player
            Player currentPlayer = playerListIterator.next();
            currentPlayer.getHand().getCards().add(cardListIterator.next()); //give that player a card
            cardListIterator.remove(); //remove card from deck

            if (playableDeck.size() == 0) return;

            if (!playerListIterator.hasNext()) { //if card was dealt to the last player
                playerListIterator = players.listIterator(); } //reset iterator
        }
    }
}