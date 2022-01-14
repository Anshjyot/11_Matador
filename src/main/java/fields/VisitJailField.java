package fields;

import GUI.GUIController;
import game.Player;

public class VisitJailField extends Field { // Creates our VisitJailSquare field, and which functionality wise doesn't do anything
    private GUIController controller;
    public VisitJailField(String fieldName, GUIController controller) {
        super(fieldName);
        this.controller= controller;
    }

    @Override
    public void Arrived(Player p) {
        if(!p.isInJail){
        controller.showMessage("Welcome to prison, say hi to your inmates. Relax, You're just on a visit");}

    }
}