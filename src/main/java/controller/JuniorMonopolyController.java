package controller;

import GUI.GUIController;
import game.Board;
import game.Player;

import java.util.*;
import java.util.List;

public class JuniorMonopolyController {

    private final int StartField = 0;
    private GUIController guiController = new GUIController();
    private int startBalance;
    private boolean noWinner = true;
    List<Player> players = new ArrayList<>();
    Board board;


    public void playGame() { // These methods below are essential for the game to run, thus Main will run playGame()
        board = new Board(players, guiController);
        this.guiController.initializeBoard(board);
        NumberOfPlayers();
        gameLoop();
    }

    private void gameLoop() {
        while (noWinner) {
            for (int i = 0; i < players.size(); i++) {
                int faceValue = guiController.setDice();

                guiController.RemoveCar(players.get(i).getPosition(), i);

                if (players.get(i).getPosition() + faceValue > 31) { // When you exceed the last field, you get to a new round

                    StartField(i);
                    players.get(i).setPosition(players.get(i).getPosition() + faceValue - 32);

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

        if (playerList == 2) {
            startBalance = 35;
        }
        if (playerList == 3) {
            startBalance = 35;
        }
        if (playerList == 4) {
            startBalance = 35;
        }


        for (int i = 0; i < playerList; i++) {
            String name = guiController.getPlayerName(i);
            players.add(new Player(name, startBalance, StartField, i));
        }
        guiController.addPlayers(players); // Adds players to the GUI
    }

    private void FieldOutcome(int i) { // The field outcome method
        board.getSquare(players.get(i).getPosition()).Arrived(players.get(i));


    }

    private void StartField(int i) { // You get $2 when you pass the Start-field
        players.get(i).getAccount().setBalance(players.get(i).getAccount().getBalance() + 2);
    }

}


