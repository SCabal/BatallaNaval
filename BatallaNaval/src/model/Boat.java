package model;

public class Boat extends Ship{

    public final static int SIZE_BOAT = 1;

    public Boat(int posx, int posy, boolean isVertical){
        super(posx, posy, SIZE_BOAT, isVertical);
    }
}
