package fields;

import GUI.GUIController;
import game.Player;
import game.Cup;

public class JailField extends Field { // This class extends the Field class and creates JailSquare.
    private GUIController controller;
    /* kan slettes
    private Dice dice1 = new Dice(6);
    private Dice dice2 = new Dice(6); */
    private Cup cup = new Cup();


    public JailField(String fieldName, GUIController controller) {
        super(fieldName);
        this.controller = controller;
    }

}