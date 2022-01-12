package chance;

public abstract class ChanceCard {
    protected int cardValue;
    protected String cardMessage;
    protected int cardTimes;
    protected String cardType;

    @Override
    public String toString() {
        return "ChanceCard{" +
                "cardValue=" + cardValue +
                ", cardMessage='" + cardMessage + '\'' +
                ", cardTimes=" + cardTimes +
                ", cardType='" + cardType + '\'' +
                '}';
    }

    public int getCardValue(){return cardValue;}

    public String getCardMessage(){return cardMessage;}

}
