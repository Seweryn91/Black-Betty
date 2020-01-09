package controller;

import model.Player;

import java.util.List;

public interface Game {

    void play(List<Player> players, int lowestCardValue);
}
