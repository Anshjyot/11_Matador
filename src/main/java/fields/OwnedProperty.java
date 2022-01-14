package fields;

import GUI.GUIController;
import game.Player;
import gui_main.GUI;

import java.awt.*;

public class OwnedProperty extends Field {
    public static boolean isThereAnOwner; // This class extends the Field class

    protected GUI gui;

    public OwnedProperty(String fieldname, int price, int houseprice, int[] rent, Color color, int index, GUIController controller) {
        super(fieldname);
        this.price = price;
        this.houseprice = houseprice;
        this.rent = rent;
        this.controller = controller;
        this.color = color;
        this.house = 0;
        this.index = index;
    }

    int price;
    int houseprice;
    int[] rent;
    int house;
    int index;
    Player owner;
    GUIController controller;
    Color color;

    public int getPrice(){return price;}
    public String getFieldName(){return fieldName;}
  //  public boolean inJail() {}
        //if players current position is jailfield 30.
       // if (inJail(30)

    public Color getColor() {
        return color;
    }

    public int getIndex() {
        return index;
    }

    public void addHouse() {
        house = house+1;
    }
}
