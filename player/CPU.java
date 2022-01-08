package player;


import board.Board;
import coordinate_generator.model.Coordinate;

import java.security.SecureRandom;


public class CPU extends Player {

    private final Board board = super.board;

    SecureRandom sRandom = new SecureRandom();

    public CPU(String name, Board board){
        super(name, board);
    }

    public CPU(){}


    public void insertShips() {
        while(cordinates.size() < 10){
            Coordinate position = new Coordinate(
                    (sRandom.nextInt(10)+1),
                    (sRandom.nextInt(10)+1)
            );
            if (!cordinates.contains(position)){
                cordinates.add(position);
            }
        }
        super.insertShips(cordinates);
    }

    public void insertMove(Board boardReference) {
        Coordinate position;
        do{
            position = new Coordinate(
                    (sRandom.nextInt(10)+1),
                    (sRandom.nextInt(10)+1)
            );
        }while
        (this.playedCordinates.contains(position));

        this.playedCordinates.add(position);
        boardReference.insertMove(position.getROW(), position.getCOLUMN());
        this.hitCount = boardReference.getHitCount();
    }



}
