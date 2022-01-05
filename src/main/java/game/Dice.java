package game;

public class Dice { // Creates a dice throw method for one dice only
    private int dice;

    public Dice() {
    }

    public void ThrowDice() {
        dice = (int) (Math.random() * 6) + 1;
    }

    public int getDice() {
        return dice;
    }
}