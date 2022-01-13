package fields;

import GUI.GUIController;
import chance.*;
import game.Player;
import java.util.List;
import java.util.Random;

public class ChanceField extends Field { // This class extends the Square class and creates the ChanceCard

    // int outcome;
    private List<Player> players;
    private GUIController controller;
    private ChanceCard[] chanceCards;
    private Player otherPlayer;

    public ChanceField() {
    }

    public ChanceField(String fieldName, List<Player> players, GUIController controller) {
        super(fieldName);
        this.controller = controller;
        this.players = players;

        chanceCards = new ChanceCard[]{
                new TypeMoneyCard(-1000, "You have driven over a 'full stop'. Pay a 1000kr fine."),
                new TypeMoneyCard(-300,"Pay 300kr for a car wash and oil change."),
                new TypeMoneyCard(-200,"Pay 200kr for 2 boxes of beer."),
                new TypeMoneyCard(-3000, "Pay 3000kr in reperation costs on your viechle."),
                new TypeMoneyCard(-3000, "Pay 3000kr in reperation costs on your viechle."),
                new TypeMoneyCard(-1000, "You have purchased 4 new wheels for your viechle, pay 1000kr."),
                new TypeMoveCard(3,"Ryk tre felter frem"),
                new TypeMoveToCard(0,"Move to START"),
                new TypePayPlayerCard(400,"Receive 400kr from every player")
        };
    }
    @Override
    public void Arrived(Player p) { // Creates different outcomes when landing on the Chance-fields
        draw(p);
    }

    public ChanceCard draw (Player p) {

        ChanceCard topCard = chanceCards[0];
        for (int i = 0; i < chanceCards.length - 1; i++) {
            chanceCards[i] = chanceCards[i + 1];
        }
        chanceCards[chanceCards.length - 1] = topCard;

        if(topCard instanceof TypeMoneyCard){
            TypeMoneyCard card = ((TypeMoneyCard)topCard);
            p.getAccount().setBalance(p.getAccount().getBalance()+card.getCardValue());
            System.out.println(card.getCardValue());
            controller.showMessage(card.getCardMessage());
        }
        else if (topCard instanceof TypeMoveCard){
            TypeMoveCard card = ((TypeMoveCard)topCard);
            controller.showMessage(card.getCardMessage());

            controller.RemoveCar(p.getPosition(),p.getIndex());
            System.out.println("Spiller rykkes fra " + p.getPosition());
            p.setPosition(p.getPosition()+card.getCardValue());
            controller.AddCar(p.getPosition(),p.getIndex());
            System.out.println(" til " + p.getPosition());
        }
        else if (topCard instanceof TypeMoveToCard){
            TypeMoveToCard card = ((TypeMoveToCard)topCard);
            controller.showMessage(card.getCardMessage());

            System.out.println("Spiller rykker til start");
            System.out.println(p.getAccount().getBalance());
            controller.RemoveCar(p.getPosition(),p.getIndex());
            p.setPosition(card.getCardDestination());
            controller.AddCar(p.getPosition(),p.getIndex());
        }
        //Virker ikke..
        else if(topCard instanceof TypePayPlayerCard){
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

        }
        else if (topCard instanceof TypeConditionCard) {
            TypeConditionCard card = ((TypeConditionCard) topCard);
            if (p.getAccount().getBalance() < 15000){
                controller.showMessage(card.getMessage1());
                p.getAccount().setBalance(p.getAccount().getBalance() + card.getCardValue());
            }
            else {controller.showMessage(card.getMessage2());
            }
        }
        return topCard;
    }
}