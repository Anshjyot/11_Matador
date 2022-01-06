package game;

import java.util.Random;
import java.util.stream.IntStream;

public class CardDeck {
    int[] CardDeck = IntStream.range(1, 3).toArray();

    public CardDeck ()
    {
        Random rand = new Random();
        for (int i = 0; i < CardDeck.length; i++) {
            int randomIndexToSwap = rand.nextInt(CardDeck.length);
            int temp = CardDeck[randomIndexToSwap];
            CardDeck[randomIndexToSwap] = CardDeck[i];
            CardDeck[i] = temp;
        }
    }
    public int[] getDeck(){
        return CardDeck;
    }
}
