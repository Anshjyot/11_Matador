package fields;

import GUI.GUIController;
import game.Player;
import language.Language;

public class VisitJailField extends Field { // Creates our VisitJailSquare field, and which functionality wise doesn't do anything
    private GUIController controller;

    public VisitJailField(String fieldName, GUIController controller) {
        super(fieldName);
        this.controller = controller;
    }

    @Override
    public void Arrived(Player p) {
        if (!p.isInJail) {
            Language.ArrivedVisitJailFieldText(controller);

        }
    }
}