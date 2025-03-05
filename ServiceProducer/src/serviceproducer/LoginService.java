package serviceproducer;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalTime;

public class LoginService implements ILoginService{
	
	//A map to store usernames and their associated passwoeds
	private Map<String,String> users = new HashMap<>();
	
	/**
	 * Constructor that initializes the users map with one sample user
	 */
	public LoginService() {
		
		users.put("Amali", "Amali@1234");//Sample username and password
	}
	
	@Override
	public boolean login(String username, String password) {
		
		//Check if the username exists and the password matches
		if(users.containsKey(username) && users.get(username).equals(password)) {
			
			//Generate a time-based greeting message
			String greeting = getGreetingMessage();
			
			//Print Login success and personalized greeting
			System.out.println("====================================================");
			System.out.println("               Welcome to FoodRush");
			System.out.println("Emphasizes speed and efficiency in ordering food");
			System.out.println("----------------------------------------------------");
			System.out.println("Welcome back " + username + "! You have successfully logged in.");
			System.out.println(greeting + ", " + username + "!");

			System.out.println("=====================================================\n\n");
			return true;
		}else {
			//Print login failure message
			System.out.println("Login failed for user: " + username);
			return false;
		}
		
	}
	/**
	 * Returns a personalized greeting message based on the current time of day
	 * 
	 * @return A sting representing the appropriate greeting
	 */
	private String getGreetingMessage() {
		
		//Get the current time
		LocalTime currentTime = LocalTime.now();
		int hour = currentTime.getHour();
		
		//Determine the greeting based on the current hour
		if(hour >= 5 && hour < 12){
			return "Good Morning";
		}else if(hour >= 12 && hour < 17) {
			return "Good Afternoon";
		}else if(hour >= 17 && hour < 21) {
			return "Good Evening";
		}else {
			return "Good Night";
		}
	}
	
	

}
