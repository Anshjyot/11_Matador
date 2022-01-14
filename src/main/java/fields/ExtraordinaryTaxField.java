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
    public void Arrived(Player p) {
        controller.showMessage("Betal Extraordinær-skat på 2000$");
        p.getAccount().setBalance(p.getAccount().getBalance()-2000);

    }

}