package testing;

import game.Cup;
import static org.junit.Assert.*;
import org.junit.Test;

public class CupTest {

    /**
     * Testing the CupRoll method in our Cup-class
     */
    @Test
    public void CupRollTest() {
        Cup cup = new Cup();
        int result =  cup.CupRoll();
        if (result > 12 || result < 2) {
            fail("The dice has not been limited");
        }
    }

    /**
     * Testing the GetDice1Value method in our Cup-class
     */
    @Test
    public void testGetD1Result() {
        Cup cup = new Cup();
        cup.CupRoll();
        int result = cup.GetDice1Value();
        if(result > 6 || result < 1){
            fail("The die has not been limited to 6 sides");
        }
    }

    /**
     * Testing the GetDice2Value method in our Cup-class
     */
    @Test
    public void testGetD2Result() {
        Cup cup = new Cup();
        cup.CupRoll();
        int result = cup.GetDice2Value();
        if(result > 6 || result < 1){
            fail("The die has not been limited to 6 sides");
        }
    }

}
