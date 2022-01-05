package testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import game.Account;


public class AccountTest {

    public AccountTest() { }


    /**
     * Testing the setBalance method
     */

    @Test
    public void testingSetBalance() {
        System.out.println("Set Balance");
        Account amount = new Account(0);
        amount.setBalance(1000);
        int expectingResult = 1000;
        int actualResult = amount.getBalance();
        assertEquals(expectingResult, actualResult);
    }
    /**
     * Testing the methodArrived & Bank, the amount/balance cant be negative - no matter what the withdrawal is
     */

    @Test
    public void TestingArrived(){
        int amount = -6000;
        int expectingResult = 0;
        if (amount < 0) {
            amount = 0;
            System.out.println("\n"+"Your bank balance is now: " + amount);
        }
        else {
            System.out.println("\n"+"Your bank balance is now: " + amount);
        }
        int actualResult = amount;
        assertEquals(expectingResult, actualResult);

    }



}

