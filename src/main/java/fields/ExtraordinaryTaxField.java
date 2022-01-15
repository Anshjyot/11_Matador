package fields;

import GUI.GUIController;
import game.Player;

public class ExtraordinaryTaxField extends Field { // This class extends the Field class
    private int tax;

    public ExtraordinaryTaxField(String fieldname, int tax) {
        super(fieldname);
        this.tax = tax;
    }
    public int getTax(){return tax;}

}