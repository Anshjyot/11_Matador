package fields;

import GUI.GUIController;
import game.Dice;
import game.Player;
import game.Cup;

public class JailField extends Field { // This class extends the Field class and creates JailSquare.
    private GUIController controller;
    /* kan slettes
    private Dice dice1 = new Dice(6);
    private Dice dice2 = new Dice(6); */
    private Cup cup = new Cup();


    public JailField(String fieldName, GUIController controller) {
        super(fieldName);
        this.controller = controller;
    }

    @Override
    public void Arrived(Player p) { // This field places the player back to VisitJailSquare field.
        controller.showMessage("JAIL TIME");
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
                    cup.CupRoll();
                    // The player in jail should roll again... Make a method InJail..
                }

                break;
            case "Roll the Dice":

               // controller.setDice();
                //Roll the dice, and have a chance to get out of jail for free
                if (cup.GetDice1Value() == cup.GetDice2Value())
                {
                    System.out.println("You got a pair, you get an extra throw");
                    cup.CupRoll();
                    //else if (controller.dice1 != controller.dice2)

                    break;}
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