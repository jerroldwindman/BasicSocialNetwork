
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
 * A class representing the database of account of the Bitter social
 * network. These accounts are stored and accessed through
 * a hashmap called map.
 */

import java.io.Serializable;
import java.util.HashMap;

public class AccountDatabase implements Serializable{
	HashMap<String, Account> map = new HashMap<String, Account>();
	
	/**
	 * This method adds an account to the AccountDatabase.
	 * @param email
	 * The email used as a key for the AccountDatabase
	 * @param account
	 * The account to be added to the AccountDatabase at the position
	 * determined by the email key
	 * <dt><b>Preconditions:</b><dd>
	 * The email is not null and the email does not map to an account already
	 * existing in the database
	 * @throws IllegalArgumentException
	 * If the email is null or the email maps to an account in the database, the
	 * exception is thrown.
	 */
	public void addAccount(String email, Account account){
		if(email != null && map.get(email) == null){
			map.put(email, account);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * A getter method for an account in the AccountDatabase
	 * @param email
	 * The email used as a key for the AccountDatabase
	 * @return
	 * The account at the position mapped by the email
	 */
	public Account getAccountInformation(String email){
		return map.get(email);
	}
	
	/**
	 * A method to remove an account from the account database
	 * @param email
	 * The email used as a key for the AccountDatabase
	 * <dt><b>Preconditions:</b><dd>
	 * The email is not null and the email maps to an account already
	 * existing in the database
	 * @throws IllegalArgumentException
	 * If the email is null or the email does not map to an account in the database, the
	 * exception is thrown.
	 */
	public void removeAccount(String email){
		if(email != null && map.containsKey(email) != false ){
			map.remove(email);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	
	
}
