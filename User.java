
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
 * This class represents a User on the Bitter Social Network. Every User has an associated private name and email String.
 * These can be accessed via their getter and setter methods.
 */

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String email;
	
	/**
	 * The default constructor for the User class.
	 * @param name
	 * The String that will define the name of the User
	 * @param email
	 * The String that will define the email of the User
	 * 
	 */
	public User(String name, String email){
		this.name = name;
		this.email = email;
	}
	
	/**
	 * A getter method for the email String of the User object
	 * @return
	 * The email of the User object
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * A setter method for the email String of the User object
	 * @param newEmail
	 * The String that will define the email of the User
	 */
	public void setEmail(String newEmail){
		email = newEmail;
	}
	
	/**
	 * A setter method for the name String of the User object
	 * @param newName
	 * The String that will define the name of the User
	 */
	public void setName(String newName){
		name = newName;
	}
	
	/**
	 * The getter method for the name String of the User object
	 * @return
	 * The name of the User object
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * A method to override the toString function.
	 * @return
	 * The string representation of the User object
	 */
	public String toString(){
		System.out.println(name + "    " + email);
		return "\n";
	}
	
}
