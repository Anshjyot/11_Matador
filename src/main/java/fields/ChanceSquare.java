package fields;

import GUI.GUIController;
import fields.Square;
import game.CardDeck;
import game.Player;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ChanceSquare extends Square { // This class extends the Square class and creates the ChanceCard

    // int outcome;
    private List<Player> players;
    private GUIController controller;
    CardDeck deck = new CardDeck();
    int i = 0;

    public ChanceSquare(String fieldName, List<Player> players, GUIController controller){
        super(fieldName);
        this.controller = controller;
        this.players = players;
    }

    @Override
    public void Arrived(Player p) { // Creates different outcomes when landing on the Chance-fields

        super.Arrived(p);
        int cardNumber = deck.getDeck()[1];
        switch (cardNumber){
            case 0: p.getAccount().setBalance(p.getAccount().getBalance()-300);
                controller.showMessage("Pay for car wash and lubrication. 300 kr");
                break;
            case 1:
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
            case 2: p.getAccount().setBalance(p.getAccount().getBalance()+2);
                controller.showMessage("Go to Start");
                controller.RemoveCar(p.getPosition(),p.getIndex());
                p.setPosition(0);
                controller.AddCar(p.getPosition(),p.getIndex());
                break;
            case 3:
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
        i++;
    }


}