package chance;

public class ChanceDeck {
    static ChanceCard[] createDuplicateCards(int value,String message, int times, String type) {
        ChanceCard[] out = new ChanceCard[times];
        for (int i = 0; i < out.length; i++) {
           // out[i] = new ChanceCard(value, message, type);
        }
        return out;
    }

    static ChanceCard[] merge(ChanceCard[]... tss) {
        int length = 0;
        for (ChanceCard[] ts : tss) {
            length += ts.length;
        }
        ChanceCard[] out = new ChanceCard[length];
        int pos = 0;
        for (ChanceCard[] ts : tss) {
            for (ChanceCard t : ts) {
                out[pos] = t;
                pos++;
            }
        }
        return out;
    }
}