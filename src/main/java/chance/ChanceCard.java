package chance;

public abstract class ChanceCard {
    protected int cardValue;
    protected String cardMessage;
    protected int cardTimes;
    protected String cardType;


    public int getCardValue(){return cardValue;}

    public String getCardMessage(){return cardMessage;}

    public int getCardTimes(){return cardTimes;}

    public String getCardType(){return cardType;}
}
