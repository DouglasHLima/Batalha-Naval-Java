package com.battleship.coordinate_generator;

import java.util.Scanner;
import com.battleship.coordinate_generator.model.Coordinate;

public class CordinateGeneradorTest {
  public static void main(String[] args) {
    CoordinateGenerator reader = new CoordinateGenerator('A',1);
    System.out.println("insira uma cordenada");
    Integer[] a;
    Scanner input = new Scanner(System.in);
    Coordinate co1 = new Coordinate(1, 1);
    Coordinate co2 = new Coordinate(1, 1);
    System.out.println(co1.equals(co2));

    while (true) {

      try {

        System.out.println(reader.getCoordinate(input.nextLine()));
        break;

      } catch (Exception e) {
        System.out.println("Valor invalido");
        e.printStackTrace();
      }
    }

  }
}
