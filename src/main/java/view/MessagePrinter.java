package view;

import model.Card;
import model.Player;

public class MessagePrinter {

    private CardPrinter cardPrinter = new CardPrinter();

    public void askForShuffle() {
        System.out.println("Do you want to shuffle your hand? (Y/N)");
    }

    public void displayPlayerTurn(Player player) {
        System.out.println("Player " + player.getName() + " turn!");
    }

    public void pressAnyKey() {
        System.out.println("Press any key to continue.");
    }

    public void promptForName(Player player) {
        System.out.println(player.getName() + " type your name:");
    }

    public void promptForNumberOfPlayers() {
        System.out.println("How many players are going to play? (2-4)");
    }

    public void printError_invalidNumberOfPlayers() {
        System.out.println("Please provide number between 2 and 4!");
    }

    public void promptForFirstCard() {
        System.out.println("Choose first index of card to discard.");
    }

    public void promptForSecondCard() {
        System.out.println("Choose second index of card to discard.");
    }

    public void showCardChosen(Card card) {
        System.out.println("Card chosen: " + cardPrinter.getSimpleCardString(card));
    }

    public void printError_discardReset() {
        System.out.println("This card is already chosen! Clearing discard");
    }
    public void printError_noDiscardableCards() {
        System.out.println("You have no pair to discard!");
    }

    public void printError_cardsNotMatching() {
        System.out.println("Cards chosen are invalid for discard. Choose again");
    }

    public void showCardDrawn(Card card) {
        String simpleCardString = cardPrinter.getSimpleCardString(card);
        System.out.println("Card drawn: " + simpleCardString);
    }

    public void showCardsRemoved(Card c1, Card c2) {
        String simpleCardString1 = cardPrinter.getSimpleCardString(c1);
        String simpleCardString2 = cardPrinter.getSimpleCardString(c2);
        System.out.println("Cards removed " + simpleCardString1 +" and " + simpleCardString2);
    }

    public void showPlayersHandSize(Player player) {
        System.out.println(player.getName() + " has " + player.getHand().getCards().size() + " cards.");
    }

    public void displayLooserName(String name) {
        System.out.println(name + " lost!");
    }

    public void askForLowestValue() {
        System.out.println("Choose lowest value of cards (from 2 to 9):");
    }

    public void printError_valueInvalid() {
        System.out.println("Provided value must be between 2 and 9!");
    }

    public void printDraw() {
        System.out.println("No discardable cards are present in game! Game is draw. ");
    }

    public void printError_NaN() {
        System.out.println("Provided input is not a number. Try again");
    }
}
