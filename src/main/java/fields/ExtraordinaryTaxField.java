package fields;

import GUI.GUIController;
import game.Player;

public class ExtraordinaryTaxField extends Field { // This class extends the Field class

    public ExtraordinaryTaxField(String fieldname, int tax, GUIController controller) {
        super(fieldname);
        this.tax = tax;
        this.controller = controller;
    }
    int tax;
    GUIController controller;

    @Override
    public void Arrived(Player p) { // This field places the player back to VisitJailSquare field.
        controller.showMessage("Betal Extraordinær-skat");
        p.getAccount().setBalance(p.getAccount().getBalance()-2000);

    }

}