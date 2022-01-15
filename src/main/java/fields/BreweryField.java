package fields;

import GUI.GUIController;
import game.Player;

public class BreweryField extends Property { // This class extends the Field class

    public BreweryField(String fieldname, int price, int rent0, int rent1) {
        super(fieldname, price);
        this.price = price;
        this.rent0 = rent0;
        this.rent1 = rent1;
    }

    int price;
    int rent0;
    int rent1;

    @Override
    int getRent() {
        return rent0;
    }

    @Override
    int getPrice() {return this.price;}

}

