package fields;

import GUI.GUIController;
import game.Player;

public class StartField extends Field { // Creates our Start field, and which functionality wise doesn't do anything
    private GUIController controller;
    public StartField(String fieldName) {
        super(fieldName);
            this.controller= controller;
    }

    @Override
    public void Arrived(Player p) {
    controller.showMessage("You landed on start, receive 4000$, for staying alive");
    }
}