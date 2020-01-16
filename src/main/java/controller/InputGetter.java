package controller;

import view.MessagePrinter;

import java.util.Scanner;

class InputGetter {

    private Scanner scanner = new Scanner(System.in);
    private MessagePrinter messagePrinter = new MessagePrinter();

    String promptForInput() {
        String input = scanner.nextLine();
        return input;
    }

    boolean promptForShuffle() {
        String input = promptForInput();
        String inputUppercase = input.toUpperCase();
        if (inputUppercase.equals("Y") || inputUppercase.equals("YES")) return true;
        else if (inputUppercase.equals("N") || inputUppercase.equals("NO")) return false;
        else promptForShuffle();
        return false;
    }

    int promptForInteger() {
        int integer = -1;
        try {
            integer = Integer.parseInt(promptForInput());
        } catch (NumberFormatException e) {
            messagePrinter.printError_NaN();
            promptForInput();
        }
        return integer;
    }
}
