package fields;

import GUI.GUIController;
import game.Player;
import java.util.List;

public class ChanceSquare extends Square { // This class extends the Square class and creates the ChanceCard

    // int outcome;
    private List<Player> players;
    private GUIController controller;

    public ChanceSquare(String fieldName, List<Player> players, GUIController controller) {
        super(fieldName);
        this.controller = controller;
        this.players = players;
    }
    @Override
    public void Arrived(Player p) { // Creates different outcomes when landing on the Chance-fields

        /* System.out.println(Arrays.toString(deck.getDeck()));
        super.Arrived(p);
        int cardNumber = deck.getDeck()[i];
        switch (cardNumber){
            case 1: p.getAccount().setBalance(p.getAccount().getBalance()-300);
                controller.showMessage("Pay for car wash and lubrication. 300 kr");
                break;
            case 2:
                controller.showMessage(".");
                if (p.getAccount().getBalance() < 15000){
                    controller.showMessage("You'll recieve the 'Matador-grant' of 40.000 kr. but only if your values doesn't exceed 15.000 kr.\n" +
                            "And they don't! Here´s 40.000 kr :)");

                    p.getAccount().setBalance(p.getAccount().getBalance()+40000);
                }
                else {
                    controller.showMessage("You'll recieve the 'Matador-grant' of 40.000 kr. but only if your values doesn't exceed 15.000 kr.\n" +
                            "...which they do. You receive nothing.");
                }
                break;
            case 3: p.getAccount().setBalance(p.getAccount().getBalance()+2);
                controller.showMessage("Go to Start");
                controller.RemoveCar(p.getPosition(),p.getIndex());
                p.setPosition(0);
                controller.AddCar(p.getPosition(),p.getIndex());
                break;
            case 4:
                int sum = 0;
                for (Player otherPlayer : players) {
                    if(otherPlayer != p) {
                        sum += 1;
                        otherPlayer.getAccount().setBalance(otherPlayer.getAccount().getBalance()-1);
                    }
                }
                p.getAccount().setBalance(p.getAccount().getBalance() + sum);
                controller.showMessage("Get $1 from every player");
                break;
            default: System.out.println(cardNumber);
        }
        //i + 1 to draw the next card in the deck.
        i++;

        //resets i if its gone over the length of the deck.
        if (i > deck.getDeck().length){
            i = i % deck.getDeck().length;
        }

         */
    }
}