package fields;

import GUI.GUIController;
import game.Player;

public class IncomeTaxSquare extends Square { // This class extends the Square class

    public IncomeTaxSquare(String fieldname, int tax, GUIController controller) {
        super(fieldname);
        this.tax = tax;
        this.controller = controller;
    }
    int tax;
    GUIController controller;

    @Override
    public void Arrived(Player p) { // This field places the player back to VisitJailSquare field.
        controller.showMessage("Betal Indkomst-skat");
        p.getAccount().setBalance(p.getAccount().getBalance()-4000);

    }

}