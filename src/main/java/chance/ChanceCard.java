package chance;

public abstract class ChanceCard {
    private int cardValue;
    private String cardMessage;

    ChanceCard(int value,String message) {
        this.cardValue = value;
        this.cardMessage = message;}

    //Getters for ChanceCard
    public int getCardValue(){return cardValue;}

    public String getCardMessage(){return cardMessage;}
}
