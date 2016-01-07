import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadUsers
{
	
	// Declare hashmap for usernames and passwords
	Map<String, String> hm = new HashMap<String, String>();
	
	//Variables
	String username, password;

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
		
	    // Check contents of the Map 
		for(Map.Entry<String, String> entry : hm.entrySet())
		{
			System.out.println("Key: " + entry.getKey() + " Value :" + entry.getValue());
		}
	
		// Close the reader
		br.close();
		
	}// End createHashMap
	
	public boolean searchUsername(String username)
	{
		
		boolean nameNotFound = true;
		
		// Search through the map
		for(Map.Entry<String, String> entry : hm.entrySet())
		{
			
			// Compare names in hashmap to what the user entered
			if(username.equals(entry.getKey()))
			{
				
				System.out.println("Username is good!");
				
				nameNotFound = false;
				
			}
			else if(!username.equals(entry.getKey()))
			{
				
				System.out.println("Username is bad!");
				
			}
			
		}// End for loop
		
		return nameNotFound;
		
	}// End searchUsername
	
}// End ReadUsers
