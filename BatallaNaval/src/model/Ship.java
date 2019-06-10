package model;

public abstract class Ship{

    private int posx;
    private int posy;
    private int size;
    private boolean death;
    private boolean isVertical;

    public Ship(int posx, int posy, int size, boolean isVertical){
        this.posx = posx;
        this.posy = posy;
        this.size = size;
        this.death = false;
        this.isVertical = isVertical;
    }

    public int getPosX(){
        return this.posx;
    }

    public int getPosY(){
        return this.posy;
    }

    public boolean isDeath(){
        return death;
    }

    public void setPosX(int x){
        this.posx = x;
    }

    public void setPosY(int y){
        this.posy = y;
    }

    public void makeDeath(){
        if(!death) death = true;
    }

    public int getSize(){
        return this.size;
    }

    public boolean getVertical(){
        return this.isVertical;
    }
}
