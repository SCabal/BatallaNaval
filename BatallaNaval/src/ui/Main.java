package ui;

import model.*;
import java.util.Scanner;

public class Main{
    private Game game;
	private static Scanner scan;

    public Main(){
        game = new Game();
    }
    public Game getGame(){
        return this.game;
    }

    public static void main(String[] args){
        Main main = new Main();
        Game game = main.getGame();
        scan = new Scanner(System.in);
        main.printMatrix();
        boolean flag = true;

        while(flag){
            System.out.println("Elija Cordenada X: ");
            int x;
            int y;
            x = scan.nextInt();
            System.out.println("Elija Cordenada Y: ");
            y = scan.nextInt();

            boolean damage = game.hit(x, y);

            if(damage) {
                game.substractCounter();
                System.out.println("Has undido un barco!");
            }else{
                game.addCounter();
            }

            main.printMatrix();
            System.out.println("Intento Numero: " + game.getCounterPlayer() + " de 80(los intentos aumentan de 2 en 2)");

            if(game.playerLose()){
                System.out.println("Lo siento. Tu has PERDIDO");
                flag = false;
            } 

            if(game.programLose()){
                System.out.println("Has GANADO <3");
                flag = false;
            }

        }

    }

    public void printMatrix(){
        String[][] matrix = game.getInterface();
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                System.out.print(matrix[i][j] + " ");
                if(j == 10) System.out.println("");
            }
        }
    }
}
