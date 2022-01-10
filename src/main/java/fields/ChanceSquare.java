package fields;

import GUI.GUIController;
import chance.*;
import game.Player;

import javax.lang.model.element.TypeParameterElement;
import java.util.List;
import java.util.Random;

public class ChanceSquare extends Square { // This class extends the Square class and creates the ChanceCard

    // int outcome;
    private List<Player> players;
    private GUIController controller;
    private ChanceCard[] chanceCards;
    private Player otherPlayers;

    public ChanceSquare(String fieldName, List<Player> players, GUIController controller){
        super(fieldName);
        this.controller = controller;
        this.players = players;
        chanceCards = new ChanceCard[]{
                new TypeMoneyCard(-300,"Pay for a car wash and oil. 300 kr"),
                new TypeMoneyCard(6,"en eller anden besked"),
                new TypeMoveCard(3,"Ryk tre felter frem"),
                new TypeMoveToCard(0,"Move to START"),
                new TypePayPlayerCard(400,"Receive 400kr from every player")
        };
        shuffle();

    }
    public ChanceCard[] shuffle (){
        Random rand = new Random();
        for(int i = 0; i<chanceCards.length;i++) {
        int randomIndexToSwap = rand.nextInt(chanceCards.length);
        ChanceCard temp = chanceCards[randomIndexToSwap];
        chanceCards[randomIndexToSwap] = chanceCards[i];
        chanceCards[i] = temp;}
        return chanceCards;
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
            System.out.println("Spiller rykker til start");
            System.out.println(p.getAccount().getBalance());
            controller.RemoveCar(p.getPosition(),p.getIndex());
            p.setPosition(card.getCardDestination());
            controller.AddCar(p.getPosition(),p.getIndex());
        }
        //this does not work. Will be fixed monday.
        else if(topCard instanceof TypePayPlayerCard){
            TypePayPlayerCard card = ((TypePayPlayerCard)topCard);
            System.out.println("Pay player");
            System.out.println(p.getAccount().getBalance());
            for (Player player : players){
                if (player == p) {
                    continue;
                }
                else {
                    otherPlayers = player;
                }
            }
            otherPlayers.getAccount().setBalance(otherPlayers.getAccount().getBalance()-card.getCardTotal());
            p.getAccount().setBalance(p.getAccount().getBalance()+card.getCardTotal());
        }
        return topCard;
    }

    @Override
    public void Arrived(Player p) { // Creates different outcomes when landing on the Chance-fields
        draw(p);

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