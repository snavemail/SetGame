import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.model.hw02.Card;

/**
 * Do not modify this file. This file should compile correctly with your code.
 * Class represents the tests
 */
public class Hw01TypeChecks {


  /**
   * Given method that creates a new SetThreeGameModel game.
   *
   * @param args represent various arguments that can be passed to the method.
   */
  public static void main(String[] args) {
    SetGameModel<Card> game = new SetThreeGameModel();
    helper(game);
  }

  /**
   * Helper method that starts the game and claims a set.
   *
   * @param model represents the game mode that will be used for the game.
   */
  private static void helper(SetGameModel<Card> model) {
    model.startGameWithDeck(model.getCompleteDeck(), 3, 3);
    model.claimSet(new Coord(0, 0),
            new Coord(0, 1),
            new Coord(0, 2));
  }


}
