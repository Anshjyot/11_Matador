package fields;

import java.awt.Color;

import GUI.GUIController;
import controller.MatadorController;
import game.Cup;
import game.Player;
import gui_fields.*;
import gui_main.GUI;

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
    //Skal returnere en poperty (behøves vel ikke?)

    protected GUI gui;
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
        squares[5] = new FerryField("Scandlines", 4000, 500, 1000, 2000, 4000);
        squares[6] = new StreetField("Roskildevej", 2000, 1000, new int[]{100, 600, 1800, 5400, 8000, 11000}, new Color(255, 135, 120), 6);
        squares[7] = new ChanceField("Prøv Lykken");
        squares[8] = new StreetField("Valbylanggade", 2000, 1000, new int[]{100, 600, 1800, 5400, 8000, 11000}, new Color(255, 135, 120), 8);
        squares[9] = new StreetField("Allégade", 2400, 1000, new int[]{150, 800, 2000, 6000, 9000, 12000}, new Color(255, 135, 120), 9);

        squares[10] = new VisitJailField("På fængsels-besøg");

        squares[11] = new StreetField("Frederiksbergs Allé", 2800, 2000, new int[]{200, 1000, 3000, 9000, 12500, 15000}, new Color(18, 253, 0), 11);
        squares[12] = new BreweryField("Tuborg", 3000, 100, 200);
        squares[13] = new StreetField("Bülowsvej", 2800, 2000, new int[]{200, 1000, 3000, 9000, 12500, 15000}, new Color(18, 253, 0), 13);
        squares[14] = new StreetField("Gl. Kongevej", 3200, 2000, new int[]{250, 1250, 3750, 10000, 14000, 18000}, new Color(18, 253, 0), 14);
        squares[15] = new FerryField("Mols linien", 4000, 500, 1000, 2000, 4000);
        squares[16] = new StreetField("Bernstorffsvej", 3600, 2000, new int[]{300, 1400, 4000, 11000, 15000, 19000}, new Color(153, 153, 153), 16);
        squares[17] = new ChanceField("Prøv Lykken");
        squares[18] = new StreetField("Hellerupvej", 3600, 2000, new int[]{300, 1400, 4000, 11000, 15000, 19000}, new Color(153, 153, 153), 18);
        squares[19] = new StreetField("Strandvejen", 4000, 2000, new int[]{350, 1600, 4400, 12000, 16000, 20000}, new Color(153, 153, 153), 19);
        squares[20] = new ParkingField("Parkering");
        squares[21] = new StreetField("Trianglen", 4000, 3000, new int[]{350, 1800, 5000, 14000, 17500, 21000}, Color.RED, 21);
        squares[22] = new ChanceField("Prøv Lykken");
        squares[23] = new StreetField("Østerbrogade", 4000, 3000, new int[]{350, 1800, 5000, 14000, 17500, 21000}, Color.RED, 23);
        squares[24] = new StreetField("Grønningen", 4600, 3000, new int[]{400, 2000, 6000, 15000, 18500, 22000}, Color.RED, 24);
        squares[25] = new FerryField("Scandlines", 4000, 500, 1000, 2000, 4000);
        squares[26] = new StreetField("Bredgade", 5200, 3000, new int[]{450, 2200, 6600, 16000, 19500, 23000}, Color.WHITE, 26);
        squares[27] = new StreetField("Kgs. Nytorv", 5200, 3000, new int[]{450, 2200, 6600, 16000, 19500, 23000}, Color.WHITE, 27);
        squares[28] = new BreweryField("Carlsberg", 3000, 100, 200);
        squares[29] = new StreetField("Østergade", 5600, 3000, new int[]{500, 2400, 7200, 17000, 20500, 24000}, Color.WHITE, 28);

        squares[30] = new JailField("JAIL");

        squares[31] = new StreetField("Amagertorv", 6000, 4000, new int[]{550, 2600, 7800, 18000, 22000, 25000}, new Color(255, 255, 50), 30);
        squares[32] = new StreetField("Vimmelskaftet", 6000, 4000, new int[]{550, 2600, 7800, 18000, 22000, 25000}, new Color(255, 255, 50), 31);
        squares[33] = new ChanceField("Prøv Lykken");
        squares[34] = new StreetField("Nygade", 6400, 4000, new int[]{600, 3000, 9000, 20000, 24000, 28000}, new Color(255, 255, 50), 33);
        squares[35] = new FerryField("Scandlines", 4000, 500, 1000, 2000, 4000);
        squares[36] = new ChanceField("Prøv Lykken");
        squares[37] = new StreetField("Frederiksberggade", 7000, 4000, new int[]{700, 3500, 10000, 22000, 26000, 30000}, new Color(150, 60, 150), 36);
        squares[38] = new ExtraordinaryTaxField("Ekstraordinær statsskat", 2000);
        squares[39] = new StreetField("Rådhuspladsen", 8000, 4000, new int[]{1000, 4000, 12000, 28000, 34000, 40000}, new Color(150, 60, 150), 38);

    }

    public boolean SameOwnerColor(StreetField property) {
        int colorAmount = 0;
        for (Field squares : squares) {
            if (squares instanceof StreetField) {
                StreetField currentSquare = (StreetField) squares;
                if (currentSquare.getColor().equals(property.getColor()) && getOwnerName(property).equals(getOwnerName(currentSquare))) {
                    colorAmount++;
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

    int price;
    int rent0;
    int rent1;
    int rent2;
    int rent3;
    GUIController controller;

    public void arrivedFerry(Player player, Property property) { // This class creates the ownership for the fields, you can buy and rent fields.
        arrivedAtProperty(player, property);
    }

    public void buyProperty(Player player, Property property){
        player.getAccount().setBalance(player.getAccount().getBalance() - property.price);
        property.setOwner(player.getIndex());
        controller.showMessage(player.getPlayerName() + " bought " + property.fieldName + " for " + price + " dkk ");
    }

    public void rentProperty(Player player,Property property){
        player.getAccount().setBalance(player.getAccount().getBalance() - property.getRent());

        Player owner = MatadorController.getInstance().getPlayer(property.getOwner());
        owner.getAccount().setBalance(owner.getAccount().getBalance() + property.getRent());

        controller.showMessage(player.getPlayerName() + " rented " + owner.getPlayerName() + "'s" + " property: " + property.fieldName + " for " + rent0 + " dkk ");
    }

    public void arrivedAtProperty(Player player, Property property){
        if (property.isOwned()) {
            rentProperty(player, property);
        } else {
            buyProperty(player,property);
        }
    }

    public void arrivedBrewery(Player player, Property property) { // This class creates the ownership for the fields, you can buy and rent fields.
        arrivedAtProperty(player, property);
    }

    int[] rent;
    int house;
    int index;
    Color color;

    public void arrivedOwnedProperty(Player player, Property property) { // This class creates the ownership for the fields, you can buy and rent fields.
        arrivedAtProperty(player,property);
    }

    public String getOwnerName(Property property) {
        Player owner = MatadorController.getInstance().getPlayer(property.getOwner());
        return owner.getPlayerName();
    }

    //check if there is an owner
    public boolean isThereAnOwner(Property property) {
        if (property.isOwned()) {
            return true;
        } else {
            return false;
        }
    }


    public Color getColor() {
        return color;
    }

    public int getIndex() {
        return index;
    }

    /*public void ArrivedJail(Player p) { // This field places the player back to VisitJailSquare field.
        controller.showMessage("JAIL TIME");
        controller.removeCar(p.getPosition(), p.getIndex());
        p.setPosition(p.getPosition() - 16);
        controller.addCar(p.getPosition(), p.getIndex()); */

    public JailField getJailField(){
        return (JailField) squares[30];
    }

    public void fieldOutcome(Player player){
        Field currentField = squares[player.getPosition()];

        if (currentField instanceof Property){
            Property field = ((Property) currentField);
            //when landed on field is owned
            if (field.isOwned()){
                Player owner = MatadorController.getInstance().getPlayer(field.getOwner());
                if (player == owner){
                    controller.showMessage("Oh, you've already bought this property... How nice it is :)");
                }
                else{
                    //rent need to be updated for multiple types of properties.
                    rentProperty(player,field);
                }
            }
            //when landed on field is not owned.
            else{
                if(controller.wannaBuy()){
                    buyProperty(player,field);
                }
            }
        }
        if(currentField instanceof ExtraordinaryTaxField){
            controller.showMessage("Betal Extraordinær-skat");
            player.getAccount().setBalance(player.getAccount().getBalance() - 2000);
        }
        if(currentField instanceof IncomeTaxField){
            controller.showMessage("Betal Indkomst-skat");
            player.getAccount().setBalance(player.getAccount().getBalance() - 4000);
        }
        if(currentField instanceof VisitJailField){
            if(!player.isInJail){
                controller.showMessage("Welcome to prison, say hi to your inmates. Relax, You're just on a visit");}
        }
        if(currentField instanceof JailField){
            arrivedAtJail(player);
        }
        if(currentField instanceof ParkingField){
            controller.showMessage("You found a legendary free parking spot");
        }
        if(currentField instanceof StartField){
            controller.showMessage("You landed on start, receive 4000$, for staying alive");
        }
        if(currentField instanceof ChanceField){

        }
        controller.okButton();

    }
    public void getOwner(){

    }
    public void arrivedAtJail(Player p) { // This field places the player back to VisitJailSquare field.
        controller.showMessage("JAIL TIME! You have been moved to jail.");
        p.isInJail = true;
        controller.removeCar(p.getPosition(), p.getIndex());
        p.setPosition(p.getPosition() - 20);
        controller.addCar(p.getPosition(), p.getIndex());
        //GetOutOfJail(p);
    }
    public void GetOutOfJail(Player player) {
        player.roundsInJail++;
        if (player.roundsInJail > 3) {
            //The player should still pay 1000$ - dont know if this feature works totally correct?
            player.getAccount().setBalance(player.getAccount().getBalance() - 1000);
            player.isInJail = false;
            controller.showMessage("You have been in jail for 3 rounds, pay 1000$ and get out of here!");
            cup.CupRoll();
            controller.askForDice();
            controller.setDice(cup.GetDice1Value(), cup.GetDice2Value());
        } else {
        //The Player can only get out of Jail, if one of the three methods has happened
            String option = controller.getOutOfJail();
            switch (option) {
                case "Pay 1000$":
                    //Pay1000$, check if account>=1000
                    if (player.getAccount().getBalance() >= 1000) {
                        player.getAccount().setBalance(player.getAccount().getBalance() - 1000);
                        controller.showMessage("You paid yourself out of jail");
                        player.isInJail = false;
                    }
                    break;
                case "Roll the dice":
                    //Roll the dice, and have a chance to get out of jail for free
                    controller.showMessage("Roll the dice, and have a chance to get out of jail for free");
                    cup.CupRoll();
                    controller.askForDice();
                    controller.setDice(cup.GetDice1Value(), cup.GetDice2Value());
                    if (cup.GetDice1Value() == cup.GetDice2Value()) {
                        controller.showMessage("You got lucky, you got a pair and get an extra throw");
                        player.isInJail = false;

                    }
                    break;
                /*case "Use a Get-Out-Of-Jail Card":
                    if(chancecard==true) {
                        player.isInJail = false;
                    }
                    break;
               /* default:
                    System.out.println(option);
            }
            player.printStatus(); */
            }
        }
    }
}




