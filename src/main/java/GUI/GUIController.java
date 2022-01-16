package GUI;
import java.awt.*;
import java.util.List;
import fields.Field;
import fields.OwnedProperty;
import fields.FieldController;
import game.Cup;
import game.Player;
import gui_fields.*;
import gui_main.GUI;
import language.Language;

public class GUIController {

    public Cup cup;
    private GUI_Player[] guiPlayers;
    GUIController controller;
    private GUI gui;
    FieldController board;
    private GUI_Player[] players;
    Field[] squares = new Field[40];
    GUI_Field[] fields = new GUI_Field[40];
    private Language language;
    public static final String TEXT_CYAN = "\u001B[36m";


    public void initializeBoard(FieldController board) { // Initializing the board
        this.board = board;
        this.gui = new GUI(board.BoardCreator(), new Color(14, 162, 124)); // Change game-board color
    }

    public void getLanguage() {
        gui.getUserButtonPressed("Choose language", "English");
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

    // GUI message for dice
    public void askForDice() {
        gui.getUserButtonPressed("Roll The Dice", "Roll");
    }

    public void setDice(int die1, int die2) { // Creates the dice in the GUI
        gui.setDice(die1, die2); // two dice visible on the board
    }

    public void addPlayers(Player[] players) { // Creates different types of game-pieces
        this.guiPlayers = new GUI_Player[players.length];
        GUI_Car[] car_choices = {
                new GUI_Car(Color.RED, Color.PINK, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.HORIZONTAL_GRADIANT),
                new GUI_Car(Color.ORANGE, Color.WHITE, GUI_Car.Type.UFO, GUI_Car.Pattern.CHECKERED),
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

    // Adds the car to the GUI
    public void addCar(int position, int player) { //Adds car
        board.getField(position).setCar(guiPlayers[player], true);
    }

    // Removes the car from the GUI
    public void removeCar(int position2, int player2) {
        board.getField(position2).setCar(guiPlayers[player2], false);
    }

    public void setNewBalance(int player, int newBalance) {
        this.guiPlayers[player].setBalance(newBalance);
    }

    // Winner message
    public void getWinnerMessage(List<String> message) {
        gui.showMessage(message.toString() + TEXT_CYAN + " WON!!");
        System.out.println(message.toString() + TEXT_CYAN + " WON!!");
    }

    // Shows the Chance card outcome message
    public void showMessage(String message) {
        gui.displayChanceCard(message);
    }


    //adds house to a field, when the conditions are fulfilled
    public void addHouse(Field property) {
        if (property instanceof OwnedProperty) {
            if (board.SameOwnerColor((OwnedProperty) property)) {
                ((OwnedProperty) property).addHouse();
                GUI_Street field = (GUI_Street) gui.getFields()[((OwnedProperty) property).getIndex()];
                field.setHouses(1);
            }
        }
    }

    //choose if you wanna buy the property
  public void wannaBuy(Field property, Player player) {
      if (property instanceof OwnedProperty) {
          if (!((OwnedProperty) property).isThereAnOwner()) {
              boolean yes = gui.getUserLeftButtonPressed("Do you wanna buy the property", "yes", "no");
              if (yes) {
                  ((OwnedProperty)property).buyDeed(player);
                  GUI_Street field = (GUI_Street) gui.getFields()[((OwnedProperty) property).getIndex()];
                  ((OwnedProperty)property).buyDeed(player);

                  Color playercolors = this.guiPlayers[player.getIndex()].getCar().getPrimaryColor();
                  field.setBorder(playercolors);
                  gui.showMessage("You now own this field");

              }
          }

        }
    }

    public String getOutOfJail() { // Choose how you want to get out of Jail [GUI]
        String jailChoice = gui.getUserSelection("Choose an option?", "Pay 1000$", "Roll the dice", "Use a Get-Out-Of-Jail Card");
        return jailChoice;
    }

    public void pressChanceButton() { // [GUI] message for ChanceButton]
        gui.getUserButtonPressed(
                "Press the button to try your luck!",
                "Draw card"
        );
    }

}