package GUI;
        import java.awt.*;
        import java.util.List;
        import game.Board;
        import game.Dice;
        import game.Player;

        import gui_fields.GUI_Car;
        import gui_fields.GUI_Player;
        import gui_main.GUI;

public class GUIController {

    private GUI_Player[] guiPlayers;
    private Dice dice = new Dice();
    private GUI gui;

    Board board;

    public GUIController() {
    }
    public void initializeBoard(Board board) { // Initializing the board
        this.board = board;
        this.gui = new GUI(board.BoardCreator(),Color.GRAY); // Change game-board color
    }

    public int getPlayerList() { // Choosing the number of players in the GUI
        return Integer.parseInt(gui.getUserButtonPressed("Choose number of players", "2", "3", "4"));
    }

    public String getPlayerName(int i) { // Entering the names of the players in the GUI
        String name = gui.getUserString("Enter the name of Player"+ (i + 1));
        return name;
    }

    public int setDice() { // Creates the dice in the GUI
        gui.getUserButtonPressed("Throw Dice", "Throw");
        int x = (int)(Math.random()*7)+2;
        int y = (int)(Math.random()*7)+2;
        int rotation = (int)(Math.random()*360);
        gui.setDice(dice.getDice(),rotation,x,y,dice.getDice(),rotation, x,y); // Only one dice visible on the board
        dice.ThrowDice();
        return dice.getDice();
    }

    public void addPlayers(List<Player> players) { // Creates different types of game-pieces
        this.guiPlayers = new GUI_Player[players.size()];
        GUI_Car[] car_choices = {
                new GUI_Car(Color.PINK, Color.RED, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.HORIZONTAL_GRADIANT),
                new GUI_Car(Color.BLACK, Color.WHITE, GUI_Car.Type.UFO, GUI_Car.Pattern.CHECKERED),
                new GUI_Car(Color.BLUE, Color.WHITE, GUI_Car.Type.RACECAR, GUI_Car.Pattern.DOTTED),
                new GUI_Car(Color.YELLOW, Color.PINK, GUI_Car.Type.CAR, GUI_Car.Pattern.ZEBRA)
        };
        for (int i = 0; i < players.size(); i++) { // Array of players in the GUI
            this.guiPlayers[i] = new GUI_Player(players.get(i).getPlayerName(), players.get(i).getAccount().getBalance(), car_choices[i]);
            AddCar(0, i);
            gui.addPlayer(this.guiPlayers[i]);
        }
    }


    public void AddCar(int position, int player) { //Adds car
        board.getField(position).setCar(guiPlayers[player], true);
    } // Adds the car to the GUI
    public void RemoveCar(int position2, int player2) {
        board.getField(position2).setCar(guiPlayers[player2], false);
    } // Removes the car to the GUI

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

}
