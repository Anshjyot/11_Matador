package game;

public class Cup {
    private Dice dice1 = new Dice(6);
    private Dice dice2 = new Dice(6);

    public int Cup() {
        dice1.ThrowDice();
        dice2.ThrowDice();
        return dice1.getFaces() + dice2.getFaces();
    }
}
