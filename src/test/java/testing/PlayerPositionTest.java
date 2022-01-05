package testing;

import game.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing the setPosition method
 */

public class PlayerPositionTest {

    Player player = new Player();
    @Test
    public void test() {
        int expectingResult = 32;
        player.setPosition(32);
        int actualResult = player.getPosition();
        assertEquals(expectingResult, actualResult);
        System.out.println("SetPosition virker korrekt");


    }

}