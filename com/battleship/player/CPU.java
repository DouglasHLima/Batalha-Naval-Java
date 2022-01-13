package com.battleship.player;


import com.battleship.board.Board;
import com.battleship.coordinate_generator.model.Coordinate;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class CPU extends Player {

    private final List<Coordinate> coordinates = new ArrayList<>();

    SecureRandom sRandom = new SecureRandom();


    public CPU(String name, Board board){
        super(name, board);
    }

    public CPU(){}


    public void insertShips() {
        while(coordinates.size() < 10){
            Coordinate position = new Coordinate(
                    (sRandom.nextInt(10)+1),
                    (sRandom.nextInt(10)+1)
            );
            if (!this.coordinates.contains(position)){
                this.coordinates.add(position);
            }
        }
        super.insertShips(coordinates);
    }

    public void insertMove(Board boardReference) {
        Coordinate position;
        do{
            position = new Coordinate(
                    (sRandom.nextInt(10)+1),
                    (sRandom.nextInt(10)+1)
            );
        }while
        (this.playedCoordinates.contains(position));

        this.playedCoordinates.add(position);
        boardReference.insertMove(position.getROW(), position.getCOLUMN(),false);
        this.hitCount = boardReference.getHitCount();
    }



}
