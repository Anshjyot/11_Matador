package game;

import java.awt.Color;
import java.util.List;
import GUI.GUIController;
import fields.*;
import gui_fields.*;

public class Board {
    GUI_Field[] fields = new GUI_Field[40];
    Field[] squares = new Field[40];
    public Board(List<Player> players, GUIController controller) {
        CreateStreets(players, controller);
    }

    public GUI_Field getField(int i) {
        return fields[i];
    }

    public Field getSquare(int i) {
        return squares[i];

    }

    public GUI_Field[] BoardCreator() {

        fields[0] = new GUI_Start("Start", "Modtag: 4.000", "Modtag kr. 4.000,-\nnår de passerer start", Color.RED, Color.BLACK);
        fields[1] = new GUI_Street("Rødovrevej", "kr. 1200", "Rødovrevej", "Leje:  20", new Color(75, 155, 225), Color.BLACK);
        fields[2] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(0, 0, 0), Color.WHITE);
        fields[3] = new GUI_Street("Hvidovrevej", "kr. 1200", "Hvidovrevej", "Leje:  20", new Color(75, 155, 225), Color.BLACK);
        fields[4] = new GUI_Tax("Betal\nindkomst-\nskat", "10% el. 4.000,-", "Betal indkomstskat\n10% eller kr. 4.000,-", new Color(20,82,226), Color.BLACK);
        fields[5] = new GUI_Shipping("default", "Scandlines", "kr. 4.000", "Scandlines", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[6] = new GUI_Street("Roskildevej", "kr. 2.000", "Roskildevej", "Leje:  40", new Color(255, 135, 120), Color.BLACK);
        fields[7] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.",new Color(0, 0, 0), Color.WHITE);
        fields[8] = new GUI_Street("Valby\nLanggade", "kr. 2.000", "Valby Langgade", "Leje:  40", new Color(255, 135, 120), Color.BLACK);
        fields[9] = new GUI_Street("Allégade", "kr. 2.400", "Allégade", "Leje:  45", new Color(255, 135, 120), Color.BLACK);
        fields[10] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK);
        fields[11] = new GUI_Street("Frederiks-\nberg Allé", "kr. 2.800", "Frederiksberg Allé", "Leje:  50", new Color(255, 255, 50), Color.BLACK);
        fields[12] = new GUI_Brewery("default", "Tuborg", "kr. 3.000", "Tuborg øl", "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[13] = new GUI_Street("Bülowsvej", "kr. 2.800", "Bülowsvej", "Leje:  50", new Color(255, 255, 50), Color.BLACK);
        fields[14] = new GUI_Street("Gammel Kongevej", "kr. 3.200", "Gammel Kongevej", "Leje:  50", new Color(255, 255, 50), Color.BLACK);
        fields[15] = new GUI_Shipping("default", "Scandlines", "kr. 4.000", "Scandlines", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[16] = new GUI_Street("Bernstorffsvej", "kr. 3.600", "Bernstorffsvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK);
        fields[17] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(0, 0, 0), Color.WHITE);
        fields[18] = new GUI_Street("Hellerupvej", "kr. 3.600", "Hellerupvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK);
        fields[19] = new GUI_Street("Strandvejen", "kr. 4.000", "Strandvejen", "Leje:  60", new Color(153, 153, 153), Color.BLACK);
        fields[20] = new GUI_Refuge("default", "Parkering", "Parkering", "Ta' en pause", Color.WHITE, Color.BLACK);
        fields[21] = new GUI_Street("Trianglen", "kr. 4.000", "Trianglen", "Leje:  70", Color.RED, Color.BLACK);
        fields[22] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(0, 0, 0), Color.WHITE);
        fields[23] = new GUI_Street("Østerbro-\ngade", "kr. 4.000", "Østerbrogade", "Leje:  70", Color.RED, Color.BLACK);
        fields[24] = new GUI_Street("Grønningen", "kr. 4.800", "Grønningen", "Leje:  80", Color.RED, Color.BLACK);
        fields[25] = new GUI_Shipping("default", "Scandlines", "kr. 4.000", "Scandlines", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[26] = new GUI_Street("Bredgade", "kr. 5.200", "Bredgade", "Leje:  80", Color.WHITE, Color.BLACK);
        fields[27] = new GUI_Street("Kgs. Nytorv", "kr. 5.200", "Kongens Nytorv", "Leje:  80", Color.WHITE, Color.BLACK);
        fields[28] = new GUI_Brewery("default", "Carlsberg", "kr. 3.000", "Carlsberg øl", "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[29] = new GUI_Street("Østergade", "kr. 5.600", "Østergade", "Leje:  85", Color.WHITE, Color.BLACK);
        fields[30] = new GUI_Jail("default", "Gå i fængsel", "Gå i fængsel", "De fængsles\nSlå to ens for at komme ud", new Color(125, 125, 125), Color.BLACK);
        fields[31] = new GUI_Street("Amagertorv", "kr. 6.000", "Amagertorv", "Leje:  95", new Color(255, 255, 50), Color.BLACK);
        fields[32] = new GUI_Street("Vimmel-\nskaftet", "kr. 6.000", "Vimmelskaftet", "Leje:  95", new Color(255, 255, 50), Color.BLACK);
        fields[33] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(0, 0, 0), Color.WHITE);
        fields[34] = new GUI_Street("Nygade", "kr. 6.400", "Nygade", "Leje:  100", new Color(255, 255, 50), Color.BLACK);
        fields[35] = new GUI_Shipping("default", "Scandlines", "kr. 4.000", "Scandlines", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[36] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.",new Color(0, 0, 0), Color.WHITE);
        fields[37] = new GUI_Street("Frederiks-\nberggade", "kr. 7.000", "Frederiksberggade", "Leje:  120", new Color(150, 60, 150), Color.BLACK);
        fields[38] = new GUI_Tax("Ekstra-\nordinær\nstatsskat", "Betal 2000", "Betal ekstraordinær\nstatsskat: kr. 100,-",new Color(20,82,226), Color.BLACK);
        fields[39] = new GUI_Street("Rådhuspladsen", "kr. 8.000", "Rådhuspladsen", "Leje:  150", new Color(150, 60, 150), Color.BLACK);
        return fields;
    }


    public void CreateStreets(List<Player> players, GUIController controller) { // This constructor is used to decide the buyprice and rentprice throughtout the game for each fields
        squares[0] = new StartField("START");
        squares[1] = new OwnedProperty("Rødovrevej",1200, 1,controller);
        squares[2] = new ChanceField("Prøv Lykken", players, controller);
        squares[3] = new OwnedProperty("Hvidovrevej", 1200, 1,controller);
        squares[4] = new IncomeTaxField("Betal Indkomst-skat", 4000, controller);
        squares[5] = new OwnedProperty("Scandlines", 4000, 1,controller);
        squares[6] = new OwnedProperty("Roskildevej", 2000, 1,controller);
        squares[7] = new ChanceField("Prøv Lykken", players,controller);
        squares[8] = new OwnedProperty("Valbylanggade", 2000, 1,controller);
        squares[9] = new OwnedProperty("Allégade", 2400, 1,controller);

        squares[10] = new VisitJailField("På fængsels-besøg");

        squares[11] = new OwnedProperty("Frederiksbergs Allé", 2800, 1,controller);
        squares[12] = new OwnedProperty("Tuborg Squash",3000, 2,controller);
        squares[13] = new OwnedProperty("Bülowsvej", 2800, 1,controller);
        squares[14] = new OwnedProperty("Gl. Kongevej", 3200, 1,controller);
        squares[15] = new OwnedProperty("Mols linien",4000, 2,controller);
        squares[16] = new OwnedProperty("Bernstorffsvej", 3600, 1,controller);
        squares[17] = new ChanceField("Prøv Lykken", players,controller);
        squares[18] = new OwnedProperty("Hellerupvej", 3600, 1,controller);
        squares[19] = new OwnedProperty("Strandvejen", 4000, 2,controller);
        squares[20] = new ChanceField("Parkering", players, controller);
        squares[21] = new OwnedProperty("Trianglen", 4000, 1,controller);
        squares[22] = new ChanceField("Prøv Lykken", players,controller);
        squares[23] = new OwnedProperty("Østerbrogade", 4000, 1,controller);
        squares[24] = new OwnedProperty("Grønningen", 4600, 1,controller);
        squares[25] = new OwnedProperty("Scandlines", 4000, 1,controller);
        squares[26] = new OwnedProperty("Bredgade", 5200, 1,controller);
        squares[27] = new OwnedProperty("Kgs. Nytorv", 5200, 2,controller);
        squares[28] = new OwnedProperty("Coca Cola", 3000, 1,controller);
        squares[29] = new OwnedProperty("Østergade", 5600, 2,controller);

        squares[30] = new JailField("JAIL",controller);

        squares[31] = new OwnedProperty("Amagertorv", 6000, 2,controller);
        squares[32] = new OwnedProperty("Vimmelskaftet", 6000, 2,controller);
        squares[33] = new ChanceField("Prøv Lykken", players,controller);
        squares[34] = new OwnedProperty("Nygade", 6400, 2,controller);
        squares[35] = new OwnedProperty("Scandlines", 4000, 2,controller);
        squares[36] = new ChanceField("Prøv Lykken", players,controller);
        squares[37] = new OwnedProperty("Frederiksberggade", 7000, 2,controller);
        squares[38] = new ExtraordinaryTaxField("Ekstraordinær statsskat", 2000, controller);
        squares[39] = new OwnedProperty("Rådhuspladsen", 8000, 2,controller);

    }
}




