package model;

public class Player{

    public static final int ATTEMPTS = 80;

    private int counter;

    public Player(){
        this.counter = 0;
    }

    public int getCounter(){
        return this.counter;
    }

    public void addToCounter(){
        counter += 1;
    }

    public void substractToCounter(){
        counter -= 6;
    }

    public boolean isLoser(){
        return counter == ATTEMPTS;
    }
}
