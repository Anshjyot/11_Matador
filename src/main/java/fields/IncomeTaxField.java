package fields;

import GUI.GUIController;
import game.Player;

public class IncomeTaxField extends Field { // This class extends the Field class

    public IncomeTaxField(String fieldname, int tax) {
        super(fieldname);
        this.tax = tax;
        this.controller = controller;
    }
    int tax;
    GUIController controller;

    public void Arrived(Player p) {
        controller.showMessage("Betal Indkomst-skatten på 4000$");
        p.getAccount().setBalance(p.getAccount().getBalance()-4000);

    }

}