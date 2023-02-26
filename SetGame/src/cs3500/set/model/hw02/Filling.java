package cs3500.set.model.hw02;

/**
 * Enum represents the possible values for the filling attribute. Used in the Card class.
 */
public enum Filling {
  EMPTY("E"), STRIPED("S"), FULL("F");

  private final String value;

  /**
   * Constructor to represent the Filling.
   *
   * @param value represents what type of filling the card has
   */
  Filling(String value) {
    this.value = value;
  }

  /**
   * Returns the filling value of the card as the first letter of the filling.
   *
   * @return a string that is the first letter of the filling.
   */
  public String getValue() {
    return value;
  }
}
