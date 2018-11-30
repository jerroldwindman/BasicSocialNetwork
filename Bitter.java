
/**
 * Jerrold Windman 
 * (109070054)
 * Homework #6
 * CSE 214 Spring 2017 Recitation 14
 * TAs: Tayo Amuneke, Yiwen Wang
 * Grading TA: Anand Aiyer
 *
 */


/**
 * A class representing the Bitter social network.
 * Every Bitter object has a UserDatabase and an AccountDatabase.
 * Only one Bitter object needs to be made for the whole social network.
 */
import java.io.Serializable;

public class Bitter implements Serializable{
	private final UserDatabase users = new UserDatabase();
	private final AccountDatabase accounts = new AccountDatabase();
	
	/**
	 * This method adds an account to the AccountDatabase and a user to the user database 
	 * using the email key.
	 * @param email
	 * The email used as a key for the AccountDatabase and UserDatabase
	 * @param account
	 * The account to be added to the AccountDatabase at the position
	 * determined by the email key
	 * @param user
	 * <dt><b>Preconditions:</b><dd>
	 * The email is not null and the email does not map to an account already
	 * existing in the database
	 * @throws IllegalArgumentException
	 * If the email is null or the email maps to an account in the database, the
	 * exception is thrown.
	 */ 
	
	public void addUser(String email, User user, Account account){
		if(user != null && account != null && users.getUser(email) == null && 
				accounts.getAccountInformation(email) == null){
			users.addUser(email, user);
			accounts.addAccount(email, account);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	/**
	 * This method removes a User and Account from the respective databases
	 * using the email as key
	 * @param email
	 * The keys for the databases
	 * <dt><b>Preconditions:</b><dd>
	 * The email is not null and the email maps to an account and user already
	 * existing in the database
	 * @throws IllegalArgumentException
	 * If the email is null or the email does not map to an account or user in the database, the
	 * exception is thrown.
	 */
	public void removeUser(String email){
		if(email != null && users.getUser(email) != null && accounts.getAccountInformation(email) != null){
			users.removeUser(email);
			accounts.removeAccount(email);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * A getter method for the UserDatabase
	 * @return
	 * the UserDatabase
	 */
	public UserDatabase getUserDB(){
		return users;
	}
	
	/**
	 * A getter method for the AccountDatbase
	 * @return
	 * The AccountDatabase
	 */
	public AccountDatabase getAcctDB(){
		return accounts;
	}
	
	
	
}
