package fields;

import GUI.GUIController;
import game.Player;

public class IncomeTaxField extends Field { // This class extends the Field class

    public IncomeTaxField(String fieldname, int tax, GUIController controller) {
        super(fieldname);
        this.tax = tax;
        this.controller = controller;
    }
    int tax;
    GUIController controller;

    @Override
    public void Arrived(Player p) {
        controller.showMessage("Betal Indkomst-skatten på 4000$");
        p.getAccount().setBalance(p.getAccount().getBalance()-4000);

    }

}