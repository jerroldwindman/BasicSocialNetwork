
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
 * This class represents an account on the Bitter social network. Every account
 * has two ArrayLists representing the Users following this account, and the Users
 * this account is following. There is also a name and email which match a particular
 * User.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Account implements Serializable{
	private List<User> followers ;
	private List<User> following;
	private String name;
	private Password password;
	private String email;
	
	/**
	 * The default constructor of the Account class.
	 * Assigns values to the name, password and email, and instantiates
	 * the followers and following ArrayLists
	 * @param user
	 * The User object which contains the name and email to be assigned to the
	 * Account
	 * @param pass
	 * The Password associated with the Account and User
	 */
	public Account(User user, Password pass){
		name = user.getName();
		password = pass;
		email = user.getEmail();
		followers = new ArrayList<User>();
		following= new ArrayList<User>();
	}
	
	/**
	 * A getter method for the password associated with the account
	 * @return
	 * The password associated with the account
	 */
	public Password getPassword(){
		return password;
	}
	
	/**
	 * A method to add a User to the followers list of the account
	 * this method was called on
	 * @param newFollower
	 * The User to be added to the followers ArrayList
	 */
	public void addFollowers(User newFollower){
		followers.add(newFollower);
	}
	/**
	 * A method to add a User to the following list of the account
	 * this method was called on
	 * @param newUser
	 * The User to be added to the following ArrayList
	 */
	public void follow(User newUser){
		following.add(newUser);
	}
	/**
	 * A method to remove a User from the following list of the account
	 * this method was called on
	 * @param newUser
	 * The User to be removed from the following ArrayList
	 */
	public void unFollow(User newUser){
		following.remove(newUser);
	}
	/**
	 * A method to remove a User from the follower list of the account
	 * this method was called on
	 * @param newUser
	 * The User to be removed from the follower ArrayList
	 */
	public void removeFollower(User newUser){
		followers.remove(newUser);
	}
	
	/**
	 * A getter method for the followers ArrayList
	 * @return
	 * The followers ArrayList of the account object this
	 * method was called on
	 */
	public List<User> getFollowers(){
		return followers;
	}
	
	/**
	 * A getter method for the following ArrayList
	 * @return
	 * The following ArrayList of the account object this
	 * method was called on
	 */
	public List<User> getFollowing(){
		return following;
	}
	
	/**
	 * A method to override the toString function.
	 * @return
	 * The string representation of the UserDatabase object
	 */
	public String toString(){
		System.out.println(name + "    " + email + "\n");
		
		return "";
	}
	
	
}
