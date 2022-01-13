package chance;

public class TypeConditionCard extends ChanceCard{
    protected int total;
    protected int receive;
    protected String message1, message2;

    public TypeConditionCard(int total, int receive, String message1, String message2) {
        super(total,message1);
        this.receive = receive;
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

    public int getCardValue() {
        return receive;
    }

}
