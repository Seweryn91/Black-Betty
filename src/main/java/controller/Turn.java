package controller;

import controller.CardComparatorImpl;
import controller.InputGetter;
import model.Card;
import model.Player;
import view.CardPrinter;
import view.ConsoleCleaner;
import view.MessagePrinter;

import java.util.*;

class Turn {

    private List<Player> players;
    private MessagePrinter messagePrinter = new MessagePrinter();
    private CardPrinter cardPrinter = new CardPrinter();
    private ConsoleCleaner consoleCleaner = new ConsoleCleaner();
    private InputGetter inputGetter = new InputGetter();

    Turn(List<Player> players) {
        this.players = players;
    }

    void playTurn(int playerIndex) {
        if (players.stream().filter(Player::isActive).count() > 1) {
            getCardFromPreviousPlayer(playerIndex);

            if (areDiscardableCardsInGame()) {
                if (areDiscardableCardsPresent(playerIndex)) {
                    consoleCleaner.clearScreen();
                    messagePrinter.displayPlayerTurn(players.get(playerIndex));
                    messagePrinter.pressAnyKey();
                    inputGetter.promptForInput();
                    discardTwoCards(playerIndex);
                    promptForShuffle(playerIndex);
                }
                else {
                    consoleCleaner.clearScreen();
                    cardPrinter.printHand(cardListToMap(players.get(playerIndex).getHand().getCards()));
                    messagePrinter.printError_noDiscardableCards();
                    promptForShuffle(playerIndex);}
            }
        }
        else draw();
    }

    private void draw() {
        for (Player p : players) {
            if (p.isActive()) { p.setActive(false); }
        }
        consoleCleaner.clearScreen();
        messagePrinter.printDraw();
    }

    private void getCardFromPreviousPlayer(int currentPlayerIndex){
        Player activePlayer = players.get(currentPlayerIndex);
        Player previousPlayer;
        if (currentPlayerIndex == 0) {
            previousPlayer = players.get(players.size() - 1);
        } else {
            previousPlayer = players.get(currentPlayerIndex - 1);
        }
        if(previousPlayer.getHand().getCards().size() > 0) {
            giveCardToPlayer(previousPlayer, activePlayer);
        }
    }

    private void giveCardToPlayer(Player giver, Player taker){
        List<Card> giversCards = giver.getHand().getCards();
        List<Card> takersCards = taker.getHand().getCards();
        Card cardTaken = giversCards.get(0);
        takersCards.add(cardTaken);
        messagePrinter.showCardDrawn(cardTaken);
        giversCards.remove(0);
    }

    private boolean areDiscardableCardsPresent(int currentPlayerIndex) {
        List<Card> cards = players.get(currentPlayerIndex).getHand().getCards();
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i+1; j < cards.size(); j++) {
                Card c1 = cards.get(i);
                Card c2 = cards.get(j);
                if (c2.equals(cards.get(cards.size()-1))) { c1 = cards.get(0); }
                if (areCardsDiscardable(c1, c2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Card chooseCard (Map < Integer, Card > handMap){
        InputGetter inputGetter = new InputGetter();
        int cardChosenIndex = -1;
        while(cardChosenIndex < 0 || cardChosenIndex >= handMap.size()) {
            cardChosenIndex = inputGetter.promptForInteger();
        }
        return handMap.get(cardChosenIndex);
    }

    private Map<Integer, Card> cardListToMap (List < Card > cards) {
        Map<Integer, Card> handMap = new TreeMap<>();
        for (int i = 0; i < cards.size(); i++) {
            handMap.put(i, cards.get(i));
        }
        return handMap;
    }

    private void discardTwoCards(int currentPlayerIndex){
        List<Card> cardsToDiscard = new ArrayList<>();
        List<Card> cards = players.get(currentPlayerIndex).getHand().getCards();
        Map<Integer, Card> handMap = cardListToMap(cards);
        cardPrinter.printHand(handMap);
        messagePrinter.promptForFirstCard();
        Card firstCard = chooseCard(handMap);
        messagePrinter.showCardChosen(firstCard);
        cardsToDiscard.add(firstCard);
        messagePrinter.promptForSecondCard();
        Card secondCard = chooseCard(handMap);
        messagePrinter.showCardChosen(secondCard);

        if (secondCard.equals(firstCard)) {
            messagePrinter.printError_discardReset();
            discardTwoCards(currentPlayerIndex);
        } else {
            cardsToDiscard.add(secondCard);
        }

        if (areCardsDiscardable(firstCard, secondCard)) {
            messagePrinter.showCardsRemoved(firstCard, secondCard);
            cards.remove(firstCard);
            cards.remove(secondCard);
            cardsToDiscard.clear();
            return;
        } else {
            messagePrinter.printError_cardsNotMatching();
            discardTwoCards(currentPlayerIndex);
        }
        cardsToDiscard.clear();
    }


    private boolean areCardsDiscardable(Card c1, Card c2){
        CardComparatorImpl cardComparator = new CardComparatorImpl();
        if (!cardComparator.compareSuit(c1, c2)) {
            return cardComparator.compareValue(c1, c2);
        } else return true;
    }

    private boolean areDiscardableCardsInGame() {
        List<Card> allCardsInGame = new ArrayList<>();
        for (Player p : players) {
            if (p.isActive()) {
                allCardsInGame.addAll(p.getHand().getCards());
            }
        }
        for (int i = 0; i < allCardsInGame.size(); i++) {
            for (int j = i+1; j < allCardsInGame.size(); j++) {
                Card c1 = allCardsInGame.get(i);
                Card c2 = allCardsInGame.get(j);
                if (c2.equals(allCardsInGame.get(allCardsInGame.size()-1))) { c1 = allCardsInGame.get(0); }
                if (areCardsDiscardable(c1, c2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void promptForShuffle(int currentPlayerIndex) {
        List<Card> hand = players.get(currentPlayerIndex).getHand().getCards();
        InputGetter inputGetter = new InputGetter();
        messagePrinter.askForShuffle();
        if (inputGetter.promptForShuffle()) Collections.shuffle(hand);
    }
}
