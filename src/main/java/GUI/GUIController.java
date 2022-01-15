package GUI;
import java.awt.*;
import java.util.List;

import chance.ChanceCardController;
import fields.Field;
import fields.Property;
import fields.StreetField;
import fields.FieldController;

import game.Cup;
import game.Player;

import gui_fields.*;
import gui_main.GUI;

public class GUIController {

    private GUI_Player[] guiPlayers;
    private GUI gui;
    FieldController board;

    private static GUIController instance;

    public static GUIController getInstance() {
        if (instance == null) {
            instance = new GUIController();
        }
        return instance;
    }

    public GUI initializeBoard(FieldController board) { // Initializing the board
        this.board = board;
        this.gui = new GUI(board.BoardCreator(), new Color(14, 162, 124)); // Change game-board color
        return this.gui;
    }

    public int getPlayerList() { // Choosing the number of players in the GUI
        return Integer.parseInt(gui.getUserButtonPressed("Choose number of players", "3", "4", "5", "6"));
    }

    public String getPlayerName(int i) { // Entering the names of the players in the GUI
        String name = gui.getUserString("Enter the name of Player" + (i + 1));
        return name;
    }

    public int getPlayerAge(int i) { // Entering the names of the players in the GUI
        int age = gui.getUserInteger("Enter the age of Player" + (i + 1) + " (10+) ");
        return age;
    }

    public void askForDice() {
        gui.getUserButtonPressed("Throw Dice", "Throw");
    }

    public void setDice(int die1, int die2) { // Creates the dice in the GUI
        gui.setDice(die1, die2); // two dice visible on the board
    }

    public void addPlayers(Player[] players) { // Creates different types of game-pieces
        this.guiPlayers = new GUI_Player[players.length];
        GUI_Car[] car_choices = {
                new GUI_Car(Color.PINK, Color.RED, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.HORIZONTAL_GRADIANT),
                new GUI_Car(Color.BLACK, Color.WHITE, GUI_Car.Type.UFO, GUI_Car.Pattern.CHECKERED),
                new GUI_Car(Color.BLUE, Color.WHITE, GUI_Car.Type.RACECAR, GUI_Car.Pattern.DOTTED),
                new GUI_Car(Color.YELLOW, Color.PINK, GUI_Car.Type.CAR, GUI_Car.Pattern.ZEBRA),
                new GUI_Car(Color.GREEN, Color.DARK_GRAY, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.HORIZONTAL_LINE),
                new GUI_Car(Color.PINK, new Color(117, 15, 255), GUI_Car.Type.UFO, GUI_Car.Pattern.FILL)
        };

        for (int i = 0; i < players.length; i++) { // Array of players in the GUI
            this.guiPlayers[i] = new GUI_Player(players[i].getPlayerName(), players[i].getAccount().getBalance(), car_choices[i]);
            addCar(0, i);
            gui.addPlayer(this.guiPlayers[i]);
        }

    }

    public void addCar(int position, int player) { //Adds car
        board.getField(position).setCar(guiPlayers[player], true);
    } // Adds the car to the GUI

    public void removeCar(int position2, int player2) {
        board.getField(position2).setCar(guiPlayers[player2], false);
    } // Removes the car from the GUI


    public void setNewBalance(int player, int newBalance) {
        this.guiPlayers[player].setBalance(newBalance);
    }

    public void getWinnerMessage(List<String> message) {
        gui.showMessage(message.toString() + " WON!!");
        System.out.println(message.toString() + "WON!!");
    } // Winner message

    public void showMessage(String message) {
        gui.displayChanceCard(message);
    } // Shows the Chance card outcome message

    public void addHouse(Field property) {
        if (FieldController.getInstance().SameOwnerColor((StreetField) property)) {
            ((StreetField) property).addHouse();
            GUI_Street field = (GUI_Street) gui.getFields()[((StreetField) property).getIndex()];
            field.setHouses(1);
        }else{
            showMessage("You can't build a house here yet :( \n" +
                    "Collect all the deeds for the same colored streets to buy houses.");
        }
    }
    public String playerChoice(){
        String choice = gui.getUserSelection("Choose an option","Roll Dice","Buy Building");
        return choice;
    }

    public String chooseStreet(Player player){
        String streetChoice = gui.getUserSelection("Choose a Property", FieldController.getInstance().getPropertyList(player));
        return streetChoice;
    }

    //choose if you wanna buy the property
    public boolean wannaBuy() {
        boolean choice = gui.getUserLeftButtonPressed("Do you wanna buy the property", "yes", "no");
        return choice;
    }

    public String getOutOfJail() {
        String jailChoice = gui.getUserSelection("Choose an option?", "Pay 1000$", "Roll the dice", "Use a Get-Out-Of-Jail Card");
        return jailChoice;
    }

    public void pressChanceButton() {
        gui.getUserButtonPressed(
                "Press the button to try your luck!",
                "Draw card"
        );
    }
    public void okButton(){
        gui.getUserButtonPressed(
                "Press OK to continue",
                "OK"
        );
    }
}