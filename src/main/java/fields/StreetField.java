package fields;

import java.awt.*;

public class StreetField extends Property {
    private int noOfHouses = 0;

    public StreetField(String fieldname, int price, int houseprice, int[] rent, Color color, int index) {
        super(fieldname, price,index);
        this.fieldName = fieldname;
        this.price = price;
        this.houseprice = houseprice;
        this.rent = rent;
        this.index = index;
        this.color = color;
    }
    public String fieldName;
    int price;
    int houseprice;
    int[] rent;
    int index;
    Color color;

    public int getNoOfHouses(){return this.noOfHouses;}
    public String getFieldName(){return fieldName;}

    public Color getColor() {
        return color;
    }

    public int getIndex() {
        return index;
    }

    public void addHouse() {
        noOfHouses = noOfHouses+1;
    }

    public int getPrice() {
        return this.price;
    }
    public int getHouseprice(){
        return houseprice;
    }

    @Override
    public int getRent() {
        return rent[noOfHouses];
    }
}
