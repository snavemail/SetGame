# README for Set Game - Java

### Introduction

Set is a single-player card game played with a deck of cards. The game involves laying out the top cards of the deck in a grid format and choosing three cards to declare as a set. If a set is correctly declared, the chosen cards are removed from the grid and replaced with three new cards from the deck.

This version of Set is called SetThree and uses cards with three attributes instead of four. The game is played by making a 3 by 3 grid of cards. This was later adapted to work with any positive sized grid of cards as long as there were at least 3 cards. If there ever was not a set on the board, it would populate more in until there was a set on the board.

### Game Play
The game starts by putting the top cards of the deck in a grid from left to right and top to bottom. If we label the first 9 cards 1 to 9, where 1 is the card at the top of the deck, the cards are laid in the following order:

```
1 2 3
4 5 6
7 8 9
```

Once the grid is filled, you must then find 3 cards to make a set. A set is a group of 3 cards such that for each attribute,

* all 3 cards have the same value for this attribute OR
* the 3 cards each have different values for this attribute

In order to play any game of Set, we would need the model to have the following:

* The ability to start a new game
* The ability to retrieve the contents of the grid (i.e., the state of the game)
* The ability to retrieve the current score
* The ability to know whether any sets are possible with the current grid
* The ability to know when the game is actually over
* The ability to declare three cards are a set
* A deck someone can use to start playing

### Generalizing Set
SetThree uses a very strict grid: a 3x3 grid. However, the true game of Set is played on a 4 by 3 grid. In fact, there are only a few things stopping us from using any grid size. Those conditions are:

* There is enough space to have at least 3 cards on the grid
* There are enough cards in the deck to populate the grid at the start of the game

And naturally, we use positive dimensions only

The goal will be to generalize the game of Set into GeneralSet. This game is played on a user-defined m by n grid, where m and n are positive integers.

### Implementation

This assignment requires the implementation of a controller for the Set game. The controller will "run" a game of Set, asking for input and producing outputs. The controller will work with the model to ask the user for integers that represent rows and columns of the grid. If the model accepts the 3 coordinates given, it will then try to claim the set. If at any point the user types "Q" or "q", then the game should quit.

### Graphical User Interface
The graphical user interface had us

* Construct a working GUI using Java Swing
* Incorporate the GUI in an existing model-view-controller design

A user can click on the drawn grid and the card will glow indicating it has been clicked. If 3 cards were clicked that form a set, those cards a removed a new set of cards are populated. The game ends as usual.

### Conclusion
This implementation allows players to enjoy the Set game with a 3 by 3 grid or any other positive integer grid of their choice. Good luck!




2023 Liam Evans copyright.
