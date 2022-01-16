package fields;

public class BreweryField extends Property { // This class extends the Field class

    public BreweryField(String fieldname, int price, int rent0, int rent1, int index) {
        super(fieldname, price, index);
        this.price = price;
        this.rent0 = rent0;
        this.rent1 = rent1;
    }

    int price;
    int rent0;
    int rent1;

    public int getIndex(){return this.index;}

    @Override
    public int getRent() {
        return rent0;
    }

    @Override
    public int getPrice() {return this.price;}

}


