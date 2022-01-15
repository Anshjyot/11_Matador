package fields;

import GUI.GUIController;
import game.Player;
import language.Language;

public class ParkingField extends Field { // Creates our Parking field, and which functionality wise doesn't do anything
    private GUIController controller;
    public ParkingField(String fieldName, GUIController controller) {
        super(fieldName);
        this.controller = controller;
    }

    @Override
    public void Arrived(Player p) {
        Language.ArrivedParkingFieldText(controller);
    }
}