package game;

import java.util.Random;
import java.util.stream.IntStream;

public class CardDeck {
    public CardDeck() {
    }

    int[] cardDeck = IntStream.range(1, 5).toArray();
    int[] shuffledDeck;

    private int[] shuffleDeck() {
        Random rand = new Random();
        for(int i = 0; i<5;i++) {
            int randomIndexToSwap = rand.nextInt(cardDeck.length);
            int temp = cardDeck[randomIndexToSwap];
            cardDeck[randomIndexToSwap] = cardDeck[i];
            cardDeck[i] = temp;
        }
        shuffledDeck = cardDeck;
        return shuffledDeck;
}
    public void shuffle(){
        for (int i=0; i<30000; i++ ){
            int a = (int) (Math.random()*cardDeck.length);
            int b = (int) (Math.random()*cardDeck.length);
        }
    }
    public int[] getDeck () {
       return shuffledDeck;
    }
}
