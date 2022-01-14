
package controller;

import GUI.GUIController;
import fields.Field;
import fields.FieldController;
import fields.JailField;
import fields.OwnedProperty;
import game.Cup;
import game.Player;
import gui_main.GUI;
import java.util.*;
import java.util.List;

public class MatadorController {

    private final int StartField = 0;
    private GUIController guiController = new GUIController();
    private final int STARTBALANCE = 30000;
    private boolean noWinner = true;
    Player players[];
    Player currentPlayer;
    FieldController board;
    protected int[] ages = new int[0];
    protected String[] names = new String[0];
    protected GUI gui;
    private Player player;
    private Cup cup = new Cup();
    Field[] squares = new Field[40];
    GUIController controller;
    public OwnedProperty property;


    public Field getSquare(int i) {
        return squares[i];

    }

    public void playGame() { // These methods below are essential for the game to run, thus Main will run playGame()
        board = new FieldController(players, guiController);
        this.guiController.initializeBoard(board);
        numberOfPlayers();
        try {
            gameLoop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void gameLoop() throws InterruptedException {
        while (noWinner) {
            for (int i = 0; i < players.length; i++) {
                //tester for specifikke felter
                //int faceValue = 30;
                currentPlayer = players[i];
                if(currentPlayer.isInJail) {
                    JailField jailField = board.getJailField();
                    jailField.GetOutOfJail(currentPlayer);
                    if (currentPlayer.isInJail)

                        continue;
                }
                guiController.askForDice();
                int faceValue = cup.CupRoll();
                guiController.setDice(cup.GetDice1Value(),cup.GetDice2Value());


                guiController.removeCar(currentPlayer.getPosition(), i);




                /*if (players.get(i).getPosition() - faceValue > 0) {
                    guiController.AddCar(players.get(i).getPosition() - faceValue, i);
                } else {
                    guiController.AddCar(players.get(i).getPosition(), i);
                }*/

                for (int j = 0; j < faceValue; j++) {
                    int newPos = (currentPlayer.getPosition() + j)%40;

                    guiController.removeCar(newPos, i);
                    guiController.addCar((newPos+1)%40, i);
                    Thread.sleep(150);

                }
                 // Updating player position
                if (currentPlayer.getPosition() + faceValue > 39) { //When you exceed the last field, you get to a new round
                    startField(i);
                    currentPlayer.setPosition(currentPlayer.getPosition() + faceValue - 40);

                } else {
                    currentPlayer.setPosition(currentPlayer.getPosition() + faceValue);
                }

               guiController.wannaBuy(board.getSquare(currentPlayer.getPosition()), currentPlayer);

                fieldOutcome(i); // The field outcome for the specific field

                for (Player player : players) {
                    guiController.setNewBalance(player.getIndex(), player.getAccount().getBalance());

                }
                guiController.addHouse(board.getSquare(currentPlayer.getPosition()));

                winner(i); // Checking if the winner is found.
            }

        }
    }

    private void winner(int player) { // The last person to have a balance >0 wins
        int loserBalance = 0;
        List<String> winnerName = new ArrayList<String>();

        if (players[player].getAccount().getBalance() < 0) {
            for (int i = 0; i < players.length; i++) {
                if (players[i].getAccount().getBalance() > loserBalance) {
                    winnerName.add(players[i].getPlayerName());
                }
            }

            if (winnerName.size() == 1) {
                guiController.getWinnerMessage(winnerName);
                System.exit(0); // Games finishes when the winner is announced
            }

        }
    }

    private void numberOfPlayers() { // Start money declaration
        int playerList = guiController.getPlayerList();

        players = new Player[playerList];

        for (int i = 0; i < playerList; i++) {
            String[] temporaryName = new String[names.length + 1];
            int[] temporaryAge = new int[ages.length+1];
            for (int j = 0; j < names.length; j++) {
                temporaryName[j]=names[j];
                temporaryAge[j]=ages[j];
            }
            names = temporaryName;
            ages = temporaryAge;

            //Insert name
            String name = guiController.getPlayerName(i);
            int age = 0;
            boolean ageIsInt;
            do {
                try {
                    //insert age
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

    private void fieldOutcome(int i) { // The field outcome method
        board.getSquare(players[i].getPosition()).arrived(players[i]);
    }

    private void startField(int i) { // You get 4.000 dkk when you pass the Start-field
        players[i].getAccount().setBalance(players[i].getAccount().getBalance() + 4000);
    }
}