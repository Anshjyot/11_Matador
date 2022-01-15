package fields;

import GUI.GUIController;
import game.Player;
import gui_main.GUI;

import java.awt.*;

public class StreetField extends Property {
    public static boolean isThereAnOwner; // This class extends the Field class
    private int noOfHouses = 0;
    protected GUI gui;

    public StreetField(String fieldname, int price, int houseprice, int[] rent, Color color, int index) {
        super(fieldname, price);
        this.fieldName = fieldname;
        this.price = price;
        this.houseprice = houseprice;
        this.rent = rent;
        this.controller = controller;
        this.house = 0;
        this.index = index;
        this.color = color;
    }
    String fieldName;
    int price;
    int houseprice;
    int[] rent;
    int house;
    int index;
    Player owner;
    GUIController controller;
    Color color;

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

    int getPrice() {
        return this.price;
    }

    @Override
    int getRent() {
        return rent[noOfHouses];
    }
}
