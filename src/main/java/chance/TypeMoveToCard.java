package chance;

public class TypeMoveToCard extends ChanceCard {
    int cardDestination;

    public TypeMoveToCard(int destination, String message) {
        super(destination, message);
        cardDestination = destination;
    }

    //Getters for TypeMoveToCard

    public int getCardDestination() {
        return cardDestination;
    }
    @Override
    public String getCardMessage() {
        return super.getCardMessage();
    }
}
