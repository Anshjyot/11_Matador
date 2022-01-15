package fields;

import GUI.GUIController;
import game.Player;
import language.Language;

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
        Language.ExtraordinaryTaxFieldText(controller);
        p.getAccount().setBalance(p.getAccount().getBalance()-2000);

    }

}