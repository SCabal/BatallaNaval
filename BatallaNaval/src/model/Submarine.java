package model;

public class Submarine extends Ship{

    public final static int SIZE_SUBMARINE = 3;

    public Submarine(int posx, int posy, boolean isVertical){
        super(posx, posy, SIZE_SUBMARINE, isVertical);
    }
}
