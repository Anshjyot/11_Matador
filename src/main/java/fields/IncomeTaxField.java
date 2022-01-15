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
    public void Arrived(Player p) { // Arrived method used on Income TaxField
        Language.IncomeTaxFieldText(controller); // Message sent from the Language class
        p.getAccount().setBalance(p.getAccount().getBalance()-4000);

    }

}