package controller;

import java.awt.Color;
import GUI.GUIController;
import fields.*;
import game.Cup;
import game.Player;
import gui_fields.*;
import language.Language;

public class FieldController {
    GUI_Field[] fields = new GUI_Field[40];
    Field[] squares = new Field[40];
    private Cup cup = new Cup();
    public FieldController() {
        CreateStreets();
    }
    public GUI_Field getField(int i) {
        return fields[i];
    }

    private static FieldController instance;

    public static FieldController getInstance() {
        if (instance == null) {
            instance = new FieldController();
        }
        return instance;
    }

    public GUI_Field[] BoardCreator() {
        fields[0] = new GUI_Start("Start", "Modtag: 4.000", "Modtag kr. 4.000,-\nnår de passerer start", Color.RED, Color.BLACK);
        fields[1] = new GUI_Street("Rødovrevej", "kr. 1200", "Rødovrevej", "Leje:  20", new Color(75, 155, 225), Color.BLACK);
        fields[2] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(0, 0, 0), Color.WHITE);
        fields[3] = new GUI_Street("Hvidovrevej", "kr. 1200", "Hvidovrevej", "Leje:  20", new Color(75, 155, 225), Color.BLACK);
        fields[4] = new GUI_Tax("Betal\nindkomst-\nskat", "10% el. 4.000,-", "Betal indkomstskat\n10% eller kr. 4.000,-", new Color(20, 82, 226), Color.BLACK);
        fields[5] = new GUI_Shipping("default", "Scandlines", "kr. 4.000", "Scandlines", "Leje:  75", Color.WHITE, Color.BLACK);
        fields[6] = new GUI_Street("Roskildevej", "kr. 2.000", "Roskildevej", "Leje:  40", new Color(255, 135, 120), Color.BLACK);
        fields[7] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(0, 0, 0), Color.WHITE);
        fields[8] = new GUI_Street("Valby\nLanggade", "kr. 2.000", "Valby Langgade", "Leje:  40", new Color(255, 135, 120), Color.BLACK);
        fields[9] = new GUI_Street("Allégade", "kr. 2.400", "Allégade", "Leje:  45", new Color(255, 135, 120), Color.BLACK);
        fields[10] = new GUI_Jail("default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK);
        fields[11] = new GUI_Street("Frederiks-\nberg Allé", "kr. 2.800", "Frederiksberg Allé", "Leje:  50", new Color(18, 253, 0), Color.BLACK);
        fields[12] = new GUI_Brewery("default", "Tuborg", "kr. 3.000", "Tuborg øl", "10 x [Terningslag]", Color.BLACK, Color.WHITE);
        fields[13] = new GUI_Street("Bülowsvej", "kr. 2.800", "Bülowsvej", "Leje:  50", new Color(18, 253, 0), Color.BLACK);
        fields[14] = new GUI_Street("Gammel Kongevej", "kr. 3.200", "Gammel Kongevej", "Leje:  50", new Color(18, 253, 0), Color.BLACK);
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
        fields[36] = new GUI_Chance("?", "Prøv lykken", "Ta' et chancekort.", new Color(0, 0, 0), Color.WHITE);
        fields[37] = new GUI_Street("Frederiks-\nberggade", "kr. 7.000", "Frederiksberggade", "Leje:  120", new Color(150, 60, 150), Color.BLACK);
        fields[38] = new GUI_Tax("Ekstra-\nordinær\nstatsskat", "Betal 2000", "Betal ekstraordinær\nstatsskat: kr. 100,-", new Color(20, 82, 226), Color.BLACK);
        fields[39] = new GUI_Street("Rådhuspladsen", "kr. 8.000", "Rådhuspladsen", "Leje:  150", new Color(150, 60, 150), Color.BLACK);
        return fields;
    }

    public void CreateStreets() { // This constructor is used to decide the buyprice and rentprice throughtout the game for each fields
        squares[0] = new StartField("START");
        squares[1] = new StreetField("Rødovrevej", 1200, 1000, new int[]{50, 250, 750, 2250, 4000, 6000}, new Color(75, 155, 225), 1);
        squares[2] = new ChanceField("Prøv Lykken");
        squares[3] = new StreetField("Hvidovrevej", 1200, 1000, new int[]{50, 250, 400, 750, 2250, 6000}, new Color(75, 155, 225), 3);
        squares[4] = new IncomeTaxField("Betal Indkomst-skat", 4000);
        squares[5] = new FerryField("Scandlines", 4000, 500, 1000, 2000, 4000,5);
        squares[6] = new StreetField("Roskildevej", 2000, 1000, new int[]{100, 600, 1800, 5400, 8000, 11000}, new Color(255, 135, 120), 6);
        squares[7] = new ChanceField("Prøv Lykken");
        squares[8] = new StreetField("Valbylanggade", 2000, 1000, new int[]{100, 600, 1800, 5400, 8000, 11000}, new Color(255, 135, 120), 8);
        squares[9] = new StreetField("Allégade", 2400, 1000, new int[]{150, 800, 2000, 6000, 9000, 12000}, new Color(255, 135, 120), 9);

        squares[10] = new VisitJailField("På fængsels-besøg");

        squares[11] = new StreetField("Frederiksbergs Allé", 2800, 2000, new int[]{200, 1000, 3000, 9000, 12500, 15000}, new Color(18, 253, 0), 11);
        squares[12] = new BreweryField("Tuborg", 3000, 100, 200,12);
        squares[13] = new StreetField("Bülowsvej", 2800, 2000, new int[]{200, 1000, 3000, 9000, 12500, 15000}, new Color(18, 253, 0), 13);
        squares[14] = new StreetField("Gl. Kongevej", 3200, 2000, new int[]{250, 1250, 3750, 10000, 14000, 18000}, new Color(18, 253, 0), 14);
        squares[15] = new FerryField("Mols linien", 4000, 500, 1000, 2000, 4000,15);
        squares[16] = new StreetField("Bernstorffsvej", 3600, 2000, new int[]{300, 1400, 4000, 11000, 15000, 19000}, new Color(153, 153, 153), 16);
        squares[17] = new ChanceField("Prøv Lykken");
        squares[18] = new StreetField("Hellerupvej", 3600, 2000, new int[]{300, 1400, 4000, 11000, 15000, 19000}, new Color(153, 153, 153), 18);
        squares[19] = new StreetField("Strandvejen", 4000, 2000, new int[]{350, 1600, 4400, 12000, 16000, 20000}, new Color(153, 153, 153), 19);
        squares[20] = new ParkingField("Parkering");
        squares[21] = new StreetField("Trianglen", 4000, 3000, new int[]{350, 1800, 5000, 14000, 17500, 21000}, Color.RED, 21);
        squares[22] = new ChanceField("Prøv Lykken");
        squares[23] = new StreetField("Østerbrogade", 4000, 3000, new int[]{350, 1800, 5000, 14000, 17500, 21000}, Color.RED, 23);
        squares[24] = new StreetField("Grønningen", 4600, 3000, new int[]{400, 2000, 6000, 15000, 18500, 22000}, Color.RED, 24);
        squares[25] = new FerryField("Scandlines", 4000, 500, 1000, 2000, 4000,25);
        squares[26] = new StreetField("Bredgade", 5200, 3000, new int[]{450, 2200, 6600, 16000, 19500, 23000}, Color.WHITE, 26);
        squares[27] = new StreetField("Kgs. Nytorv", 5200, 3000, new int[]{450, 2200, 6600, 16000, 19500, 23000}, Color.WHITE, 27);
        squares[28] = new BreweryField("Carlsberg", 3000, 100, 200,28);
        squares[29] = new StreetField("Østergade", 5600, 3000, new int[]{500, 2400, 7200, 17000, 20500, 24000}, Color.WHITE, 29);

        squares[30] = new JailField("JAIL");

        squares[31] = new StreetField("Amagertorv", 6000, 4000, new int[]{550, 2600, 7800, 18000, 22000, 25000}, new Color(255, 255, 50), 31);
        squares[32] = new StreetField("Vimmelskaftet", 6000, 4000, new int[]{550, 2600, 7800, 18000, 22000, 25000}, new Color(255, 255, 50), 32);
        squares[33] = new ChanceField("Prøv Lykken");
        squares[34] = new StreetField("Nygade", 6400, 4000, new int[]{600, 3000, 9000, 20000, 24000, 28000}, new Color(255, 255, 50), 34);
        squares[35] = new FerryField("Scandlines", 4000, 500, 1000, 2000, 4000,35);
        squares[36] = new ChanceField("Prøv Lykken");
        squares[37] = new StreetField("Frederiksberggade", 7000, 4000, new int[]{700, 3500, 10000, 22000, 26000, 30000}, new Color(150, 60, 150), 37);
        squares[38] = new ExtraordinaryTaxField("Ekstraordinær statsskat", 2000);
        squares[39] = new StreetField("Rådhuspladsen", 8000, 4000, new int[]{1000, 4000, 12000, 28000, 34000, 40000}, new Color(150, 60, 150), 39);

    }
    
    GUIController guiInstance = GUIController.getInstance();
    MatadorController matadorInstance = MatadorController.getInstance();
    
    public boolean SameOwnerColor(StreetField property) {
        int colorAmount = 0;
        for (Field squares : squares) {
            if (squares instanceof StreetField) {
                StreetField currentSquare = (StreetField) squares;
                if(currentSquare.isOwned()){
                    if (currentSquare.getColor().equals(property.getColor()) && getOwnerName(property).equals(getOwnerName(currentSquare))) {
                    colorAmount++;
                    }
                }
            }
        }
        if (property.getColor().equals(new Color(150, 60, 150))) {
            if (colorAmount == 2) {
                return true;
            }
        }
        if (property.getColor().equals(new Color(75, 155, 225))) {
            if (colorAmount == 2) {
                return true;
            }
        }
        if (colorAmount == 3) {
            return true;
        } else {
            return false;
        }
    }

    public void buyProperty(Player player, Property property){
        player.getAccount().setBalance(player.getAccount().getBalance() - property.getPrice());
        property.setOwner(player.getIndex());
        guiInstance.setNewBalance(player.getIndex(),player.getAccount().getBalance());
        guiInstance.setBorderColors(player,property);
        Language.BuyDeedText(property,player);
    }

    public void rentProperty(Player player,Property property){
        Player owner = matadorInstance.getPlayer(property.getOwner());

        if(property instanceof StreetField || property instanceof FerryField){
            player.getAccount().setBalance(player.getAccount().getBalance() - property.getRent());
            owner.getAccount().setBalance(owner.getAccount().getBalance() + property.getRent());
            Language.ArrivedText(property, player, owner);
        }
        else if(property instanceof BreweryField){
            Language.breweryText1(owner);
            cup.CupRoll();
            guiInstance.askForDice();
            guiInstance.setDice(cup.GetDice1Value(), cup.GetDice2Value());
            int rent = (cup.GetDice1Value()+ cup.GetDice2Value())*100;
            player.getAccount().setBalance(player.getAccount().getBalance() - rent);
            owner.getAccount().setBalance(owner.getAccount().getBalance() + rent);
            Language.breweryText2(owner, rent);
        }
        guiInstance.setNewBalance(player.getIndex(),player.getAccount().getBalance());
        guiInstance.setNewBalance(owner.getIndex(),owner.getAccount().getBalance());
    }

    public int getNoStreets(Player player){
        int noStreets = 0;
        for (Field squares : squares) {
            if (squares instanceof StreetField) {
                StreetField currentSquare = (StreetField) squares;
                if (currentSquare.getOwner() == player.getIndex()) {
                    noStreets++;
                }
            }
        }
        return noStreets;
    }

    public String[] getPropertyList(Player player){
        int noStreets = getNoStreets(player);
        String[] propertyList = new String[noStreets];

        noStreets = 0;

        for (Field squares : squares) {
            if (squares instanceof StreetField) {
                StreetField currentSquare = (StreetField) squares;
                boolean canAffordHouse = player.getAccount().getBalance() >= currentSquare.getHouseprice();
                if (currentSquare.getOwner() == player.getIndex() && canAffordHouse) {
                    propertyList[noStreets] = currentSquare.fieldName;
                    noStreets++;
                }
            }
        }
        return propertyList;
    }

    public void buyHouse(Player player){
        String chosenStreet = guiInstance.chooseStreet(player);

        for (Field squares : squares){
            if (chosenStreet.equals(squares.getFieldName())) {
                StreetField currentStreet = (StreetField) squares;
                if (currentStreet.getNoOfHouses() < 4) {
                    currentStreet.addHouse();
                    guiInstance.addHouse(currentStreet);
                    player.getAccount().setBalance(player.getAccount().getBalance() - currentStreet.getHouseprice());
                }
                else {Language.buyHouseText();}
            }
        }
    }
    public void choosePlayerOption(Player player) {
        if (FieldController.getInstance().getPropertyList(player).length != 0) {
            if (guiInstance.playerChoice().equals("Buy House")) {
                buyHouse(player);
            }
        }
    }

    public String getOwnerName(Property property) {
        Player owner = matadorInstance.getPlayer(property.getOwner());
        return owner.getPlayerName();
    }

    public void fieldOutcome(Player player){
        Field currentField = squares[player.getPosition()];

        if (currentField instanceof Property){
            Property field = ((Property) currentField);
            //when landed on field is owned
            if (field.isOwned()){
                int owner = field.getOwner();

                if (player.getIndex() == owner){
                    Language.AlreadyBought();
                }
                else{
                    //rent need to be updated for multiple types of properties.
                    rentProperty(player,field);
                }
            }
            //when landed on field is not owned.
            else{
                if(guiInstance.wannaBuy()){
                    buyProperty(player,field);
                }
            }
        }
        else if (currentField instanceof ExtraordinaryTaxField){
            Language.ExtraordinaryTaxFieldText();
            int tax = ((ExtraordinaryTaxField) currentField).getTax();
            player.getAccount().setBalance(player.getAccount().getBalance() - tax);
        }
        else if(currentField instanceof IncomeTaxField){
            Language.IncomeTaxFieldText();
            int tax = ((IncomeTaxField) currentField).getTax();
            player.getAccount().setBalance(player.getAccount().getBalance() - tax);
        }
        else if(currentField instanceof VisitJailField){
            if(!player.isInJail){
                Language.ArrivedVisitJailFieldText(); }
        }
        else if(currentField instanceof JailField){
            arrivedAtJail(player);
        }
        else if(currentField instanceof ParkingField){
            Language.ArrivedParkingFieldText();
        }
        else if(currentField instanceof StartField){
            Language.ArrivedStartFieldText();
        }
        else if(currentField instanceof ChanceField){
            ChanceCardController.getInstance().draw(player);
        }
        guiInstance.okButton();

    }

    public void startField(Player player) { // You get 4.000 dkk when you pass the Start-field
        player.getAccount().setBalance(player.getAccount().getBalance() + 4000);
        guiInstance.setNewBalance(player.getIndex(),player.getAccount().getBalance());
    }

    public void arrivedAtJail(Player p) { // This field places the player back to VisitJailSquare field.
        Language.ArrivedJailFieldText1();
        p.isInJail = true;
        guiInstance.removeCar(p.getPosition(), p.getIndex());
        p.setPosition(p.getPosition() - 20);
        guiInstance.addCar(p.getPosition(), p.getIndex());
        //GetOutOfJail(p);
    }
    public void GetOutOfJail(Player player) {
        player.roundsInJail++;
        if (player.roundsInJail > 3) {
            //The player should still pay 1000$ - dont know if this feature works totally correct?
            player.getAccount().setBalance(player.getAccount().getBalance() - 1000);
            player.isInJail = false;
            Language.ArrivedJailFieldText2();
            cup.CupRoll();
            guiInstance.askForDice();
            guiInstance.setDice(cup.GetDice1Value(), cup.GetDice2Value());

            //rounds in jail is reset.
            player.roundsInJail = 0;

        } else {
        //The Player can only get out of Jail, if one of the three methods has happened
            String option = guiInstance.getOutOfJail();
            switch (option) {
                case "Pay 1000$":
                    //Pay1000$, check if account>=1000
                    if (player.getAccount().getBalance() >= 1000) {
                        player.getAccount().setBalance(player.getAccount().getBalance() - 1000);
                        Language.ArrivedJailFieldText3();
                        player.isInJail = false;
                    }
                    break;
                case "Roll the dice":
                    //Roll the dice, and have a chance to get out of jail for free
                    Language.ArrivedJailFieldText4();
                    cup.CupRoll();
                    guiInstance.askForDice();
                    guiInstance.setDice(cup.GetDice1Value(), cup.GetDice2Value());
                    if (cup.GetDice1Value() == cup.GetDice2Value()) {
                        Language.ArrivedJailFieldText5();
                        player.isInJail = false;

                    }
                    break;

            }
        }
    }
}




