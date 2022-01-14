package fields;

import GUI.GUIController;
import game.Player;

public class FerryField extends Field { // This class extends the Field class

    public FerryField(String fieldname, int price, int rent0, int rent1, int rent2, int rent3, GUIController controller) {
        super(fieldname);
        this.price = price;
        this.rent0 = rent0;
        this.rent1 = rent1;
        this.rent2 = rent0;
        this.rent3 = rent1;
        this.controller = controller;
    }

    int price;
    int rent0;
    int rent1;
    int rent2;
    int rent3;

    Player owner;
    GUIController controller;

    public void Arrived(Player player) { // This class creates the ownership for the fields, you can buy and rent ferryfields.
        if (owner == null) {
            player.getAccount().setBalance(player.getAccount().getBalance() - price);
            owner = player;
            controller.showMessage(player.getPlayerName() + " bought " + fieldName + " for " + price + " dkk ");

        } else {
            player.getAccount().setBalance(player.getAccount().getBalance() - rent0);
            owner.getAccount().setBalance(owner.getAccount().getBalance() + rent0);
            controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + rent0 + " dkk ");
        }
    }
}
