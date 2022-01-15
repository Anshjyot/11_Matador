package language;

import GUI.GUIController;
import fields.FieldController;
import game.Player;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class Language {
    private static final String[] _languages = new String[]{"English", "Dansk"};
    static int house;

    static Scanner sc = new Scanner(System.in);


    public static void ArrivedBreweryText1(String fieldName, int price, Player player, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " bought " + fieldName + " for " + price + " dkk ");
    }

    public static void ArrivedBreweryText2(String fieldName, int rent0, Player player, Player owner, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + rent0 + " dkk ");
    }

    public static void ChanceFieldDrawText(GUIController controller) {
        controller.showMessage("You landed on Chance! Draw a chance card.");
    }

    public static void ExtraordinaryTaxFieldText(GUIController controller) {
        controller.showMessage("Betal Extraordinær-skat på 2000$");
    }

    public static void ArrivedFerryFieldText1(String fieldName, int price, Player player, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " bought " + fieldName + " for " + price + " dkk ");
    }

    public static void ArrivedFerryFieldText2(String fieldName, int rent0, Player player, Player owner, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + rent0 + " dkk ");
    }

    public static void IncomeTaxFieldText(GUIController controller) {
        controller.showMessage("Betal Indkomst-skatten på 4000$");
    }

    public static void ArrivedJailFieldText1(GUIController controller) {
        controller.showMessage("JAIL TIME! You have been moved to jail.");
    }

    public static void ArrivedJailFieldText2(GUIController controller) {
        controller.showMessage("You have been in jail for 3 rounds, pay 1000kr and get out of here!");
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

    public static void ArrivedOwnedPropertyText(String fieldName, int[] rent, Player player, Player owner, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + fieldName + " for " + rent[house] + " dkk ");
    }

    public static void BuyDeedOwnedPropertyText(String fieldName, int price, Player player, GUIController controller) {
        controller.showMessage(player.getPlayerName() + " bought " + fieldName + " for " + price + " dkk ");
    }

    public static void ArrivedParkingFieldText(GUIController controller) {
        controller.showMessage("You found a legendary free parking spot");
    }

    public static void ArrivedStartFieldText(GUIController controller) {
        controller.showMessage("You landed on start, receive 4000$, for staying alive");
    }



}


