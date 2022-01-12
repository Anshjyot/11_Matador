package chance;

public class TypeMoveCard extends ChanceCard{

    public TypeMoveCard(int noFields, String message) {
        this.cardValue = noFields;
        this.cardMessage= message;
    }

    @Override
    public int getCardValue() {
        return super.getCardValue();
    }
    @Override
    public String getCardMessage() {
        return super.getCardMessage();
    }
}
