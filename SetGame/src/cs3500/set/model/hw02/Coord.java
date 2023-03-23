package cs3500.set.model.hw02;

import java.util.Objects;

/**
 * Represents a two-dimensional coordinate.
 * Rows extend downward; columns extend rightward.
 */
public final class Coord {
  public final int row;
  public final int col;

  public Coord(int row, int col) {
    this.row = row;
    this.col = col;
  }

  /**
   * Returns the row of this coordinate.
   *
   * @return the row of this coordinate
   */
  public int getRow() {
    return row;
  }

  /**
   * Returns the column of this coordinate.
   *
   * @return the column of this coordinate
   */
  public int getCol() {
    return col;
  }

  @Override
  public String toString() {
    return String.format("(r%d,c%d)", row, col);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coord coord = (Coord) o;
    return row == coord.row && col == coord.col;
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, col);
  }
}
