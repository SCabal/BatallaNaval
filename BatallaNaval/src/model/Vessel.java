package model;

public class Vessel extends Ship{

    public final static int SIZE_VESSEL = 4;

    public Vessel(int posx, int posy, boolean isVertical){
        super(posx, posy, SIZE_VESSEL, isVertical);
    }
}
