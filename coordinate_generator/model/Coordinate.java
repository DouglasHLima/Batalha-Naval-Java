package coordinate_generator.model;

import java.util.Objects;

public class Coordinate {
  private final int ROW;
  private final int COLUMN;

  public Coordinate(int row, int column) {
    this.ROW = row;
    this.COLUMN = column;
  }

  public int getROW() {
    return ROW;
  }

  public int getCOLUMN() {
    return COLUMN;
  }

  @Override
  public String toString() {
    return "Coordinate{" + "ROW=" + ROW + ", COLUMN=" + COLUMN + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Coordinate))
      return false;
    Coordinate that = (Coordinate) o;
    return Objects.equals(getROW(), that.getROW()) && Objects.equals(getCOLUMN(), that.getCOLUMN());
  }

}