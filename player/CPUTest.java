package player;

import board.Board;

public class CPUTest {
    public static void main(String[] args) {
        Board board = new Board();
        CPU player = new CPU();
        Board board2 = new Board();
        CPU player2 = new CPU();

        player.setName("CPU");
        player.setBoard(board);
        player2.setName("CPU");
        player2.setBoard(board2);

        player.insertShips();
        player.printBoard();
        player2.insertShips();
        player2.printBoard();


     while(!player.isComplete(10) && !player2.isComplete(10)) {

         player.insertMove(player2.getBoard());
         player2.insertMove(player.getBoard());

         System.out.println("player 1 ");
         System.out.println(player.getPlayedCordinates());
         player.printBoard();

         System.out.println("player 2");
         System.out.println(player2.getPlayedCordinates());
         player2.printBoard();
     }

        System.out.println("Player 1 = " + player.getHitCount());
        System.out.println("Player 2 = " + player2.getHitCount());
    }

}
