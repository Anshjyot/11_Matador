
package controller;

import GUI.GUIController;
import game.Board;


import game.Player;
import gui_fields.GUI_Field;
import gui_main.GUI;

import java.util.*;
import java.util.List;

public class MatadorController {

    private final int StartField = 0;
    private GUIController guiController = new GUIController();
    private final int STARTBALANCE = 30000;
    private boolean noWinner = true;
    Player[] players;
    String[] playerNames;
    Player currentPlayer;
    Board board;
    protected int[] ages = new int[0];
    protected String[] names = new String[0];
    protected GUI gui;
    private final int Everyfield = 40;
    private GUI_Field[] fields;


    public void playGame() { // These methods below are essential for the game to run, thus Main will run playGame()
        board = new Board(players, guiController);
        this.guiController.initializeBoard(board);
        NumberOfPlayers();
        try {
            gameLoop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void gameLoop() throws InterruptedException {
        while (noWinner) {
            for (int i = 0; i < players.length; i++) {
                int faceValue = guiController.setDice();
                currentPlayer = players[i];
                guiController.RemoveCar(currentPlayer.getPosition(), i);

                if (currentPlayer.getPosition() + faceValue > 39) { // When you exceed the last field, you get to a new round
                    StartField(i);
                    currentPlayer.setPosition(currentPlayer.getPosition() + faceValue - 40);

                } else {
                    currentPlayer.setPosition(currentPlayer.getPosition() + faceValue);
                }

                // guiController.addHouse();
                // guiController.WannaBuy();
                if(currentPlayer.getPosition()-faceValue > 0){
                    guiController.AddCar(currentPlayer.getPosition()-faceValue, i);
                }else{
                    guiController.AddCar(currentPlayer.getPosition(), i);
                }
                for(int j = 1; j <= faceValue; j++) {
                    System.out.println(j);
                    int newPos = (currentPlayer.getPosition()-faceValue)+j;
                    guiController.AddCar(newPos, i);
                    Thread.sleep(100);
                    guiController.RemoveCar(newPos-1, i);
                }
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

        if (players[player].getAccount().getBalance() < 0) {
            for (int i = 0; i < players.length; i++) {
                if (currentPlayer.getAccount().getBalance() > loserBalance) {
                    winnerName.add(currentPlayer.getPlayerName());

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

        players = new Player[playerList];
        playerNames = new String[playerList];

        for (int i = 0; i < playerList; i++) {

            //Indtast navn
            String name = guiController.getPlayerName(i);
            int age = 0;
            boolean ageIsInt;
            do {
                try {
                    //indtast alder
                    age = guiController.getPlayerAge(i);
                    ageIsInt = age >= 10 && age <= 150;
                } catch (NumberFormatException e) {
                    ageIsInt = false;
                }
            } while (!ageIsInt);
            players[i] = new Player(name,age, STARTBALANCE,StartField,i);
            //ages[i] = age;
            //players.add(new Player(name, age, startBalance, StartField, i));
        }

        guiController.addPlayers(players); // Adds players to the GUI

    }

    private void FieldOutcome(int i) { // The field outcome method
        board.getSquare(currentPlayer.getPosition()).Arrived(currentPlayer);

    }

    private void StartField(int i) { // You get 4.000 dkk when you pass the Start-field
        currentPlayer.getAccount().setBalance(currentPlayer.getAccount().getBalance() + 4000);
    }

}