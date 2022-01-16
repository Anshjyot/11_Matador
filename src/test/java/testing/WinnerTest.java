package testing;

import game.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerTest {
    List<String> winnerName = new ArrayList<>();

    @Test
    public void winner(){
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        player1.getAccount().setBalance(-400);
        player2.getAccount().setBalance(-100);
        player3.getAccount().setBalance(800);
        int loserBalance = 0;

        if (player1.getAccount().getBalance() > loserBalance) {
            winnerName.add(player1.getPlayerName());
        }

        if (player2.getAccount().getBalance() > loserBalance) {
            winnerName.add(player2.getPlayerName());
        }

        if (player3.getAccount().getBalance() > loserBalance) {
            winnerName.add(player3.getPlayerName());
        }

        if (winnerName.size() == 1) {
            System.out.println(winnerName);
            System.exit(0); // Games finishes when the winner is announced
        }

        List<String> expectingResult = (List<String>) player3;
        List<String> actualResult = winnerName;
        System.out.println(winnerName);

        assertEquals(expectingResult, actualResult);
    }
}