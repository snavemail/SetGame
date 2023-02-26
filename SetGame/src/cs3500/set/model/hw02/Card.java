package cs3500.set.model.hw02;

/**
 * Represents a card in the Set game.
 * It has a count, a filling, and a shape.
 */
public class Card {
  private final Count count;
  private final Filling filling;
  private final Shape shape;

  /**
   * Represents a card with a count, a filling, and a shape (all represented as enums).
   *
   * @param count   represents the number of times the picture is shown on the card
   * @param filling represents what type of filling it has
   * @param shape   represents the shape of the picture
   * @throws IllegalArgumentException when you initialize the card with a null attribute
   */

  public Card(Count count, Filling filling, Shape shape) throws IllegalArgumentException {
    if (count == null || filling == null || shape == null) {
      throw new IllegalArgumentException("Card attributes cannot be null");
    }
    this.count = count;
    this.filling = filling;
    this.shape = shape;
  }

  /**
   * Returns a string representation of this card in the format "countfillingshape",
   * where count is the count attribute, filling is the first letter of the filling attribute,
   * and shape is the first letter of the shape attribute.
   */
  @Override
  public String toString() {
    return count.getValue() + filling.getValue() + shape.getValue();
  }

  /**
   * Returns the count of the Card.
   *
   * @return the count of the card
   */
  public Count getCount() {
    return count;
  }

  /**
   * Returns the filling of the Card.
   *
   * @return the filling of the card
   */

  public Filling getFilling() {
    return filling;
  }

  /**
   * Returns the shape of the Card.
   *
   * @return the shape of the card
   */
  public Shape getShape() {
    return shape;
  }
}
