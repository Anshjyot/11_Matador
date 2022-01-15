package fields;

import game.Player;

import java.awt.*;

public abstract class Property extends Field{
    int price;
    int owner;
    String fieldName;

    public Property (String fieldName, int price){
        this.fieldName = fieldName;
        this.price = price;
        this.owner = 10;
    }

    abstract int getRent();

    public int getOwner() {
        return owner;
    }
    public void setOwner(int owner) {
        this.owner = owner;
    }
    boolean isOwned(){return owner != 10;}
}
