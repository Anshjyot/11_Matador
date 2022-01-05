package game;

import java.awt.Color;
import java.util.List;
import GUI.GUIController;
import gui_fields.*;

public class Board {
    GUI_Field[] fields = new GUI_Field[40];
    Square[] squares = new Square[40];
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

        fields[0] = new GUI_Start("START", "Modtag kr. 4.000 hver gang du passere", "",Color.RED, Color.BLACK);
        fields[1] = new GUI_Street("Rødovrevej", "kr. 1200","","",Color.BLUE, Color.BLACK);
        fields[2] = new GUI_Chance("?","Prøv Lykken", "",Color.BLACK, Color.GREEN);
        fields[3] = new GUI_Street("Hvidovrevej", "kr. 1200","", "",Color.BLUE, Color.BLACK);
        fields[4] = new GUI_Tax("Betal Indkomst-skat", "10% eller kr. 4.000","", new Color(0, 171, 255), Color.BLACK);
        fields[5] = new GUI_Shipping("Scandlines", "kr. 4.000","","", "",Color.BLUE, Color.BLACK);
        fields[6] = new GUI_Street("Roskildevej", "kr. 2.000","", "",Color.ORANGE, Color.BLACK);
        fields[7] = new GUI_Chance("?","Prøv Lykken", "",Color.BLACK, Color.GREEN);
        fields[8] = new GUI_Street("ValbyLanggade", "kr. 2.000","","",Color.ORANGE, Color.BLACK);
        fields[9] = new GUI_Street("Allégade", "kr. 2.400","", "", Color.ORANGE, Color.BLACK);

        fields[10] = new GUI_Jail();
        fields[10].setSubText("På fængsels-besøg");

        fields[11] = new GUI_Street("Frederiksbergs Allé", "kr. 2.800","", "",Color.yellow, Color.BLACK);
        fields[12] = new GUI_Brewery();
        fields[13] = new GUI_Street("Bülowsvej", "kr. 2.800","", "",Color.yellow, Color.BLACK);
        fields[14] = new GUI_Street("Gl. Kongevej", "kr. 3.200", "", "",Color.yellow, Color.BLACK);
        fields[15] = new GUI_Shipping("Mols linien", "kr. 4.000","","", "",Color.RED, Color.BLACK);
        fields[16] = new GUI_Street("Bernstorffsvej","kr. 3.600", "","",Color.LIGHT_GRAY, Color.YELLOW);
        fields[17] = new GUI_Chance("?","Prøv Lykken", "",Color.BLACK, Color.GREEN);
        fields[18] = new GUI_Street("Hellerupvej", "kr. 3.600","", "",Color.LIGHT_GRAY, Color.BLACK);
        fields[19] = new GUI_Street("Strandvejen","kr. 4.000", "","",Color.LIGHT_GRAY, Color.BLACK);
        fields[20] = new GUI_Street("Parkering", "","", "",new Color(0, 171, 255), Color.BLACK);
        fields[21] = new GUI_Street("Trianglen", "kr. 4.000","", "",Color.RED, Color.BLACK);
        fields[22] = new GUI_Chance("?","Prøv Lykken", "",Color.BLACK, Color.GREEN);
        fields[23] = new GUI_Street("Østerbrogade","kr. 4.000", "","",Color.RED, Color.BLACK);
        fields[24] = new GUI_Street("Grønningen","kr. 4.800","","", Color.RED, Color.BLACK);
        fields[25] = new GUI_Shipping("Scandlines","kr. 4.000","","", "",Color.BLUE, Color.BLACK);
        fields[26] = new GUI_Street("Bredgade", "kr. 5.200","", "",Color.WHITE, Color.BLACK);
        fields[27] = new GUI_Street("Kgs. Nytorv", "kr. 5.200","", "",Color.WHITE, Color.BLACK);
        fields[28] = new GUI_Brewery();
        fields[29] = new GUI_Street("Østergade","kr. 5.600","", "",Color.WHITE, Color.BLACK);

        fields[30] = new GUI_Jail();
        fields[30].setSubText("Du fængsles");

        fields[31] = new GUI_Street("Amagertorv","kr. 6.000","", "",Color.YELLOW, Color.BLACK);
        fields[32] = new GUI_Street("Vimmelskaftet","kr. 6.000","", "",Color.YELLOW, Color.BLACK);
        fields[33] = new GUI_Chance("?","Prøv Lykken","",Color.BLACK, Color.GREEN);
        fields[34] = new GUI_Street("Nygade","kr. 6.400","", "",Color.YELLOW, Color.BLACK);
        fields[35] = new GUI_Shipping("Scandlines","kr. 4.000","","", "",Color.BLUE, Color.BLACK);
        fields[36] = new GUI_Chance("?","Prøv Lykken", "",Color.BLACK, Color.GREEN);
        fields[37] = new GUI_Street("Frederiksberggade","kr. 7.000","", "", Color.MAGENTA, Color.BLACK);
        fields[38] = new GUI_Tax("Ekstraordinær stats-skat","kr. 2.000", "",Color.BLUE, Color.BLACK);
        fields[39] = new GUI_Street("Rådhuspladsen","kr. 8.000","", "",Color.MAGENTA, Color.BLACK);
        return fields;
    }

    public void CreateStreets(List<Player> players, GUIController controller) { // This constructor is used to decide the buyprice and rentprice throughtout the game for each fields
        squares[0] = new StartSquare("START");
        squares[1] = new OwnedProperty("Rødovrevej",1200, 1,controller);
        squares[2] = new ChanceSquare("Prøv Lykken", players, controller);
        squares[3] = new OwnedProperty("Hvidovrevej", 1200, 1,controller);
        squares[4] = new OwnedProperty("Betal Indkomst-skat", 4000, 0,controller);
        squares[5] = new OwnedProperty("Scandlines", 4000, 1,controller);
        squares[6] = new OwnedProperty("Roskildevej", 2000, 1,controller);
        squares[7] = new ChanceSquare("Prøv Lykken", players,controller);
        squares[8] = new OwnedProperty("Valbylanggade", 2000, 1,controller);
        squares[9] = new OwnedProperty("Allégade", 2400, 1,controller);

        squares[10] = new VisitJailSquare("På fængsels-besøg");

        squares[11] = new OwnedProperty("Frederiksbergs Allé", 2800, 1,controller);
        squares[12] = new OwnedProperty("Tuborg Squash",3000, 2,controller);
        squares[13] = new OwnedProperty("Bülowsvej", 2800, 1,controller);
        squares[14] = new OwnedProperty("Gl. Kongevej", 3200, 1,controller);
        squares[15] = new OwnedProperty("Mols linien",4000, 2,controller);
        squares[16] = new OwnedProperty("Bernstorffsvej", 3600, 1,controller);
        squares[17] = new ChanceSquare("Prøv Lykken", players,controller);
        squares[18] = new OwnedProperty("Hellerupvej", 3600, 1,controller);
        squares[19] = new OwnedProperty("Strandvejen", 4000, 2,controller);
        squares[20] = new ChanceSquare("Parkering", players, controller);
        squares[21] = new OwnedProperty("Trianglen", 4000, 1,controller);
        squares[22] = new ChanceSquare("Prøv Lykken", players,controller);
        squares[23] = new OwnedProperty("Østerbrogade", 4000, 1,controller);
        squares[24] = new OwnedProperty("Grønningen", 4600, 1,controller);
        squares[25] = new OwnedProperty("Scandlines", 4000, 1,controller);
        squares[26] = new OwnedProperty("Bredgade", 5200, 1,controller);
        squares[27] = new OwnedProperty("Kgs. Nytorv", 5200, 2,controller);
        squares[28] = new OwnedProperty("Coca Cola", 3000, 1,controller);
        squares[29] = new OwnedProperty("Østergade", 5600, 2,controller);

        squares[30] = new JailSquare("JAIL",controller);

        squares[31] = new OwnedProperty("Amagertorv", 6000, 2,controller);
        squares[32] = new OwnedProperty("Vimmelskaftet", 6000, 2,controller);
        squares[33] = new ChanceSquare("Prøv Lykken", players,controller);
        squares[34] = new OwnedProperty("Nygade", 6400, 2,controller);
        squares[35] = new OwnedProperty("Scandlines", 4000, 2,controller);
        squares[36] = new ChanceSquare("Prøv Lykken", players,controller);
        squares[37] = new OwnedProperty("Frederiksberggade", 7000, 2,controller);
        squares[38] = new OwnedProperty("Ekstraordinær stats-skat", 2000, 2,controller);
        squares[39] = new OwnedProperty("Rådhuspladsen", 8000, 2,controller);

    }
}




