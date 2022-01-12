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

    @Override
    public void Arrived(Player player) { // This class creates the ownership for the fields, you can buy and rent fields.
        if (owner == null) {
            player.getAccount().setBalance(player.getAccount().getBalance() - price);
            owner = player;
            controller.showMessage(player.getPlayerName() + " bought " + fieldName + " for " + price + " dkk ");
        } else {
            player.getAccount().setBalance(player.getAccount().getBalance() - rent[house]);
            owner.getAccount().setBalance(owner.getAccount().getBalance() + rent[house]);
            controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + rent[house] + " dkk ");


        }
    }

    public String getOwner() {
        if(owner == null) {
            return "";
        }
        return owner.getPlayerName();

    }

    //check if there is an owner
    public boolean isThereAnOwner(){
        if (owner==null) {

            return true;
        }
        else {
            return false;
        }
    }
    public void buyDeed(Player player){
         player.getAccount().setBalance(player.getAccount().getBalance() - price);
         owner = player;
         controller.showMessage(player.getPlayerName() + " bought " + fieldName + " for " + price + " dkk ");

     }
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
