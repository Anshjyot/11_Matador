package chance;

import GUI.GUIController;
import game.Player;

import java.lang.reflect.Array;
import java.util.Random;

public class ChanceCardController {
    private GUIController controller;
    private ChanceCard[] chanceCards;
    private Player[] players; //works when we've made players as an array instead of a list.
    private Player otherPlayer;
    private ChanceDeck chanceDeck = new ChanceDeck();

    public ChanceCardController() {
        this.chanceCards = makeChanceCards();
        System.out.println(chanceCards[1]);
    }


    public ChanceCard[] makeChanceCards() {
            return ChanceDeck.merge(
                    ChanceDeck.createDuplicateTests(new TypeMoveCard(10, "one"), 10),
                    ChanceDeck.createDuplicateTests(new TypeMoneyCard(15, "two"), 5)
            );
    }


        public ChanceCard[] shuffle () {
            Random rand = new Random();
            for (int i = 0; i < chanceCards.length; i++) {
                int randomIndexToSwap = rand.nextInt(chanceCards.length);
                ChanceCard temp = chanceCards[randomIndexToSwap];
                chanceCards[randomIndexToSwap] = chanceCards[i];
                chanceCards[i] = temp;
            }
            return chanceCards;
        }

        public ChanceCard draw (Player p){

            ChanceCard topCard = chanceCards[0];
            for (int i = 0; i < chanceCards.length - 1; i++) {
                chanceCards[i] = chanceCards[i + 1];
            }
            chanceCards[chanceCards.length - 1] = topCard;

            if (topCard instanceof TypeMoneyCard) {
                TypeMoneyCard card = ((TypeMoneyCard) topCard);
                p.getAccount().setBalance(p.getAccount().getBalance() + card.getCardValue());
                System.out.println(card.getCardValue());
                controller.showMessage(card.getCardMessage());
            } else if (topCard instanceof TypeMoveCard) {
                TypeMoveCard card = ((TypeMoveCard) topCard);
                controller.showMessage(card.getCardMessage());

                controller.RemoveCar(p.getPosition(), p.getIndex());
                System.out.println("Spiller rykkes fra " + p.getPosition());
                p.setPosition(p.getPosition() + card.getCardValue());
                controller.AddCar(p.getPosition(), p.getIndex());
                System.out.println(" til " + p.getPosition());
            } else if (topCard instanceof TypeMoveToCard) {
                TypeMoveToCard card = ((TypeMoveToCard) topCard);
                controller.showMessage(card.getCardMessage());

                System.out.println("Spiller rykker til start");
                System.out.println(p.getAccount().getBalance());
                controller.RemoveCar(p.getPosition(), p.getIndex());
                p.setPosition(card.getCardDestination());
                controller.AddCar(p.getPosition(), p.getIndex());
            }
            //will work when players is an array instead of a List.
            else if (topCard instanceof TypePayPlayerCard) {
                TypePayPlayerCard card = ((TypePayPlayerCard) topCard);
                System.out.println("Pay player");
                System.out.println(p.getAccount().getBalance());

                int noOtherPlayers = 0;

                for (Player player : players) {
                    System.out.println("Nuværende spillers balance: " + player.getAccount().getBalance());
                    if (player == p) {
                    } else {
                        otherPlayer = player;
                        noOtherPlayers++;
                    }
                }
                otherPlayer.getAccount().setBalance(otherPlayer.getAccount().getBalance() - card.getCardTotal());
                p.getAccount().setBalance(p.getAccount().getBalance() + card.getCardTotal() * noOtherPlayers);
                //for (Player player : players) {
                //    switch (player) {
                //        case p:
                //    }
                //}
            } else if (topCard instanceof TypeConditionCard) {
                TypeConditionCard card = ((TypeConditionCard) topCard);
                if (p.getAccount().getBalance() < 15000) {
                    controller.showMessage(card.getMessage1());
                    p.getAccount().setBalance(p.getAccount().getBalance() + card.getCardValue());
                } else {
                    controller.showMessage(card.getMessage2());
                }
            }
            return topCard;
        }
}
