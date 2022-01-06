package fields;

import GUI.GUIController;
import fields.Square;
import game.Player;

import java.util.List;

public class ChanceSquare extends Square { // This class extends the Square class and creates the ChanceCard

    // int outcome;
    private List<Player> players;
    private GUIController controller;

    public ChanceSquare(String fieldName, List<Player> players, GUIController controller){
        super(fieldName);
        this.controller = controller;
        this.players = players;
    }

    @Override
    public void Arrived(Player p) { // Creates different outcomes when landing on the Chance-fields

        super.Arrived(p);
        int cards = (int) (Math.random()*4);
        switch (cards){
            case 0: p.getAccount().setBalance(p.getAccount().getBalance()-2);
                controller.showMessage("You ate to much candy, pay $2 to the bank");
                break;
            case 1: p.getAccount().setBalance(p.getAccount().getBalance()+2);
                controller.showMessage("You have made your homework");
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
            default: System.out.println(cards);
        }


    }

}