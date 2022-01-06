package fields;

import GUI.GUIController;
import fields.Square;
import game.Player;

public class JailSquare extends Square { // This class extends the Square class and creates JailSquare.
    private GUIController controller;
    public JailSquare(String fieldName, GUIController controller) {
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