
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
 * This class represents a database of User objects which are stored and accessed through
 * a hashmap called map.
 */
import java.io.Serializable;
import java.util.HashMap;

public class UserDatabase implements Serializable{

	HashMap<String, User> map = new HashMap<String, User>();
	
	/**
	 * Inserts a new user into the hashmap using the email as the key
	 * @param email
	 * The email of the User used as a key for the hashmap
	 * @param user
	 * The User object being placed in the hashmap at the position determined by the key
	 * <dt><b>Preconditions:</b><dd>
	 * The email is not null and the email does not map to a User in the database
	 * <dt><b>Postconditions:</b><dd>
	 * There is a new User mapped to the database of users
	 * @throws IllegalArgumentException
	 * If the email is null or the email maps to a User in the database, the exception
	 * is thrown
	 */
	public void addUser(String email, User user){
		if(email != null && map.get(email) == null){
			map.put(email, user);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Return the User from the User database at the associated position determined by the key (email)
	 * @param email
	 * The key for accessing the User database
	 * @return
	 * The User mapped at that key
	 */
	public User getUser(String email){
		return map.get(email);
	}
	
	/**
	 * Removed the User from the User database at the associated position determined by the key (email)
	 * @param email
	 * The key for accessing the User database
	 * <dt><b>Preconditions:</b><dd>
	 * The email is not null and the email maps to a User in the database
	 * <dt><b>Postconditions:</b><dd>
	 * There is a new User mapped to the database of users
	 * @throws IllegalArgumentException
	 * If the email is null or the email does not map to a User in the database, the exception
	 * is thrown
	 */
	public void removeUser(String email){
		if(email != null && map.containsKey(email) != false ){
			map.remove(email);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * A method to override the toString function.
	 * @return
	 * The string representation of the UserDatabase object
	 */
	public String toString(){
		for(String key: map.keySet()){
			System.out.println(key + "      " + map.get(key).getName() + "\n");
		}
		return "\n";
	}
	
}
