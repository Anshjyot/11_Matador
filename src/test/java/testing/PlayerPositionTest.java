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
        int expectingResult = 40;
        player.setPosition(40);
        int actualResult = player.getPosition();
        assertEquals(expectingResult, actualResult);
        System.out.println("SetPosition virker korrekt");


    }

}