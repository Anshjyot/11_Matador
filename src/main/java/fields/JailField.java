package fields;

import GUI.GUIController;
import game.DieCup;
import game.Dice;
import game.DieCup;
import game.Player;

public class JailField extends Field { // This class extends the Field class and creates JailSquare.
    private GUIController controller;
    private DieCup dieCup = new DieCup(2);
    private Dice dice = new Dice();

    public JailField(String fieldName, GUIController controller) {
        super(fieldName);
        this.controller = controller;
    }

    @Override
    public void Arrived(Player p) { // This field places the player back to VisitJailSquare field.
        controller.showMessage("JAIL TIME, You have been moved to prison");
        controller.RemoveCar(p.getPosition(), p.getIndex());
        p.setPosition(p.getPosition() - 20);
        controller.AddCar(p.getPosition(), p.getIndex());
        GetOutOfJail(p);

    }

    public void GetOutOfJail(Player player) {
        String option=controller.getOutOfJail();
//The Player can only get out of Jail, if one of three methods has happened
        switch (option) {
            case "Pay 1000$":
                //Pay1000$, check if account>=1000
                if (player.getAccount().getBalance() >= 1000) {
                    player.getAccount().setBalance(player.getAccount().getBalance() - 1000);
                    dieCup.rollDice();
                }

                break;
            case "Roll the Dice":
                //Roll the dice
                if (dice.getEyes() == dice.getEyes())
                    dieCup.rollDice();

                    break;
            default:
                System.out.println(option);
        }
        player.printStatus();
        // if (=3, case "Pay1000$" happens) stay in jail... max=3 rounds
        /*case 3 "Use a Get-Out-Of-Jail Card":
             //check if you have a card, when card is made
            if ()

            break; */
//boolean "yes" or "no" at last - to see if the players has made their choice.
    }
}