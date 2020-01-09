# Black-Betty
Black Betty, or variation of Black Peter (Old Maid) card game.

It's a simple in-terminal hot-seat card game for 2 to 4 players.
Deck of cards is dealt amongst players, from first player to last, sometimes unevenly.
Game begins:
Player draws single top card from previous player's hand (counter-clockwise). 
After that player is supossed to choose one pair of cards (matching value or suit) and discard them each turn.
After discarding player may choose to shuffle his/her hand.
The twist is, that Joker is placed in deck, so it's the only one card not matching others, therefore is indiscardable.
Game runs until there's last player with cards on his/her hand. That's the looser.

In rare case, players have cards on their hands, but none of them can match the other. In that situation game is draw.

#HOW TO RUN
Just open terminal, and type command
$> mvn clean compile exec:java
