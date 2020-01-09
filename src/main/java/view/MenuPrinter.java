package view;

public class MenuPrinter {

    public void printHeader() {
        System.out.println("Welcome to Black Betty!");
    }

    public void printRules() {
        StringBuilder sb = new StringBuilder();
        sb.append("1. Choose number of players").append('\n').
                append("2. Choose lowest card value between 2 and 9 (2 = 53 cards, 9 = 25 cards)").append('\n').
                append("3. There is one Joker added to the deck").append('\n').
                append("4. Cards are dealt amongst players (sometimes unequally) clockwise").append('\n').
                append("5. First player takes card from his left-side opponent (counterclockwise)").append('\n').
                append("6. Choose pair of cards to discard (matching suit or value). Joker cannot be discarded!").
                append('\n').append("7. Each player must discard two cards each turn.").append('\n').
                append("8. If no matching pair is present in his/her hand player may still shuffle hand").append('\n').
                append("9. After discarding and shuffling next right-hand player begins his/hers turn").append('\n').
                append("10. Last player with cards in his/her hand looses").append('\n')
                .append("11. Have fun!");

        System.out.println(sb.toString());
    }

    public void printOptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("Choose option:").append('\n').append("0. Start game").append('\n').append("1. Show rules").
                append('\n').append("2. Exit");
        System.out.println(sb.toString());
    }
}
