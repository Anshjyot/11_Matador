
package controller;

import GUI.GUIController;
import fields.Field;
import game.Board;


import game.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MatadorController {

    private final int StartField = 0;
    private GUIController guiController = new GUIController();
    private int startBalance;
    private boolean noWinner = true;
    List<Player> players = new ArrayList<>();
    Board board;
    protected int[] ages = new int [0];
    protected String[] names = new String[0];
    protected GUI gui;
    private final int Everyfield = 40;
    protected GUI_Field[] fields;



    public void playGame() { // These methods below are essential for the game to run, thus Main will run playGame()
        board = new Board(players, guiController);
        this.guiController.initializeBoard(board);
        NumberOfPlayers();
        gameLoop();
    }


    private void gameLoop() {
        fields = new GUI_Street[Everyfield];
        for (int i = 0; i < Everyfield; i++) {
            fields[i] = new GUI_Street();
        }
        while (noWinner) {
            for (int i = 0; i < players.size(); i++) {
                    int faceValue = guiController.setDice();

                    guiController.RemoveCar(players.get(i).getPosition(), i);

                    if (players.get(i).getPosition() + faceValue > 39) { // When you exceed the last field, you get to a new round

                        StartField(i);
                        players.get(i).setPosition(players.get(i).getPosition() + faceValue - 40);

                    } else {
                        players.get(i).setPosition(players.get(i).getPosition() + faceValue);
                    }

                    guiController.AddCar(players.get(i).getPosition(), i);
                    FieldOutcome(i); // The field outcome for the specific field

                    for (Player player : players) {
                        guiController.setNewBalance(player.getIndex(), player.getAccount().getBalance());
                    }
                    Winner(i); // Checking if the winner is found.
                }

            }
        }


    private void Winner(int player) { // The last person to have a balance >0 wins
        int loserBalance = 0;
        List<String> winnerName = new ArrayList<String>();

        if (players.get(player).getAccount().getBalance() < 0) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getAccount().getBalance() > loserBalance) {
                    winnerName.add(players.get(i).getPlayerName());

                }
            }

            if (winnerName.size() == 1) {
                guiController.getWinnerMessage(winnerName);
                System.exit(0); // Games finishes when the winner is announced
            }

        }
    }

    private void NumberOfPlayers() { // Start money declaration
        int playerList = guiController.getPlayerList();

        if (playerList == 3) {
            startBalance = 30000;
        }
        if (playerList == 4) {
            startBalance = 30000;
        }
        if (playerList == 5) {
            startBalance = 30000;
        }
        if (playerList == 6) {
            startBalance = 30000;
        }


        for (int i = 0; i < playerList; i++) {
            String[] temporayName = new String[names.length + 1];
            int[] temporaryAge = new int[ages.length+1];
            for (int j = 0; j < names.length; j++) {
                temporayName[j]=names[j];
                temporaryAge[j]=ages[j];
            }
            names = temporayName;
            ages = temporaryAge;
            String name = guiController.getPlayerName(i);
            int age = 0;
            boolean ageIsInt;
            do {
                try {
                    age = guiController.getPlayerAge(i);
                    ageIsInt = age >= 10 && age <= 150;
                } catch (NumberFormatException e) {
                    ageIsInt = false;
                }
            } while (!ageIsInt);

            ages[i] = age;
            players.add(new Player(name, age, startBalance, StartField, i));
        }

        guiController.addPlayers(players); // Adds players to the GUI

    }

    private void FieldOutcome(int i) { // The field outcome method
        board.getSquare(players.get(i).getPosition()).Arrived(players.get(i));

    }

    private void StartField(int i) { // You get 4.000 dkk when you pass the Start-field
        players.get(i).getAccount().setBalance(players.get(i).getAccount().getBalance() + 4000);
    }

}