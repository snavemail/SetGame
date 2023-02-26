package cs3500.set.model.hw02;

import java.util.List;

import cs3500.set.model.hw03.AbstractSetGameModel;

/**
 * Class that represents the Set game modified to have a 3x3 board with only 3 attributes.
 */
public class SetThreeGameModel extends AbstractSetGameModel {

  /**
   * If the cards at the specified coordinates form a valid set, claim it,
   * and replace those cards with new cards from the deck, if possible.
   *
   * @param coord1 the coordinates of the first card
   * @param coord2 the coordinates of the second card
   * @param coord3 the coordinates of the third card
   * @throws IllegalArgumentException if any of the coordinates are invalid for the particular
   *                                  implementation of Set OR the cards at
   *                                  those coordinates do not form a set
   * @throws IllegalStateException    if the game has not started or the game has already ended
   */
  @Override
  public void claimSet(Coord coord1, Coord coord2, Coord coord3) throws IllegalArgumentException,
          IllegalStateException {
    abstractClaimSet(coord1, coord2, coord3);
  }

  /**
   * Begins the game using the cards given by the deck creates a grid specified
   * by the height and width parameters.
   * Specifically, the model deals the cards onto the board from left to right and top to bottom,
   * filling the grid.
   *
   * @param deck   the list of cards in the order they will be played
   * @param height the height of the board for this game
   * @param width  the width of the board for this game
   * @throws IllegalArgumentException if the deck does not have enough cards to deal 9 cards to the
   *                                  grid,
   *                                  OR the deck is null,
   *                                  OR the width/height are not 3
   */

  public void startGameWithDeck(List<Card> deck, int height, int width) throws
          IllegalArgumentException, IllegalStateException {
    if (deck == null) {
      throw new IllegalArgumentException("Deck cannot be null");
    }
    if (height != 3 || width != 3) {
      throw new IllegalArgumentException("Given height or width are invalid");
    }
    if (deck.size() < 9) {
      throw new IllegalArgumentException("Deck size not big enough to start game");
    }
    abstractStartGameWithDeck(deck, height, width);
  }
}
