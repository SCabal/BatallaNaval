package model;

import interfaces.*;
import java.util.Random;

public class Game implements IHit{

    public final static String BLANK_SPACE = "O";
    public final static String HIT_SPACE_BOARD = "#";
    public final static String HIT_SPACE_SHIP = "X";

    private Board boardProgram;
    private String[][] boardInterface;
    private Player player;

    public Game(){
        this.boardProgram = new Board();
        this.boardInterface = new String[11][11];
        this.player = new Player();
        initializeProgram();
        initializeInterface();
    }

    private void initializeProgram(){
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            int posx = random.nextInt(Board.SIZE_BOARD - 1);
            int posy = random.nextInt(Board.SIZE_BOARD - 1);
            int vertical = random.nextInt(2)+1;
            boolean isVertical = vertical == 1 ? true : false;

            switch(i){
                case 0:
                    AircraftCarrier air = new AircraftCarrier(posx, posy, isVertical);
                    boardProgram.addShip(air);
                    break;
                case 1:
                    Vessel ves = new Vessel(posx, posy, isVertical);
                    boardProgram.addShip(ves);
                    break;
                case 2:
                    Vessel ves1 = new Vessel(posx, posy, isVertical);
                    boardProgram.addShip(ves1);
                    break;
                case 3:
                    Submarine sub = new Submarine(posx, posy, isVertical);
                    boardProgram.addShip(sub);
                    break;
                case 4:
                    Submarine sub1 = new Submarine(posx, posy, isVertical);
                    boardProgram.addShip(sub1);
                    break;
                case 5:
                    Submarine sub2 = new Submarine(posx, posy, isVertical);
                    boardProgram.addShip(sub2);
                    break;
                default:
                    Boat boat = new Boat(posx, posy, isVertical);
                    boardProgram.addShip(boat);
                    break;
            }
        }
    }

    private void initializeInterface(){
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(i == 0 && j != 0){
                    boardInterface[i][j] = "" + j;
                }else if(j == 0 && i != 0){
                    boardInterface[i][j] = "" + i;
                }else{
                    boardInterface[i][j] = BLANK_SPACE;
                }
            }
        }
    }

    private void updateInterface(){
        int[][] tempBoard = boardProgram.getMatrix();
        for(int i = 1; i < 11; i ++ ){
            for(int j = 1; j < 11; j++){
                if(tempBoard[i-1][j-1] == Board.SPACE_HIT){
                    boardInterface[i][j] = HIT_SPACE_BOARD;
                }else if(tempBoard[i-1][j-1] == Board.SHIP_HIT){
                    boardInterface[i][j] = HIT_SPACE_SHIP;
                }
            }
        }
    }

    @Override
    public boolean hit(int x, int y){
        boolean isDeath = boardProgram.hit(x, y);

        if(isDeath) player.substractToCounter();
        else player.addToCounter();

        updateInterface();

        return isDeath;
    }

    public String[][] getInterface(){
        return this.boardInterface;
    }

    public int getCounterPlayer(){
        return this.player.getCounter();
    }

    public void addCounter(){
        player.addToCounter();
    }

    public void substractCounter(){
        player.substractToCounter();
    }

    public boolean playerLose(){
        return player.isLoser();
    }

    public boolean programLose(){
        return boardProgram.loser();
    }

}
