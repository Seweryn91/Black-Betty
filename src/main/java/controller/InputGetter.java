package controller;

import java.util.Scanner;

public class InputGetter {

    private Scanner scanner = new Scanner(System.in);

    public String promptForInput() {
        String input = scanner.nextLine();
        return input;
    }

    public boolean promptForShuffle() {
        String input = promptForInput();
        String inputUppercase = input.toUpperCase();
        if (inputUppercase.equals("Y") || inputUppercase.equals("YES")) return true;
        else if (inputUppercase.equals("N") || inputUppercase.equals("NO")) return false;
        else promptForShuffle();
        return false;
    }

    public int promptForInteger() {
        int integer = -1;
        try {
            integer = Integer.parseInt(promptForInput());
        } catch (NumberFormatException e) {
            System.out.println("Provided input is not a number. Try again");
            promptForInput();
        }
        return integer;
    }
}
