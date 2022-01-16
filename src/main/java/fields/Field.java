package fields;

public abstract class Field { // This class creates the different special types of fields/squares available
    protected String fieldName;

    // Methods that will be used in the subclasses
    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    public Field() {
    }

    public String getFieldName(){
        return this.fieldName;
    }
}