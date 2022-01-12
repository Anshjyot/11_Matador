package chance;
import java.util.Arrays;

public class ChanceDeck {
    static ChanceCard[] createDuplicateTests(ChanceCard test, int times) {
        ChanceCard[] out = new ChanceCard[times];
        Arrays.fill(out, test);
        return out;
    }
    private ChanceCard[] chanceCards;

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

