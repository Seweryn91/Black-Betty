# Black-Betty
Black Betty, or variation of Black Peter (Old Maid) card game.


It's a simple in-terminal hot-seat card game for 2 to 4 players.
Deck of cards is dealt amongst players, from first player to last, sometimes unevenly.


Game begins:
Player draws single top card from previous player's hand (counter-clockwise). 
![1begingame](https://user-images.githubusercontent.com/34771956/78029039-3dda6900-7360-11ea-924b-f530262683c6.png)

After that player is supossed to choose one pair of cards (matching value or suit) and discard them each turn.

After discarding player may choose to shuffle his/her hand.
![3](https://user-images.githubusercontent.com/34771956/78029044-3e72ff80-7360-11ea-9b37-2ed7dddbec7d.png)

The twist is, that Joker is placed in deck, so it's the only one card not matching others, therefore is indiscardable.
Game runs until there's last player with cards on his/her hand. That's the looser.


Sometimes player has no discardable cards. Player then is prompted whether he/she wants to shufle his/her hand.
![4nodiscard](https://user-images.githubusercontent.com/34771956/78029046-3f0b9600-7360-11ea-95a8-6b9711a481c6.png)


In rare case, players have cards on their hands, but none of them can match the other. In that situation game is draw.
![5draw](https://user-images.githubusercontent.com/34771956/78029032-3c10a580-7360-11ea-84c9-556f8af6f713.png)

### HOW TO RUN
Just open terminal, and type command
> mvn clean compile exec:java
