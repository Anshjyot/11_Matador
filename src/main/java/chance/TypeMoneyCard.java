package chance;

public class TypeMoneyCard extends ChanceCard {
    private int cardTotal;

    public TypeMoneyCard(int total, String message) {
        this.cardTotal = total;
        this.cardMessage = message;
    }

    public int getCardTotal() {
        return cardTotal;
    }

    @Override
    public String getCardMessage() {
        return super.getCardMessage();
    }
}