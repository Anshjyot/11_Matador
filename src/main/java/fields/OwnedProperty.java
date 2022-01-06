package fields;

import GUI.GUIController;
import game.Player;

public class OwnedProperty extends Field { // This class extends the Square class

    public OwnedProperty(String fieldname, int price, int houseprice, int rent0, int rent1, int rent2, int rent3, int rent4, int rent5, GUIController controller) {
        super(fieldname);
        this.price = price;
        this.houseprice = houseprice;
        this.rent0 = rent0;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.rent5 = rent5;
        this.controller = controller;
    }

    int price;
    int houseprice;
    int rent0;
    int rent1;
    int rent2;
    int rent3;
    int rent4;
    int rent5;
    Player owner;
    GUIController controller;

    @Override
    public void Arrived(Player player) { // This class creates the ownership for the fields, you can buy and rent fields.
        if (owner == null){
            player.getAccount().setBalance(player.getAccount().getBalance() - price);
            owner = player;
            controller.showMessage(player.getPlayerName() + " bought " + fieldName + " for " + "$"+price);
        }

        else {
            player.getAccount().setBalance(player.getAccount().getBalance() - rent0);
            owner.getAccount().setBalance(owner.getAccount().getBalance() + rent0);
            controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName()+"'s" + " property: " +  fieldName + " for " + "$"+rent0);
        }
    }





}
