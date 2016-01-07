import java.util.Scanner;


public class Login 
{
	Scanner input = new Scanner(System.in);


	public String username()
	{
		
		String username;
		
		// Take username from client side
		System.out.print("Enter Username: ");
		username = input.next();
		
		return username;
	}
	
}// End class Login
