package fields;

import GUI.GUIController;
import game.Player;

public class JailField extends Field { // This class extends the Field class and creates JailSquare.
    private GUIController controller;
    public JailField(String fieldName, GUIController controller) {
        super(fieldName);
        this.controller = controller;
    }

    @Override
    public void Arrived(Player p) { // This field places the player back to VisitJailSquare field.
        controller.showMessage("JAIL TIME");
        controller.RemoveCar(p.getPosition(), p.getIndex());
        p.setPosition(p.getPosition() - 16);
        controller.AddCar(p.getPosition(), p.getIndex());
    }


}