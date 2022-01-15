package fields;

import GUI.GUIController;
import game.Player;
import game.Cup;
import language.Language;

public class JailField extends Field { // This class extends the Field class and creates JailSquare.
    private GUIController controller;
    private Cup cup = new Cup();


    public JailField(String fieldName, GUIController controller) {
        super(fieldName);
        this.controller = controller;
    }

    @Override
    public void Arrived(Player p) { // This field places the player back to VisitJailSquare field.
        Language.ArrivedJailFieldText1(controller);
        p.isInJail = true;
        controller.removeCar(p.getPosition(), p.getIndex());
        p.setPosition(p.getPosition() - 20);
        controller.addCar(p.getPosition(), p.getIndex());
        //GetOutOfJail(p);
    }

    public void GetOutOfJail(Player player) {
        player.roundsInJail++;
        if (player.roundsInJail > 3) {
            //The player should still pay 1000$ - dont know if this feature works totally correct?
            player.getAccount().setBalance(player.getAccount().getBalance() - 1000);
            player.isInJail = false;
            Language.ArrivedJailFieldText2(controller);
            cup.CupRoll();
            controller.askForDice();
            controller.setDice(cup.GetDice1Value(), cup.GetDice2Value());
        } else {
//The Player can only get out of Jail, if one of the three methods has happened
            String option = controller.getOutOfJail();
            switch (option) {
                case "Pay 1000$":
                    //Pay1000$, check if account>=1000
                    if (player.getAccount().getBalance() >= 1000) {
                        player.getAccount().setBalance(player.getAccount().getBalance() - 1000);
                        Language.ArrivedJailFieldText3(controller);
                        player.isInJail = false;
                    }
                    break;
                case "Roll the dice":
                    //Roll the dice, and have a chance to get out of jail for free
                    Language.ArrivedJailFieldText4(controller);
                    cup.CupRoll();
                    controller.askForDice();
                    controller.setDice(cup.GetDice1Value(), cup.GetDice2Value());
                    if (cup.GetDice1Value() == cup.GetDice2Value()) {
                        Language.ArrivedJailFieldText5(controller);
                        player.isInJail = false;

                    }
                    break;
                /*case "Use a Get-Out-Of-Jail Card":
                    if(chancecard==true) {
                        player.isInJail = false;
                    }
                    break;
               /* default:
                    System.out.println(option);
            }
            player.printStatus(); */

            }
        }
    }
}