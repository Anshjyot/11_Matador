package fields;


import game.Player;

public abstract class Field { // This class creates the different special types of fields/squares available
    protected String fieldName;

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    public Field() {
    }

    public String getFieldName(){
        return this.fieldName;
    }
}