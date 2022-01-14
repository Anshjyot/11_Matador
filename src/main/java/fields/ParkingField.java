package fields;

import GUI.GUIController;
import game.Player;

public class ParkingField extends Field { // Creates our Parking field, and which functionality wise doesn't do anything
    private GUIController controller;
    public ParkingField(String fieldName) {
        super(fieldName);
        this.controller = controller;
    }

    @Override
    public void Arrived(Player p) {
    controller.showMessage("You found a legendary free parking spot");
    }
}