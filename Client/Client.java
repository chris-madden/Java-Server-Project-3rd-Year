import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	Scanner input = new Scanner(System.in);
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Login login;
	private String ipaddress;
	private String message, username, password;
	private boolean isNotUsername = false, isPassword = false;
	
	public void send(String message)
	{
		
		try
		{
			// Send message to server
			out.writeObject(message);
			out.flush();
			
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
			
		}
		
	}// End method send
	
	public void run() throws Exception
	{
		//1. creating a socket to connect to the server
		System.out.println("Please Enter your IP Address");
		ipaddress = input.next();
		
		// Create socket with entered ip address and port number
		Socket requestSocket = new Socket(ipaddress, 2004);
		
		// Print message to show you've connected 
		System.out.println("Connected to " + ipaddress + " in port 2004");
		
		//Set up output stream
		out = new ObjectOutputStream(requestSocket.getOutputStream());
		
		// Set up input stream
		in = new ObjectInputStream(requestSocket.getInputStream());
		
		/*//Receive message
		message = (String)in.readObject();
		
		System.out.println(message);*/
		
		System.out.println("Enter your login details");
		
		// Create new login object
		login = new Login();
		
		do{
			
			// Store username in variable
			username = login.username();
			
			// Send username to server
			send(username);
			
			// Read back answer from server
			isNotUsername = in.readBoolean();
			
			// Prompts user that the username is incorrect
			if(isNotUsername == true)
			{
				
				System.out.println("Incorrect username");
				
			}
			
		}while(isNotUsername == true);
		
		
		
			
		
		
		
		
		
		/*// Take Password
		System.out.print("\nPassword: ");
		password = input.next();*/

	}// End run

}// End class Client
