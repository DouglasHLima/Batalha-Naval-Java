package controller;

public class BattleShipControllerTest {

        public static void main(String[] args){
            BattleShipController control = new BattleShipController(10);
            control.configPlayers();
            control.insertShips();
            control.play();
            control.congratulateWinner();
            control.verifyContinueOption();
            control.reset();


        }

}
