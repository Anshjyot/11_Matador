package fields;

public class FerryField extends Property { // This class extends the Field class

    public FerryField(String fieldname, int price, int rent0, int rent1, int rent2, int rent3,int index) {
        super(fieldname,price,index);
        this.price = price;
        this.rent0 = rent0;
        this.rent1 = rent1;
        this.rent2 = rent0;
        this.rent3 = rent1;
    }

    int price;
    int rent0;
    int rent1;
    int rent2;
    int rent3;

    public int getIndex(){return this.index;}

    @Override
    int getRent() {
        return 0;
    }

    @Override
    int getPrice() {
        return this.price;
    }
}
