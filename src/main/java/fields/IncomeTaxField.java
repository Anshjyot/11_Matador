package fields;

import GUI.GUIController;
import game.Player;

public class IncomeTaxField extends Field { // This class extends the Field class
    int tax;

    public IncomeTaxField(String fieldname, int tax) {
        super(fieldname);
        this.tax = tax;
    }
    public int getTax(){return tax;}
}