package game;

import java.awt.Color;
import java.util.List;

import GUI.GUIController;
import gui_fields.*;

public class Board {
    GUI_Field[] fields = new GUI_Field[32];
    Square[] squares = new Square[32];
    public Board(List<Player> players, GUIController controller) {
        CreateStreets(players, controller);
    }

    public GUI_Field getField(int i) {
        return fields[i];
    }

    public Square getSquare(int i) {
        return squares[i];

    }

    public GUI_Field[] BoardCreator() {  // This constructor creates our GUI Board/Fields

        fields[0] = new GUI_Start("START", "", "",Color.getHSBColor(153,232,179), Color.PINK);
        fields[1] = new GUI_Chance("?", "","",Color.BLACK, Color.YELLOW);
        fields[2] = new GUI_Street("Balloon Stand","Price: $1","", "",Color.magenta, Color.BLACK);
        fields[3] = new GUI_Street("Cotton Candy", "Price: $1","", "",Color.magenta, Color.BLACK);
        fields[4] = new GUI_Chance("?", "","",Color.BLACK, Color.YELLOW);
        fields[5] = new GUI_Street("Yellow Line Railroad", "Price: $1","", "",Color.WHITE, Color.ORANGE);
        fields[6] = new GUI_Street("Puppet Show", "Price: $2","", "",Color.cyan, Color.BLACK);
        fields[7] = new GUI_Street("Magic Show", "Price: $2","", "",Color.cyan, Color.black);

        fields[8] = new GUI_Jail();
        fields[8].setSubText("JAIL VISIT");
        fields[8].setDescription("Jail visit");

        fields[9] = new GUI_Chance("?", "","",Color.BLACK, Color.YELLOW);
        fields[10] = new GUI_Street("Rest Rooms", "Price: $3","", "", new Color(165, 114, 47, 207), Color.WHITE);
        fields[11] = new GUI_Street("Merry-Go-Round", "Price: $2","", "",Color.PINK, Color.BLACK);
        fields[12] = new GUI_Street("Paddle Boats", "Price: $2","", "",Color.PINK, Color.BLACK);
        fields[13] = new GUI_Street("Green Line Railroad", "Price: $1","", "",Color.WHITE, Color.GREEN);
        fields[14] = new GUI_Street("Water Slide", "Price: $3","", "",Color.orange, Color.BLACK);
        fields[15] = new GUI_Street("Miniature Golf", "Price: $3", "", "",Color.orange, Color.BLACK);
        fields[16] = new GUI_Street("Pennybag", "Price: $1","", "",Color.white, Color.BLACK);
        fields[17] = new GUI_Chance("?", "","",Color.BLACK, Color.YELLOW);
        fields[18] = new GUI_Street("Video Arcade", "Price: $3","", "",Color.RED, Color.BLACK);
        fields[19] = new GUI_Street("Haunted House", "Price: $3","", "",Color.RED, Color.BLACK);
        fields[20] = new GUI_Chance("?", "","",Color.BLACK, Color.YELLOW);
        fields[21] = new GUI_Street("Blue Line Railroad", "Price: $1","", "",Color.WHITE, Color.BLUE);
        fields[22] = new GUI_Street("Helicopter Ride", "Price: $4","", "",Color.YELLOW, Color.BLACK);
        fields[23] = new GUI_Street("Pony Ride","Price: $4","", "",Color.YELLOW, Color.BLACK);

        fields[24] = new GUI_Jail();
        fields[24].setSubText("JAIL");
        fields[24].setDescription("Locked up");

        fields[25] = new GUI_Chance("?", "","",Color.BLACK, Color.YELLOW);
        fields[26] = new GUI_Street("Go to Rest rooms","Price: $3","You got the Tower, now make it Shower!","",new Color(165, 114, 47, 207), Color.WHITE);
        fields[27] = new GUI_Street("Bumper Cars","Price: $4","", "",Color.GREEN, Color.BLACK);
        fields[28] = new GUI_Street("Ferris Wheel", "Price: $4","", "",Color.GREEN, Color.BLACK);
        fields[29] = new GUI_Street("Red Line Railroad", "Price: $1","", "",Color.WHITE, Color.RED);
        fields[30] = new GUI_Street("Loop The Loop", "Price: $5","", "",Color.BLUE, Color.BLACK);
        fields[31] = new GUI_Street("Roller Coaster","Price: $5","", "",Color.BLUE, Color.BLACK);
        return fields;
    }

    public void CreateStreets(List<Player> players, GUIController controller) { // This constructor is used to decide the buyprice and rentprice throughtout the game for each fields
        squares[0] = new StartSquare("START");
        squares[1] = new ChanceSquare("?", players, controller);
        squares[2] = new OwnedProperty("Balloon Stand", 1, 1,controller);
        squares[3] = new OwnedProperty("Cotton Candy", 1, 1,controller);
        squares[4] = new ChanceSquare("?", players, controller);
        squares[5] = new OwnedProperty("Yellow Line Railroad", 1, 1,controller);
        squares[6] = new OwnedProperty("Puppet Show", 2, 1,controller);
        squares[7] = new OwnedProperty("Magic Show", 2, 1,controller);

        squares[8] = new VisitJailSquare("Jail Visit");

        squares[9] = new ChanceSquare("?", players, controller);
        squares[10] = new OwnedProperty("Rest Rooms", 3, 1,controller);
        squares[11] = new OwnedProperty("Merry-Go-Round", 2, 1,controller);
        squares[12] = new OwnedProperty("Paddle Boats",2, 2,controller);
        squares[13] = new OwnedProperty("Green Line Railroad", 1, 1,controller);
        squares[14] = new OwnedProperty("Water Slide", 3, 1,controller);
        squares[15] = new OwnedProperty("Miniature Golf",3, 2,controller);
        squares[16] = new OwnedProperty("Pennybag", 1, 1,controller);
        squares[17] = new ChanceSquare("?", players, controller);
        squares[18] = new OwnedProperty("Video Arcade", 3, 1,controller);
        squares[19] = new OwnedProperty("Haunted House", 3, 2,controller);
        squares[20] = new ChanceSquare("?", players, controller);
        squares[21] = new OwnedProperty("Blue Line Railroad", 3, 1,controller);
        squares[22] = new OwnedProperty("Helicopter Ride", 4, 1,controller);
        squares[23] = new OwnedProperty("Pony Ride", 4, 1,controller);

        squares[24] = new JailSquare("JAIL",controller);

        squares[25] = new ChanceSquare("?", players, controller);
        squares[26] = new OwnedProperty("Go to Rest rooms", 3, 1,controller);
        squares[27] = new OwnedProperty("Bumper Cars", 4, 1,controller);
        squares[28] = new OwnedProperty("Ferris Wheel", 4, 2,controller);
        squares[29] = new OwnedProperty("Red Line Railroad", 1, 1,controller);
        squares[30] = new OwnedProperty("Loop The Loop", 5, 2,controller);
        squares[31] = new OwnedProperty("Roller Coaster", 5, 2,controller);

    }
}
