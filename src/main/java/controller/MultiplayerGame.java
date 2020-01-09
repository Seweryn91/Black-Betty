package controller;

import model.Deck;
import model.Player;
import view.MessagePrinter;

import java.util.List;
import java.util.Optional;

public class MultiplayerGame implements Game {

    @Override
    public void play(List<Player> players, int lowestCardValue) {
        Deck deck = new Deck(lowestCardValue);
        Turn turn = new Turn(players);
        MessagePrinter messagePrinter = new MessagePrinter();
        Croupier croupier = new Croupier(deck, players);
        croupier.dealCards();

        while (isMoreThanOnePlayerActive(players)) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).isActive()) {
                    turn.playTurn(i);
                    for (Player p : players) { ;
                        messagePrinter.showPlayersHandSize(p);
                    }
                }

                for (Player p : players) {
                    if (p.getHand().getCards().isEmpty()) {
                        p.setActive(false);
                    }
                }
            }
            if (!isMoreThanOnePlayerActive(players)) {
                Optional<String> name = players.stream().filter(Player::isActive).map(Player::getName)
                        .findFirst();
                name.ifPresent(messagePrinter::displayLooserName);
            }
        }

    }

    private boolean isMoreThanOnePlayerActive(List<Player> players){
        return (players.stream().filter(Player::isActive).count() > 1);
    }
}
