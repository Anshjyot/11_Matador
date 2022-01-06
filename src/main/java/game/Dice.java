package game;

public class Dice { // Creates a dice throw method for one dice only
    private int faces;

    public Dice() {
    }

    public void ThrowDice() {
        faces = (int) (Math.random() * 6) + 1;
    }

    public int getFaces() {
        return faces;
    }
}