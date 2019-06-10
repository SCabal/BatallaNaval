package model;

public class AircraftCarrier extends Ship{

    public final static int SIZE_AIRCRAFT = 5;

    public AircraftCarrier(int posx, int posy, boolean isVertical){
        super(posx, posy, SIZE_AIRCRAFT, isVertical);
    }
}

