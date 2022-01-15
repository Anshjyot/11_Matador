package fields;

import GUI.GUIController;
import game.Player;
import language.Language;

public class BreweryField extends Field { // This class extends the Field class

    public BreweryField(String fieldname, int price, int rent0, int rent1, GUIController controller) {
        super(fieldname);
        this.price = price;
        this.rent0 = rent0;
        this.rent1 = rent1;
        this.controller = controller;
    }

    int price;
    int rent0;
    int rent1;
    Player owner;
    GUIController controller;

    @Override
    public void Arrived(Player player) { // This class creates the ownership for the brewery fields, you can buy and rent fields.
        if (owner == null) {
            player.getAccount().setBalance(player.getAccount().getBalance() - price);
            owner = player;
            Language.ArrivedBreweryText1(fieldName, price, player, controller);

        } else {
            player.getAccount().setBalance(player.getAccount().getBalance() - rent0);
            owner.getAccount().setBalance(owner.getAccount().getBalance() + rent0);
            Language.ArrivedBreweryText2(fieldName, rent0, player, owner, controller);

        }
    }

}

