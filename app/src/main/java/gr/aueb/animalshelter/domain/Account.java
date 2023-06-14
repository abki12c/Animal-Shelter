package gr.aueb.animalshelter.domain;

public class Account {
	//comment
	private String username;
	private String password;
	private final int accountID;
	private static int lastAccountID = 0;
	

	
	public Account(String userName, String password){
        this.accountID=NextAccountID();
        this.username = userName;
        this.password = password;
    }

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountID() {
        return accountID;
    }

    public static int NextAccountID() {
        return ++lastAccountID;
    }
}
