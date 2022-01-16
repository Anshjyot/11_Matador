package language;

import GUI.GUIController;
import fields.Property;
import game.Player;
import gui_main.GUI;

import java.util.Scanner;

public class Language {
    static int house;
    static GUI gui;
    static Scanner sc = new Scanner(System.in);

    public static void turnStartText(Player player){
        GUIController.getInstance().showMessage("It's " + player.getPlayerName() + "'s turn.");
    }

    public static void ExtraordinaryTaxFieldText() {
        GUIController.getInstance().showMessage("Pay the extraordinary-tax of 2000DKK");
    }

    public static void IncomeTaxFieldText() {
        GUIController.getInstance().showMessage("Pay the income-tax of 4000DKK");
    }

    public static void ArrivedJailFieldText1() {
        GUIController.getInstance().showMessage("JAIL TIME! You have been moved to jail.");
    }

    public static void ArrivedJailFieldText2() {
        GUIController.getInstance().showMessage("You have been in jail for 3 rounds, pay 1000DKK and get out of here!");
    }

    public static void ArrivedJailFieldText3() {
        GUIController.getInstance().showMessage("You paid yourself out of jail");
    }

    public static void ArrivedJailFieldText4() {
        GUIController.getInstance().showMessage("Roll the dice, and have a chance to get out of jail for free");
    }

    public static void ArrivedJailFieldText5() {
        GUIController.getInstance().showMessage("You got lucky, you got a pair and get an extra throw");
    }

    public static void ArrivedVisitJailFieldText() {
        GUIController.getInstance().showMessage("Welcome to prison, say hi to your inmates. Relax, You're just on a visit");
    }

    public static void ArrivedText(Property property, Player player, Player owner) {
        GUIController.getInstance().showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + property.fieldName + " for " + property.getRent() + " dkk ");
    }

    public static void BuyDeedText(Property property, Player player) {
        GUIController.getInstance().showMessage(player.getPlayerName() + " bought " + property.fieldName + " for " + property.getPrice() + " dkk ");
    }

    public static void ArrivedParkingFieldText() {
        GUIController.getInstance().showMessage("You found a legendary free parking spot");
    }

    public static void ArrivedStartFieldText() {
        GUIController.getInstance().showMessage("You landed on start, receive 4000DKK, for staying alive");
    }

    public static void AlreadyBought() {
        GUIController.getInstance().showMessage("Oh, you've already bought this property... How nice it is :)");
    }

    public static void addHouseText() {
        GUIController.getInstance().showMessage("You can't build a house here yet :(\n\n" + "Collect all the deeds for the same colored streets to buy houses.");
    }

    public static void buyHouseText() {
        GUIController.getInstance().showMessage("You already have four houses, maybe a hotel?");
    }

}


