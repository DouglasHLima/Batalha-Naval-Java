package coordinate_generator;

import coordinate_generator.model.Coordinate;
import java.util.function.Function;

/**
 * this class provides a simple way to get an array of coordinate integers by
 * string entries, such as: A1, B2, etc. the initial value provided starts at
 * [1,1]
 */

public class CoordinateGenerator {

  private int INITIAL_VALUE;
  private int OFFSET;

  /**
   * An initial value is required to calculate the start of valid character values
   */
  public CoordinateGenerator(Character initialValue, int offset) {
    this.INITIAL_VALUE = Character.toLowerCase(initialValue);
    this.OFFSET = offset;
  }


  private final Function<String, Integer> stringToInteger = (
      value) -> Character.isDigit(value.charAt(0)) ?
          Integer.parseInt(value) : (int) value.charAt(0) - INITIAL_VALUE + this.OFFSET;

  public Coordinate getCoordinate(String input) throws Exception {
    String[] entries;
    try {
      entries = input.toLowerCase().replace(" ", "").split("", 2);
    }catch (Exception e){
      throw new Exception(e);
    }


    return new Coordinate(stringToInteger.apply(entries[0]), stringToInteger.apply(entries[1]));

  }
}
