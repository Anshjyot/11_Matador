package chance;

public class TypeConditionCard extends ChanceCard{
    protected int total;
    protected String message1;
    protected String message2;

    public TypeConditionCard(int total, String message1, String message2) {
        this.total = total;
        this.message1 = message1;
        this.message2 = message2;
    }

    public String getMessage1() {
        return message1;
    }
    public String getMessage2() {
        return message2;
    }
    public int getTotal() {
        return total;
    }
}
