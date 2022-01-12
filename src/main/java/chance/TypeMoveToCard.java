package chance;

public class TypeMoveToCard extends ChanceCard {
    int cardDestination;

    public TypeMoveToCard(int destination, String message) {
        this.cardMessage = message;
        this.cardDestination = destination;
    }


    public int getCardDestination() {
        return cardDestination;
    }
    @Override
    public String getCardMessage() {
        return super.getCardMessage();
    }
}
