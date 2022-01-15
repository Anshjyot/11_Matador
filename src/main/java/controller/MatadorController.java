
package controller;

import GUI.GUIController;
import fields.Field;
import fields.FieldController;
import fields.JailField;
import fields.StreetField;
import game.Cup;
import game.Player;
import gui_main.GUI;
import java.util.*;
import java.util.List;

public class MatadorController {

    private final int StartField = 0;
    private final int STARTBALANCE = 30000;
    private boolean noWinner = true;
    public Player[] players;
    Player currentPlayer;
    FieldController board;
    protected int[] ages = new int[0];
    protected String[] names = new String[0];
    protected GUI gui;
    private Cup cup = new Cup();
    Field[] squares = new Field[40];

    private static MatadorController instance;

    public static MatadorController getInstance() {
        if (instance == null) {
            instance = new MatadorController();
        }
        return instance;
    }

    public void playGame() { // These methods below are essential for the game to run, thus Main will run playGame()
        board = new FieldController();
        GUIController.getInstance().initializeBoard(board);
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
                    FieldController.getInstance().GetOutOfJail(currentPlayer);
                    if (currentPlayer.isInJail)

                        continue;
                }
                GUIController.getInstance().askForDice();
                int faceValue = cup.CupRoll();
                GUIController.getInstance().setDice(cup.GetDice1Value(),cup.GetDice2Value());

                GUIController.getInstance().removeCar(currentPlayer.getPosition(), i);

                /*if (players.get(i).getPosition() - faceValue > 0) {
                    guiController.AddCar(players.get(i).getPosition() - faceValue, i);
                } else {
                    guiController.AddCar(players.get(i).getPosition(), i);
                }*/

                for (int j = 0; j < faceValue; j++) {
                    int newPos = (currentPlayer.getPosition() + j)%40;

                    GUIController.getInstance().removeCar(newPos, i);
                    GUIController.getInstance().addCar((newPos+1)%40, i);
                    Thread.sleep(150);

                }
                 // Updating player position
                if (currentPlayer.getPosition() + faceValue > 39) { //When you exceed the last field, you get to a new round
                    FieldController.getInstance().startField(currentPlayer);
                    currentPlayer.setPosition(currentPlayer.getPosition() + faceValue - 40);

                } else {
                    currentPlayer.setPosition(currentPlayer.getPosition() + faceValue);
                }

                //Skal rykkes ind i field controller.


                FieldController.getInstance().fieldOutcome(currentPlayer, players); // The field outcome for the specific field

                for (Player player : players) {
                    GUIController.getInstance().setNewBalance(player.getIndex(), player.getAccount().getBalance());
                }
                //guiController.addHouse(board.getSquare(currentPlayer.getPosition()));

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
                GUIController.getInstance().getWinnerMessage(winnerName);
                System.exit(0); // Games finishes when the winner is announced
            }

        }
    }

    private void numberOfPlayers() { // Start money declaration
        int playerList = GUIController.getInstance().getPlayerList();

        this.players = new Player[playerList];

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
            String name = GUIController.getInstance().getPlayerName(i);
            int age = 0;
            boolean ageIsInt;
            do {
                try {
                    //insert age
                    age = GUIController.getInstance().getPlayerAge(i);
                    ageIsInt = age >= 10 && age <= 150;
                } catch (NumberFormatException e) {
                    ageIsInt = false;
                }
            } while (!ageIsInt);
            players[i] = new Player(name,age, STARTBALANCE,StartField,i);
            this.players[i] = players[i];
            //ages[i] = age;
            //players.add(new Player(name, age, startBalance, StartField, i));
        }

        GUIController.getInstance().addPlayers(players); // Adds players to the GUI
    }

    public Player getPlayer(int i){return this.players[i];}
    public Player[] getPlayers(){return this.players;}

}