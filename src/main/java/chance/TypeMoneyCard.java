package chance;

public class TypeMoneyCard extends ChanceCard{
    private int cardTotal;

    public TypeMoneyCard(int iD, int total) {
        super(iD);
        cardTotal = total;
    }

    int getCardTotal(){return cardTotal;}
}
