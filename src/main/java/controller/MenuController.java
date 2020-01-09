package controller;

import model.Player;
import model.MultiplayerGame;
import view.ConsoleCleaner;
import view.MenuPrinter;
import view.MessagePrinter;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private MenuPrinter menuPrinter = new MenuPrinter();
    private MessagePrinter messagePrinter = new MessagePrinter();
    private InputGetter inputGetter = new InputGetter();
    private ConsoleCleaner consoleCleaner = new ConsoleCleaner();


    public void launchMenu() {
        consoleCleaner.clearScreen();
        menuPrinter.printHeader();
        chooseOption();
    }

    private void chooseOption() {
        menuPrinter.printOptions();
        int option = inputGetter.promptForInteger();
        switch (option) {
            case 0:
                startGame();
            case 1:
                printHelp();
            case 2:
                exit();
            default:
                chooseOption();
        }
    }

    private List<Player> askForPlayers() {
        messagePrinter.promptForNumberOfPlayers();
        int numberOfPlayers = -1;
        while(numberOfPlayers < 2 || numberOfPlayers > 4) {
            messagePrinter.printError_invalidNumberOfPlayers();
            numberOfPlayers = inputGetter.promptForInteger(); }
        List<Player> players = new ArrayList<>(numberOfPlayers);
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player("Player "+ i);
            messagePrinter.promptForName(player);
            player.setName(inputGetter.promptForInput());
            players.add(player);
        }
        return players;
    }

    private int askForLowestValue() {
        messagePrinter.askForLowestValue();
        int lowestValue = -1;
        while (lowestValue < 2 || lowestValue > 9) {
            lowestValue = inputGetter.promptForInteger();
        }
        return lowestValue;
    }

    private void startGame() {
        List<Player> players = askForPlayers();
        int lowestCardValue = askForLowestValue();
        MultiplayerGame multiplayerGame = new MultiplayerGame();
        multiplayerGame.play(players, lowestCardValue);
    }

    private void printHelp() {
        menuPrinter.printRules();
        messagePrinter.pressAnyKey();
        inputGetter.promptForInput();
        chooseOption();
    }

    private void exit() {
        System.exit(0);
    }
}