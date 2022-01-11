package controller;

import board.Board;
import controller.enums.GameStatus;
import coordinate_generator.CoordinateGenerator;
import coordinate_generator.model.Coordinate;
import player.CPU;
import player.Player;
import utils.Verifiyer;
import utils.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleShipController {
    private final Integer NUMBER_OF_SHIPS;
    private final Integer BOARD_ROW_SIZE = 11;
    private final Integer BOARD_COLLUMN_SIZE = 11;
    private final Character INITIAL_BOARD_LETTER_SIZE = 'A';
    private final Integer OFFSET_BOARD_POSITION = 1;

    private final CoordinateGenerator readCoordinates =
            new CoordinateGenerator(INITIAL_BOARD_LETTER_SIZE,OFFSET_BOARD_POSITION);

    private Scanner reader = new Scanner(System.in);



    private final Verifiyer verifyRange = (row, collumn) ->
            row > 0 && collumn > 0 && row < BOARD_ROW_SIZE && collumn < BOARD_COLLUMN_SIZE;

    private final Verifiyer isHigherOrEqualThan = (valueToCompare,limit) ->
            valueToCompare >= limit;

    private  Player playerOne;
    private  CPU playerTwo;
    private GameStatus status;

    public BattleShipController(Integer number_of_ships) {
        this.NUMBER_OF_SHIPS = number_of_ships;
    }

    public void configPlayers(){
        this.initPlayersInstances();
        Board playerOneBoard = new Board();
        Board playerTwoBoard = new Board();
        Printer.GetPlayersNames(1);
        this.playerOne.setName(this.reader.nextLine());
        this.playerOne.setBoard(playerOneBoard);
        this.playerTwo.setName("player.CPU");
        this.playerTwo.setBoard(playerTwoBoard);
    }

    public void insertShips(){
        Printer.GetPlayersShips(this.playerOne.getName());
        this.playerOne.insertShips(this.setShips(NUMBER_OF_SHIPS));
        this.playerTwo.insertShips();
        Printer.allOk();
        this.status = GameStatus.CONTINUE;
    }

    public void play(){
        playerOne.printBoard();
        Printer.playerInsertPosition(this.playerOne.getName());
        playerOne.insertMove(insertPosition(),playerTwo.getBoard());
        playerTwo.insertMove(playerOne.getBoard());
    }

    public void congratulateWinner(){
        if(isHigherOrEqualThan.verify(this.playerOne.getHitCount(),this.playerTwo.getHitCount())) {
            Printer.congrats(playerOne.getName());
        }else{
            Printer.congrats(playerTwo.getName());
        }
        Printer.boardHeader(playerOne.getName());
        playerOne.printBoard();
        Printer.boardHeader(playerTwo.getName());
        playerTwo.printBoard();
    }

    public void checkEndGame(){
        if(isHigherOrEqualThan.verify(this.playerOne.getHitCount(),NUMBER_OF_SHIPS)) {
            this.status = GameStatus.WON;
        }else if(isHigherOrEqualThan.verify(this.playerTwo.getHitCount(),NUMBER_OF_SHIPS)){
            this.status = GameStatus.WON;
        }else{
            this.status = GameStatus.CONTINUE;
        }
    }

    public void verifyContinueOption(){
        final char KEY_TO_CONTINUE = 's';
        Printer.continueOrExit();
        char response = reader.next().charAt(0);
        this.status = response == KEY_TO_CONTINUE ?
                            GameStatus.RESET :
                            GameStatus.END;
    }

    public void reset(){
        this.playerOne = null;
        this.playerTwo = null;
        this.reader = new Scanner(System.in);
        this.status = GameStatus.START;
    }

    public void end(){
        this.reader.close();
    }

    private void initPlayersInstances(){
        this.playerOne = new Player();
        this.playerTwo = new CPU();
    }

    public GameStatus getStatus(){
        return this.status;
    }

    private List<Coordinate> setShips(Integer listSize) {
        List<Coordinate> coordinates = new ArrayList<>();
        while (coordinates.size() < listSize){
            Printer.insertShipPosition((coordinates.size()+1));
            Coordinate position = this.insertPosition();
            if (!coordinates.contains(position)) {
                coordinates.add(position);
            }else {
                Printer.positionAlreadyExists();
            }
        }
        return coordinates;
    }

    private Coordinate insertPosition(){
        while (true) {
            try {
                Coordinate position = readCoordinates.getCoordinate(this.reader.nextLine());
                if (verifyRange.verify(position.getROW(), position.getCOLUMN())) {
                    return position;
                } else {
                    Printer.invalidPosition();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

