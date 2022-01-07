package fields;


import game.Player;

public abstract class Square { // This class creates the different special types of fields/squares available
    protected String fieldName;

    public Square(String fieldName) {
        this.fieldName = fieldName;
    }

    public Square() {
    }

    public void Arrived(Player p) {

    }
}