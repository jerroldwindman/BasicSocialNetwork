
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
 * This class is a wrapper class for the password of an account on the Bitter
 * social network. A password object simply contains the String representation
 * of the password.
 */
import java.io.Serializable;

public class Password implements Serializable{
	private String password;
	
	/**
	 * The constructor for a password.
	 * @param initPassword
	 * The string to be wrapped in a Password object
	 * <dt><b>Preconditions:</b><dd>
	 * The String passed into the method must have at least one upper case and one lower case letter,
	 * one special character, and one number.
	 * @throws IllegalArgumentException
	 * If the String passed in does not meet the security requirements, an error is thrown. 
	 */
	public Password(String initPassword){
		boolean upper = false, lower = false, number = false, special = false, badPassword = false;
		for(int i = 0; i < initPassword.length(); i++){
			if(initPassword.charAt(i) >= 'A' && initPassword.charAt(i) <= 'Z'){
				upper = true;
			}else if(initPassword.charAt(i) >= 'a' && initPassword.charAt(i) <= 'z'){
				lower = true;
			}else if(initPassword.charAt(i) >= '0' && initPassword.charAt(i) <= '9'){
				number = true;
			}else if(initPassword.charAt(i) == '!' || initPassword.charAt(i) == '@' ||
					initPassword.charAt(i) == '#' || initPassword.charAt(i) == '$' ||
					initPassword.charAt(i) == '%' || initPassword.charAt(i) == '^' ||
					initPassword.charAt(i) == '&' || initPassword.charAt(i) == '*'){
				special = true;
			}
			else{
				badPassword = true;
			}
			continue;
		}
		if(upper && lower && number && special && !badPassword){
			password = initPassword;
		}
		else{
			throw new IllegalArgumentException();
		}
		
	}
	
	/**
	 * A getter method for the String representation of the Password object
	 * @return
	 * The String representation of the Password object
	 */
	public String getPassword(){
		return password;
	}
	
	
	
}
