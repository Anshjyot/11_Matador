package fields;

import GUI.GUIController;
import game.Player;
import gui_main.GUI;
import language.Language;

import java.awt.*;

public class OwnedProperty extends Field {
    // This class extends the Field class

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
        if (owner == null) { // If there is no owner, you can buy the field
            controller.wannaBuy(this, player);
        }

        else if(owner != player){ // If the field has an owner, then player "pays" rent to owner
            player.getAccount().setBalance(player.getAccount().getBalance() - rent[house]);
            owner.getAccount().setBalance(owner.getAccount().getBalance() + rent[house]);
            Language.ArrivedOwnedPropertyText(fieldName, rent, player, owner, controller); // Message sent from the Language class

        }

    }

    public String getOwner() {
        if(owner == null) {
            return "";
        }
        return owner.getPlayerName();

    }

  //  public boolean inJail() {}
        //if players current position is jailfield 30.
       // if (inJail(30)


    //check if there is an owner
    public boolean isThereAnOwner() {
        return owner != null;

    }

    public void buyDeed(Player player){ // Method used in wannaBuy method, in the GUIController
         player.getAccount().setBalance(player.getAccount().getBalance() - price);
         owner = player;
         Language.BuyDeedOwnedPropertyText(fieldName, price, player, controller);
     }
    public Color getColor() {
        return color;
    }

    public int getIndex() {
        return index;
    }

    public void addHouse() {
        house = house+1;
    } // adds house to field



    }
