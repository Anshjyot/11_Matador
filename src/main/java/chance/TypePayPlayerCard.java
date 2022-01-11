package chance;

public class TypePayPlayerCard extends ChanceCard{
    int cardTotal;

    public TypePayPlayerCard(int total, String message) {
        super(total, message);
    }

    public int getCardTotal() {
        return cardTotal;
    }

    @Override
    public String getCardMessage() {
        return super.getCardMessage();
    }
}