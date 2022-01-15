package game;

public class Dice { // Creates a dice throw method for a die
    private int faces;
    private int numOfSides;

    public Dice(int numberOfSides)
    {
        numOfSides = numberOfSides;

        faces = (int)(Math.random()*numOfSides) + 1;

    }
    public void ThrowDice() {
        faces = (int) (Math.random() * numOfSides) + 1;
    }

    public int getFaces() {
        return faces;
    }
}