package cs3500.set.model.hw02;

/**
 * Enum represents the possible values for the count attribute. Used in the Card class.
 */
public enum Count {
  ONE(1), TWO(2), THREE(3);

  private final int value;

  /**
   * Constructor to represent the Count.
   *
   * @param value represents the number of times the shape is shown on the card
   */
  Count(int value) {
    this.value = value;
  }

  /**
   * Returns the count value of the card.
   *
   * @return an int that represents the number of shapes on the card.
   */
  public int getValue() {
    return value;
  }
}
