import controller.BattleShipController;

import controller.enums.GameStatus;



public class Application {
        private static final int NUMBER_OF_SHIPS = 10;
        private static final BattleShipController controller =
                new BattleShipController(NUMBER_OF_SHIPS);

        public static void main(String[] args) {
                GameStatus status = GameStatus.START;

                while (status != GameStatus.END){
                        switch (status){
                                case START:
                                        gameStart();
                                        break;
                                case CONTINUE:
                                        gameContinue();
                                        break;
                                case WON:
                                        gameWin();
                                        break;
                                case RESET:
                                        gameReset();
                                        break;
                        }
                        status = controller.getStatus();
                }

                gameEnd();

        }

        public static void gameStart(){
                controller.configPlayers();
                controller.insertShips();
        }

        public static void gameContinue(){
                controller.play();
                controller.checkEndGame();
        }

        public static void gameWin(){
                controller.congratulateWinner();
                controller.verifyContinueOption();
        }

        public static void gameReset(){
                controller.reset();
        }

        public static void gameEnd(){
                controller.end();
        }
}
