package fields;

import GUI.GUIController;
import game.Player;
import language.Language;

public class StartField extends Field { // Creates our Start field, and which functionality wise doesn't do anything
    private GUIController controller;
    public StartField(String fieldName, GUIController controller) {
        super(fieldName);
            this.controller= controller;
    }

    @Override
    public void Arrived(Player p) {
        Language.ArrivedStartFieldText(controller);
    }
}