package fields;

import GUI.GUIController;

public class FerryField extends Property { // This class extends the Field class

    public FerryField(String fieldname, int price, int rent0, int rent1, int rent2, int rent3) {
        super(fieldname,price);
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

    GUIController controller;

    @Override
    int getRent() {
        return 0;
    }
}
