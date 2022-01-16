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

    /*public static void ArrivedBreweryText1(String fieldName, int price, Player player, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " bought " + fieldName + " for " + price + " dkk. You gotta have a drink sometimes");
    }

    public static void ArrivedBreweryText2(String fieldName, int rent0, Player player, Player owner, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + rent0 + " dkk ");
    }

    public static void ChanceFieldDrawText(GUIController controller) {
        controller.showMessage("You landed on Chance! Draw a chance card.");
    }
   */
    public static void ExtraordinaryTaxFieldText(GUIController controller) {
        controller.showMessage("Pay the extraordinary-tax of 2000DKK");
    }

 /*
    public static void ArrivedFerryFieldText1(String fieldName, int price, Player player, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " bought " + fieldName + " for " + price + " dkk. Are you planning on sailing anywhere soon?");
    }

    public static void ArrivedFerryFieldText2(String fieldName, int rent0, Player player, Player owner, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + rent0 + " dkk ");
    }
 */
    public static void IncomeTaxFieldText(GUIController controller) {
        controller.showMessage("Pay the income-tax of 4000DKK");
    }

    public static void ArrivedJailFieldText1(GUIController controller) {
        controller.showMessage("JAIL TIME! You have been moved to jail.");
    }

    public static void ArrivedJailFieldText2(GUIController controller) {
        controller.showMessage("You have been in jail for 3 rounds, pay 1000DKK and get out of here!");
    }

    public static void ArrivedJailFieldText3(GUIController controller) {
        controller.showMessage("You paid yourself out of jail");
    }

    public static void ArrivedJailFieldText4(GUIController controller) {
        controller.showMessage("Roll the dice, and have a chance to get out of jail for free");
    }

    public static void ArrivedJailFieldText5(GUIController controller) {
        controller.showMessage("You got lucky, you got a pair and get an extra throw");
    }

    public static void ArrivedVisitJailFieldText(GUIController controller) {
        controller.showMessage("Welcome to prison, say hi to your inmates. Relax, You're just on a visit");
    }

    public static void ArrivedOwnedPropertyText(Property property, Player player, Player owner, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + property.fieldName + " for " + property.getRent() + " dkk ");
        //controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + rent[house] + " dkk ");
    }

    public static void BuyDeedOwnedPropertyText(Property property, Player player, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " bought " + property.fieldName + " for " + property.getPrice() + " dkk ");
    }

    public static void ArrivedParkingFieldText(GUIController controller) {
        controller.showMessage("You found a legendary free parking spot");
    }

    public static void ArrivedStartFieldText(GUIController controller) {
        controller.showMessage("You landed on start, receive 4000DKK, for staying alive");
    }

    public static void AlreadyBought(GUIController controller) {
        controller.showMessage("Oh, you've already bought this property... How nice it is :)");
    }

    public static void addHouseText() {
        showMessage("You can't build a house here yet :(  " + " Collect all the deeds for the same colored streets to buy houses.");
    }

    public static void buyHouseText() {
        showMessage("You already have four houses, maybe a hotel?");
    }

    public static void showMessage(String message) {
        gui.displayChanceCard(message);
    }
}


