package cs3500.set.model.hw02;

/**
 * Enum represents the possible values for the shape attribute. Used in the Card class.
 */
public enum Shape {
  OVAL("O"), SQUIGGLE("Q"), DIAMOND("D");

  private final String value;

  /**
   * Constructor to represent the Filling.
   *
   * @param value represents what type of filling the card has
   */
  Shape(String value) {
    this.value = value;
  }

  /**
   * Returns the shape value of the card as the first letter of the shape except for "Squiggle",
   * which uses a "Q" to represent its value.
   *
   * @return a string that is the first letter of the shape.
   */
  public String getValue() {
    return value;
  }
}
