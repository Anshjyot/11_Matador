package fields;

import GUI.GUIController;
import chance.*;
import game.Player;
import java.util.List;
import java.util.Random;

public class ChanceField extends Field { // This class extends the Square class and creates the ChanceCard

    // int outcome;
    private Player[] players;
    private GUIController controller;
    private ChanceCard[] chanceCards;
    private Player otherPlayer;
    Random rand = new Random();

    public ChanceField(String fieldName, Player[] players, GUIController controller) {
        super(fieldName);
        this.controller = controller;
        this.players = players;



    }
    @Override
    public void Arrived(Player p) { // Creates different outcomes when landing on the Chance-fields
        draw(p);
    }

    public void draw (Player p) {
        shuffle();
        controller.showMessage("You landed on Chance! Draw a chance card.");
        controller.pressChanceButton();

        ChanceCard topCard = chanceCards[0];
        for (int i = 0; i < chanceCards.length - 1; i++) {
            chanceCards[i] = chanceCards[i + 1];
        }
        chanceCards[chanceCards.length - 1] = topCard;

        if(topCard instanceof TypeMoneyCard){
            TypeMoneyCard card = ((TypeMoneyCard)topCard);
            p.getAccount().setBalance(p.getAccount().getBalance()+card.getCardValue());
            controller.showMessage(card.getCardMessage());
        }
        else if (topCard instanceof TypeMoveCard){
            TypeMoveCard card = ((TypeMoveCard)topCard);
            controller.showMessage(card.getCardMessage());

            //moves car one step at a time.

            controller.removeCar(p.getPosition(),p.getIndex());
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.setPosition(p.getPosition()+card.getCardValue());
            controller.addCar(p.getPosition(),p.getIndex());

        }
        else if (topCard instanceof TypeMoveToCard){
            TypeMoveToCard card = ((TypeMoveToCard)topCard);
            controller.showMessage(card.getCardMessage());

            controller.removeCar(p.getPosition(),p.getIndex());
            p.setPosition(card.getCardDestination());
            controller.addCar(p.getPosition(),p.getIndex());
        }
        //Virker ikke..
        /* else if(topCard instanceof TypePayPlayerCard){
            TypePayPlayerCard card = ((TypePayPlayerCard)topCard);
            controller.showMessage(card.getCardMessage());
            System.out.println("Pay player");
            System.out.println(p.getAccount().getBalance());

            int noOtherPlayers = 0;

            for (Player player : players){
                System.out.println("Nuværende spillers balance: " + player.getAccount().getBalance());
                if (player != p) {
                    System.out.println("Anden spillers balance: " + player.getAccount().getBalance());
                    noOtherPlayers++;
                    player.getAccount().setBalance(player.getAccount().getBalance()-card.getCardTotal());
                    System.out.println("Balance efter: " + player.getAccount().getBalance());
                }
                p.getAccount().setBalance(p.getAccount().getBalance() + card.getCardTotal() * noOtherPlayers);
            }
        } */
        else if (topCard instanceof TypeConditionCard) {
            TypeConditionCard card = ((TypeConditionCard) topCard);
            if (p.getAccount().getBalance() < card.getTotal()){
                controller.showMessage(card.getMessage1());
                p.getAccount().setBalance(p.getAccount().getBalance() + card.getCardValue());
            }
            else {controller.showMessage(card.getMessage2());
            }
        }
    }
    public void shuffle (){
        for(int i = 0; i<chanceCards.length;i++) {
            int randomIndexToSwap = rand.nextInt(chanceCards.length);
            ChanceCard temp = chanceCards[randomIndexToSwap];
            chanceCards[randomIndexToSwap] = chanceCards[i];
            chanceCards[i] = temp;}
    }
}