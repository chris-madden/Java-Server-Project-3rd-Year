import java.util.Scanner;

public class Login 
{
	
	// Variables
	Scanner input = new Scanner(System.in);

	//==================== METHOD FOR GETTING USERNAME ==========================
	
	public String username()
	{
		
		// Variable
		String username;
		
		// Take username from client side
		System.out.print("\nEnter Username: ");
		
		// Store username in String
		username = input.next();
		
		// Return String
		return username;
		
	}
	
	//==================== METHOD FOR GETTING PASSWORD ==========================
	
	public String password()
	{
		
		// Variable
		String password;
		
		// Take password from client side
		System.out.print("Enter password: ");
		
		// Store password in String
		password = input.next();
		
		// Return String
		return password;
	}
	
}// End class Login
