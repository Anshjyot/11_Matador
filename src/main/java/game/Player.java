package game;

public class Player { // This class creates the player which will be used in the GUI, a player with an account.

    private Account account;
    private String PlayerName;
    private int currentposition;
    int index;

    public Player(String PlayerName, int balance, int Startfield, int index) {
        this.setPlayerName(PlayerName);
        this.setAccount(new Account(balance));
        this.setPosition(Startfield);
        this.index = index;
    }

    public Player() { }

    public void setPlayerName(String PlayerName) {
        this.PlayerName = PlayerName;
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
}
