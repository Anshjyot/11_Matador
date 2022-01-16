package fields;

public abstract class Property extends Field{
    int price;
    int owner;
    public String fieldName;
    int index;

    public Property (String fieldName, int price, int index){
        this.fieldName = fieldName;
        this.price = price;
        this.index = index;
        this.owner = 10;
    }

    public abstract int getRent();
    public abstract int getPrice();

    public int getIndex(){return this.index;}
    public int getOwner() {
        return owner;
    }
    public void setOwner(int owner) {
        this.owner = owner;
    }
    public boolean isOwned(){return owner != 10;}
}
