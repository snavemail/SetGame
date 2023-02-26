package cs3500.set.view;

import java.io.IOException;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.SetGameModelState;

/**
 * A class that represents the view of the game in text form. Shows a mxn grid laid out with each
 * card represented by their toString form.
 */
public class SetGameTextView implements SetGameView {


  private final SetGameModelState model;
  private final Appendable appendable;

  /**
   * Constructor for the SetGameTextView that takes in a SetGameModelState as a parameter.
   *
   * @param model represents the SetGameModelState.
   * @throws IllegalArgumentException when the model is null.
   */
  public SetGameTextView(SetGameModelState model) {
    this(model, System.out);
  }

  /**
   * Constructor for SetGameTextView that takes in a model and an appendable object.
   *
   * @param model      represents a model
   * @param appendable represents an appendable object.
   * @throws IllegalArgumentException when the model or appendable is null.
   */
  public SetGameTextView(SetGameModelState model, Appendable appendable)
          throws IllegalArgumentException {
    if (model == null || appendable == null) {
      throw new IllegalArgumentException("Model or Appendable cannot be null.");
    }
    this.model = model;
    this.appendable = appendable;
  }

  /**
   * Produces a textual view of the grid of cards of the current game.
   * Each card is displayed as initials of all of its attributes.
   * For instance, if a card has a single red oval, the card is displayed as 1RO.
   * If a card has three squiggly purple shapes, the card is displayed as 3PS.
   *
   * @return representation of the current state of the game
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < model.getHeight(); i++) { //No hardcoded max height.
      for (int j = 0; j < model.getWidth(); j++) { //No hardcoded max width.
        Card card = (Card) model.getCardAtCoord(i, j);
        if (j == model.getWidth() - 1) {
          sb.append(card.toString());
        } else {
          sb.append(card.toString()).append(" ");
        }
      }
      if (i < model.getHeight() - 1) {
        sb.append("\n");
      }
    }
    return sb.toString();
  }

  /**
   * Renders the grid to the board.
   *
   * @throws IOException if there is an issue with the input/output.
   */
  @Override
  public void renderGrid() throws IOException {
    appendable.append(this.toString());
  }

  /**
   * Renders the message to the board.
   *
   * @param message the message to be printed
   * @throws IOException if there is an issue with the input/output.
   */
  @Override
  public void renderMessage(String message) throws IOException {
    appendable.append(message);
  }
}

