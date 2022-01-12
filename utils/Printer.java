package utils;

public final class Printer {
    private Printer(){}
    public static final String GET_PLAYERS_NAME = "Insira o nome do jogador";
    public static final String GET_SHIPS = "Insira as posições dos barcos";
    public static final String INSERT_POSITION = "Insira a posição";
    public static final String INVALID_POSITION = "Posição inválida, tente novamente";
    public static final String POSITION_ALREADY_EXISTS = "Posição já inserida, tente novamente";
    public static final String ALL_OK = "Tudo pronto! Vamos começar!";
    public static final String INSERT_POSITION_TO_ATTACK = "Insira a posição para atacar";
    public static final String SHIP_HIT = "Acertou um navio, parabéns!";
    public static final String WATER_HIT = "Que pena, tiro na água!";
    public static final String CONGRATULATE_PLAYER = "PARABÉNS!!! Você ganhou!!";
    public static final String BOARD_HEADER = "<------------------------------->\n";
    public static final String CONTINUE_OPTION = "Para reiniciar o jogo digite 's' ou outro botão para encerrar";

    public static void GetPlayersNames(int playerNumber){
        System.out.printf("%n%s nº%d: ",GET_PLAYERS_NAME,playerNumber);
    }
    public static void GetPlayersShips(String playerName){
        System.out.printf("%n%s %s: ",playerName,GET_SHIPS);
    }
    public static void insertShipPosition(int numberOfShip){
        System.out.printf("%n%s nº%d: ",INSERT_POSITION,numberOfShip);
    }
    public static void invalidPosition(){
        System.out.printf("%n%s%n",INVALID_POSITION);
    }
    public static void positionAlreadyExists(){
        System.out.printf("%n%s%n",POSITION_ALREADY_EXISTS);
    }
    public static void allOk(){
        System.out.printf("%n%s%n",ALL_OK);
    }
    public static void playerInsertPosition(String playerName){
        System.out.printf("%n%s: %s : ",playerName,INSERT_POSITION_TO_ATTACK);
    }

    public static void congrats(String name){
        System.out.printf("%n%s %s%n",name,CONGRATULATE_PLAYER);
    }
    public static void boardHeader(String name){
        System.out.printf("%n%s%nPlayer Name: %s%n",BOARD_HEADER,name);
    }
    public static void continueOrExit(){
        System.out.println(CONTINUE_OPTION);
    }

    public static void shipHit() {
      System.out.println(SHIP_HIT);
    }
    public static void waterHit() {
      System.out.println(WATER_HIT);
    }

}
