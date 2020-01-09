package model;

import java.util.List;

public interface Game {

    void play(List<Player> players, int lowestCardValue);
}
