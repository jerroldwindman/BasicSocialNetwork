
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
 * This is the driver class for the Bitter social network.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BitterPlatform {
	private static Bitter bitter;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String command = null;
		boolean logScreen = true, homeScreen = true, running = true;;
		String workingEmail = null;
		
	
		try {
			FileInputStream streamIn = new FileInputStream("bitter.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(streamIn);
			bitter = (Bitter) objectInputStream.readObject();
			objectInputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("No previous data found");
			bitter = new Bitter();
		} catch (IOException e) {
			System.out.println("Data did not load properly");
			bitter = new Bitter();
		} catch (ClassNotFoundException e) {
		
		}
		while(running){
			System.out.println("Welcome to the Bitter Social Network!\n");
			
			
			
		
		while(logScreen){
			System.out.println("Login Menu:");
			System.out.println("\tL) Login");
			System.out.println("\tS) Sign Up");
			System.out.println("\tQ) Quit");
			System.out.println("Please select an option: ");
		
		
		command = input.nextLine();
		
		if(command.equalsIgnoreCase("L")){
			System.out.println("Please enter your email: ");
			String email = input.nextLine();
			System.out.println("Please enter your password: ");
			String password = input.nextLine();
			try{
				if(bitter.getUserDB().getUser(email) != null){
					if(bitter.getAcctDB().getAccountInformation(email).getPassword().getPassword().equals(password)){
						workingEmail = email;
						homeScreen = true;
						logScreen = false;
					}
					else{
						System.out.println("That email and password combination does not exist!");
					}
				}else{
					System.out.println("That email does not exist!");
				}
			}catch(NullPointerException e){
				System.out.println("That email and password combination does not exist!");
			}
			
		} else if(command.equalsIgnoreCase("S")){
			System.out.println("Please enter your email: ");
			String email = input.nextLine();
			System.out.println("Please enter your name: ");
			String name = input.nextLine();
			User newUser = new User(name, email);
			boolean valid = true;
			while(valid){
			System.out.println("Please enter a password: ");
			String pass = input.nextLine();
			
				try{
					Password password = new Password(pass);
					Account tempAccount = new Account(newUser, password);
					bitter.addUser(email, newUser, tempAccount);
					valid = false;
				}catch(IllegalArgumentException e){
					System.out.println("Your password is not secure enough. PLease make sure you have at least"
							+ "one upper case and one lower case letter, one special character, and one number.");
					continue;
				}
			}
			System.out.println("Thank you for signing up! Welcome to Bitter!");
			workingEmail = email;
			homeScreen = true;
			logScreen = false;
			} else if(command.equalsIgnoreCase("Q")){
				System.out.println("Exiting the Bitter Network");
				try{
					FileOutputStream fout = new FileOutputStream("bitter.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fout);
					oos.writeObject(bitter);
					oos.close();
				}catch(Exception e){
					System.out.println("The bitter platform failed to serialize!");
				}
				running = false;
				homeScreen = false;
				break;
			
			}
		}
			
		while(homeScreen){
			System.out.println("\nUser Menu:");
			System.out.println("\tF) Follow someone");
			System.out.println("\tU) Unfollow someone");
			System.out.println("\tV) View followers");
			System.out.println("\tS) See who you follow");
			System.out.println("\tA) List all users");
			System.out.println("\tL) Logout");
			System.out.println("\tC) Close your account");
			
			System.out.println("Please select an option: ");
			command = input.nextLine();
			
			if(command.equalsIgnoreCase("F")){
				System.out.println("Please enter the email of the user you would like to follow:");
				String tempEmail = input.nextLine();
				if(bitter.getUserDB().getUser(tempEmail) != null){
					bitter.getAcctDB().getAccountInformation(workingEmail).follow(bitter.getUserDB().getUser(tempEmail));
					bitter.getAcctDB().getAccountInformation(tempEmail).addFollowers(bitter.getUserDB().getUser(workingEmail));
				}else{
					System.out.println("This email does not exist in the database!");
				}
				
			}else if(command.equalsIgnoreCase("U")){
				System.out.println("Please enter the email of the user you would like to unfollow: ");
				String tempEmail = input.nextLine();
				bitter.getAcctDB().getAccountInformation(workingEmail).unFollow(bitter.getUserDB().getUser(tempEmail));
				bitter.getAcctDB().getAccountInformation(tempEmail).removeFollower(bitter.getUserDB().getUser(workingEmail));
			}else if(command.equalsIgnoreCase("V")){
				System.out.println("Your Followers: ");
				System.out.println("Email" + "                    " + "Name");
				System.out.println("-------------------------------------------");
				for(int i = 0; i < bitter.getAcctDB().getAccountInformation(workingEmail).getFollowers().size(); i++ ){
					try{
						bitter.getAcctDB().getAccountInformation(workingEmail).getFollowers().get(i).toString();
					}catch(NoSuchElementException e){
						break;
					}
				}
			}else if(command.equalsIgnoreCase("S")){
				System.out.println("Followed Users: ");
				System.out.println("Email" + "                    " + "Name");
				System.out.println("-------------------------------------------");
				for(int i = 0; i < bitter.getAcctDB().getAccountInformation(workingEmail).getFollowing().size(); i++ ){
					try{
						bitter.getAcctDB().getAccountInformation(workingEmail).getFollowing().get(i).toString();
					}catch(NoSuchElementException e){
						break;
					}
				}
			
			}else if(command.equalsIgnoreCase("A")){
				System.out.println("All Users: ");
				System.out.println("Email" + "                    " + "Name");
				System.out.println("-------------------------------------------");
				bitter.getUserDB().toString();
			}else if(command.equalsIgnoreCase("L")){
				logScreen = true;
				homeScreen = false;
				break;
			}else if(command.equalsIgnoreCase("C")){
				bitter.getAcctDB().removeAccount(workingEmail);
				bitter.getUserDB().removeUser(workingEmail);
				
				logScreen = true;
				homeScreen = false;
			}else{
				System.out.println("Incorrect Key, please enter a valid key!");
				continue;
			}
			
			}
		}
	}
}
