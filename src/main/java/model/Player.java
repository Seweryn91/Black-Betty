package model;

public class Player {

    private Hand hand;
    private String name;
    private boolean isActive;


    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.isActive = true;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
