package fields;

import GUI.GUIController;
import game.Player;
import language.Language;

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
        Language.IncomeTaxFieldText(controller);
        p.getAccount().setBalance(p.getAccount().getBalance()-4000);

    }

}