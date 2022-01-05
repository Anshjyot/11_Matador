package game;


public abstract class Square { // This class creates the different special types of fields/squares available
    protected String fieldName;

    public Square(String fieldName) {
        this.fieldName = fieldName;
    }

    public void Arrived(Player p) {

    }
}