package player;

import board.Board;
import coordinate_generator.model.Coordinate;


import java.util.ArrayList;
import java.util.List;


public class Player {

    private String name;
    protected Integer hitCount = 0 ;
    protected ArrayList<Coordinate> cordinates = new ArrayList<>();
    protected ArrayList<Coordinate> playedCordinates = new ArrayList<>();
    protected Board board;

    Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public Player(){}

    public void setName(String name) {
        this.name = name;
    }
    public void setBoard(Board board) {
        this.board = board;
    }



    public void insertShips(List<Coordinate> ships){
            ships.forEach(coordinate ->
                    this.board.insertShips(
                            coordinate.getROW(),
                            coordinate.getCOLUMN())
            );
    }


    public void insertMove(Coordinate position, Board boardReference) {
        boardReference.insertMove(position.getROW(), position.getCOLUMN());
        playedCordinates.add(position);
        this.hitCount = boardReference.getHitCount();
    }

    public void printBoard () {
        board.printBoard();
    }

    public List<Coordinate> getPlayedCordinates() {
        return playedCordinates;
    }

    public Board getBoard(){
        return this.board;
    }

    public Boolean isComplete(Integer maxHitValue){
        return this.hitCount >= maxHitValue;
    }

    public Integer getHitCount() {
        return hitCount;
    }

    public String getName() {
        return this.name;
    }
}
