package controller;

import GUI.GUIController;
import chance.*;
import game.Player;
import java.util.Random;

public class ChanceCardController {
    private ChanceCard[] chanceCards;
    private Player otherPlayer;

    private static ChanceCardController instance;

    public static ChanceCardController getInstance() {
        if (instance == null) {
            instance = new ChanceCardController();
        }
        return instance;
    }
    private ChanceCardController(){
        makeChanceCards();
    }

    GUIController guiInstance = GUIController.getInstance();

    public ChanceCard[] makeChanceCards(){
            chanceCards = new ChanceCard[]{
                    new TypeMoneyCard(-1000, "You have driven over a 'full stop'. Pay a 1000kr fine."),
                    new TypeMoneyCard(-300,"Pay 300kr for a car wash and oil change."),
                    new TypeMoneyCard(-200,"Pay 200kr for 2 crates of beer."),
                    new TypeMoneyCard(-3000, "Pay 3000kr in reparation costs on your vehicle."),
                    new TypeMoneyCard(-3000, "Pay 3000kr in reparation costs on your vehicle."),
                    new TypeMoneyCard(-1000, "You have purchased 4 new wheels for your vehicle, pay 1000kr."),
                    new TypeMoneyCard(-200,"You have received a parking ticket. Pay 200kr"),
                    new TypeMoneyCard(-1000,"Pay 1000kr for your car insurance."),
                    new TypeMoneyCard(-200,"You have bought too much tobacco from abroad. Pay 200kr in import fees."),
                    new TypeMoneyCard(-2000,"Dentist bill, pay 2000kr"),
                    new TypeMoneyCard(500,"Congratulations! You have won in the Lottery! Pick up 500kr!"),
                    new TypeMoneyCard(500,"Congratulations! You have won in the Lottery! Pick up 500kr!"),
                    new TypeMoneyCard(1000,"You have received 1000kr from your stocks dividends!"),
                    new TypeMoneyCard(1000,"You have received 1000kr from your stocks dividends!"),
                    new TypeMoneyCard(1000,"You have received 1000kr from your stocks dividends!"),
                    new TypeMoneyCard(3000,"You receive 3000kr from your communities tax!"),
                    new TypeMoneyCard(1000,"You have a row of 11 in Bingo! You win 1000kr"),
                    new TypeMoneyCard(1000,"Due to inflation, you have gotten a salary increase of 1000kr."),
                    new TypeMoneyCard(1000,"You have picked up a 1000kr Check from the bank"),
                    new TypeMoneyCard(1000,"You have picked up a 1000kr Check from the bank"),
                    new TypeMoneyCard(1000,"You have sold your old furniture at the flee market. Pick up 1000kr"),
                    new TypeMoneyCard(200,"Pick up 200kr from the bank"),

                    new TypeConditionCard(15000,40000,"Your lucky day! Your assets are under 15000! Pick up 40.000kr from the bank!",
                            "Your assets are over 15.000kr. Your doing well enough already."),

                    new TypeMoveCard(3, "Move 3 places forward!"),
                    new TypeMoveCard(-3, "Move 3 places backwards!"),
                    new TypeMoveCard(-3, "Move 3 places backwards!"),

                    new TypeMoveToCard(0, "Move to start"),
                    new TypeMoveToCard(0, "Move to start"),
                    /*
                    new TypePayPlayerCard(200, "Its your Birthday, receive 200kr from every Player."),
                    new TypePayPlayerCard(500, "Payback time! You put money up front for a joint, receive 500kr from every player."),
                    new TypePayPlayerCard(500, "Its your Birthday party! Every player is invited and has to pay you 500kr!")*/
            };
            return chanceCards;
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
            GUIController.getInstance().pressChanceButton();

            ChanceCard topCard = chanceCards[0];
            for (int i = 0; i < chanceCards.length - 1; i++) {
                chanceCards[i] = chanceCards[i + 1];
            }
            chanceCards[chanceCards.length - 1] = topCard;

            if(topCard instanceof TypeMoneyCard){
                TypeMoneyCard card = ((TypeMoneyCard)topCard);
                p.getAccount().setBalance(p.getAccount().getBalance()+card.getCardValue());
                System.out.println(card.getCardValue());
                GUIController.getInstance().showMessage(card.getCardMessage());
            }
            else if (topCard instanceof TypeMoveCard){
                TypeMoveCard card = ((TypeMoveCard)topCard);
                GUIController.getInstance().showMessage(card.getCardMessage());

                GUIController.getInstance().removeCar(p.getPosition(),p.getIndex());

                if(p.getPosition()+card.getCardValue()<0){
                    p.setPosition(40 + p.getPosition()+card.getCardValue());
                }
                else{
                    p.setPosition(p.getPosition()+card.getCardValue());
                    GUIController.getInstance().addCar(p.getPosition(),p.getIndex());}
            }
            else if (topCard instanceof TypeMoveToCard){
                TypeMoveToCard card = ((TypeMoveToCard)topCard);
                GUIController.getInstance().showMessage(card.getCardMessage());

                GUIController.getInstance().removeCar(p.getPosition(),p.getIndex());
                p.setPosition(card.getCardDestination());
                GUIController.getInstance().addCar(p.getPosition(),p.getIndex());

            }

            else if(topCard instanceof TypePayPlayerCard){
                TypePayPlayerCard card = ((TypePayPlayerCard)topCard);
                guiInstance.showMessage(card.getCardMessage());
                System.out.println("Pay player");
                System.out.println(p.getAccount().getBalance());

                int noOtherPlayers = 0;

                for (Player player : MatadorController.getInstance().getPlayers()){
                    if (player == p) {
                    }
                    else {
                        otherPlayer = player;
                        otherPlayer.getAccount().setBalance(otherPlayer.getAccount().getBalance()-card.getCardTotal());
                        noOtherPlayers++;
                    }
                }
                p.getAccount().setBalance(p.getAccount().getBalance()+card.getCardTotal() * noOtherPlayers);
            }
            else if (topCard instanceof TypeConditionCard) {
                TypeConditionCard card = ((TypeConditionCard) topCard);
                if (p.getAccount().getBalance() < 15000){
                    GUIController.getInstance().showMessage(card.getMessage1());
                    p.getAccount().setBalance(p.getAccount().getBalance() + card.getCardValue());
                }
                else {GUIController.getInstance().showMessage(card.getMessage2());
                }
            }
            return topCard;
        }
}
