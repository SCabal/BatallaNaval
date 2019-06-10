package model;

import interfaces.*;
import java.util.ArrayList;

public class Board implements IHit{

    // Constantes
    public static final int SIZE_BOARD = 10;
    public static final int SHIP_HIT = -2;
    public static final int SPACE_HIT = -1;

    // Atributos
    private int[][] board;
    private ArrayList<Ship> ships;

    public Board(){
        this.board = new int[SIZE_BOARD][SIZE_BOARD];
        this.ships = new ArrayList<Ship>();
        initializeBoard();
    }

    private void initializeBoard(){
        for(int i = 0; i < SIZE_BOARD; i++){
            for(int j = 0; j < SIZE_BOARD; j++){
                board[i][j] = 0;
            }
        }
    }

    public void addShip(Ship navio){
        for(int i = 0; i < navio.getSize(); i++){
            if(navio.getVertical()){ 
                board[navio.getPosX() + i][navio.getPosY()] = 1;
            }else{
                board[navio.getPosX()][navio.getPosY() + i] = 1;
            }
        }

        ships.add(navio);
    }

    private boolean verifyShips(){
        for(int i = 0; i < ships.size(); i++){

            int size = ships.get(i).getSize();
            int count = 0;

            for(int j = 0; j < size; j++){
                if(ships.get(i).getVertical()){
                    if(board[ships.get(i).getPosX()][ships.get(i).getPosY() + j] == SHIP_HIT){
                        count++;
                    }
                }else{
                    if(board[ships.get(i).getPosX() + j][ships.get(i).getPosY()] == SHIP_HIT){
                        count++;
                    }
                }
            }

            if(count == size){
                ships.remove(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean hit(int x, int y){
        if(board[x][y] == 1){
            board[x][y] = SHIP_HIT;
            return verifyShips();
        }else if(board[x][y] == 0){
            board[x][y] = SPACE_HIT;
        }
        return false;
    }

    public boolean loser(){
        return ships.size() == 0 ? true: false;
    }

    public int[][] getMatrix(){
        return this.board;
    }
}
