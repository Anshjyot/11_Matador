package game;

public class Cup { // Our Cup for our dice
    private Dice dice1 = new Dice(6);
    private Dice dice2 = new Dice(6);

    public int CupRoll() {
        dice1.ThrowDice();
        dice2.ThrowDice();
        return dice1.getFaces() + dice2.getFaces();
    }

    public int GetDice1Value() {
        return dice1.getFaces();
    }

    public int GetDice2Value() {
        return dice2.getFaces();

    }
}
