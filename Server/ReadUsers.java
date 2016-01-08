import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadUsers
{
	
	// Declare hashmap for usernames and passwords
	private Map<String, String> hm = new HashMap<String, String>();
	
	//Variables
	private String username, password;
	
	// =============== BUILD A HASHMAP FROM THE USERS.TXT FILE ============================

	// This method builds a hashmap from the users.txt file
	public void createHashMap() throws Exception
	{
		
		// Object to read in a file
		BufferedReader br = new BufferedReader(new FileReader("users.txt"));
		
		// Stores username and password
		String line;
		
		// Go through file line by line
		while((line = br.readLine()) != null){
			
			// Split each line into the key and value
			String[] login = line.split(" ");
			
			// Store username in String
			username = login[0];
			
			// Store password in String 
			password = login[1];
					
			// Put values into hashmap
			hm.put(username,  password);
			
			
		}// End while
		
	    // ================== USED FOR TESTING PURPOSES ===============================
		
		// Prints out username and passwords
		/*for(Map.Entry<String, String> entry : hm.entrySet())
		{
			System.out.println("Key: " + entry.getKey() + " Value :" + entry.getValue());
		}*/
	
		// ============================================================================
		
		// Close the reader
		br.close();
		
	}// End createHashMap
	
	// ==================== SEARCHES AND VALIDATES LOGIN DETAILS ==========================
	
	public boolean searchLoginDetails(String username, String password)
	{
		
		// Variables used to validate correct or incorrect details
		boolean nameNotFound = true, passwordNotFound = true;
		
		// Checks if the username is in the hashmap
		if(hm.containsKey(username))
		{
			
			//Testing code to see if username was found
			//System.out.println("That name is in the map");
			
			// set to false if username is found
			nameNotFound = false;
		
		}
		
		// Compare passwords if username is in the map
		if(nameNotFound == false)
		{
			
			// Compare password from user with password attached to username
			if(password.equals(hm.get(username)))
			{
				
				//Testing code to see if password was found
				//System.out.println("Password matches username");
				
				// set to false if password is found
				passwordNotFound = false;
				
			}// End nested if
			
		}// End if
		
		// If passwordNotFound is returned as false then login details were correct
		return passwordNotFound;
		
	}// End searchUsername
	
}// End ReadUsers
