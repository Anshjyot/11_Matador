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
    int house;
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
            switch (house) {
                case 0:
                    player.getAccount().setBalance(player.getAccount().getBalance() - rent0);
                    owner.getAccount().setBalance(owner.getAccount().getBalance() + rent0);
                    controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + "$" + rent0);
                case 1:
                    if (house == 1) {
                        player.getAccount().setBalance(player.getAccount().getBalance() - rent1);
                        owner.getAccount().setBalance(owner.getAccount().getBalance() + rent1);
                        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + "$" + rent0);
                    }
                case 2:
                    if (house == 2) {
                        player.getAccount().setBalance(player.getAccount().getBalance() - rent2);
                        owner.getAccount().setBalance(owner.getAccount().getBalance() + rent2);
                        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + "$" + rent0);
                    }
                case 3:
                    if (house == 3) {
                        player.getAccount().setBalance(player.getAccount().getBalance() - rent3);
                        owner.getAccount().setBalance(owner.getAccount().getBalance() + rent3);
                        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + "$" + rent0);
                    }
                case 4:
                    if (house == 4) {
                        player.getAccount().setBalance(player.getAccount().getBalance() - rent4);
                        owner.getAccount().setBalance(owner.getAccount().getBalance() + rent4);
                        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + "$" + rent0);
                    }
                case 5:
                    if (house == 5) {
                        player.getAccount().setBalance(player.getAccount().getBalance() - rent5);
                        owner.getAccount().setBalance(owner.getAccount().getBalance() + rent5);
                        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + "$" + rent0);
                    }
            }

        }
    }





}
