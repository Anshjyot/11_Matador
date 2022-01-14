package game;

import GUI.GUIController;
import gui_fields.GUI_Car;

public class Player {
    public GUIController guiController; // This class creates the player which will be used in the GUI, a player with an account.

    private Account account;
    private String PlayerName;
    private int PlayerAge;
    private int currentposition;
    int index;
    public boolean isInJail=false;
    public int roundsInJail = 0;

    public Player(String PlayerName, int PlayerAge, int balance, int Startfield, int index) {
        this.setPlayerName(PlayerName);
        this.setPlayerAge(PlayerAge);
        this.setAccount(new Account(balance));
        this.setPosition(Startfield);
        this.index = index;
    }

    public Player() { }

    public void setPlayerName(String PlayerName) {
        this.PlayerName = PlayerName;
    }

    public void setPlayerAge(int PlayerAge) {
        this.PlayerAge = PlayerAge;
    }
    public String getPlayerName() {
        return PlayerName;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public Account getAccount() {
        return account;
    }

    public void setPosition(int currentposition) {
        this.currentposition = currentposition;
    }
    public int getPosition() {
        return currentposition;
    }

    public int getIndex() {
        return index;
    }

    //Bruges ikke lige nu, bruges til test af JailField
     /*public void printStatus(){
        System.out.println(this.PlayerName);
        System.out.println(this.currentposition);
        System.out.println(this.account.getBalance()); } */
    }

