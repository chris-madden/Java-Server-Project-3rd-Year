import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	// Variables
	private Scanner input = new Scanner(System.in);
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Login login;
	private String ipaddress;
	private String username, password;
	private boolean isNotUsername = false;
	
	//==================== METHOD FOR SENDING INFORMATION TO SERVER =============================
	
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
	
	//============================ METHOD USED TO RUN CLIENT SIDE CODE =================================
	
	public void run() throws Exception
	{
		
		//Prompt user for ip address 
		System.out.println("Please Enter your IP Address");
		
		// Store ip address in String
		ipaddress = input.next();
		
		// Create socket with entered ip address and port number
		Socket requestSocket = new Socket(ipaddress, 2004);
		
		// Print message to show you've connected 
		System.out.println("Connected to " + ipaddress + " in port 2004");
		
		//========================== SET UP STREAMS ===============================
		
		//Set up output stream
		out = new ObjectOutputStream(requestSocket.getOutputStream());
		
		// Set up input stream
		in = new ObjectInputStream(requestSocket.getInputStream());
		
		//============================== TAKE LOGIN DETAILS FROM USER ===============================
		
		System.out.println("\n\t\tEnter your login details");
		System.out.println("\t\t========================");
		
		// Create new login object
		login = new Login();
		
		do{
			
			// Store username in variable
			username = login.username();
			
			// Get password off of user
			password = login.password();
			
			// Send username to server
			send(username);
			
			// Send password to server
			send(password);
			
			// Read back answer from server
			isNotUsername = in.readBoolean();
			
			// Prompts user that the login details are incorrect
			if(isNotUsername == true)
			{
				
				System.out.println("\n\t***** Incorrect details - Try Again *****");
				
			}
			
		}while(isNotUsername == true);
		
		
		// Print welcome message to user
		System.out.println("\nSuccess - Welcome " + username);
		
		//============================= CLOSE THE CONNECTIONS ===========================
			
		try{
			
			in.close();
			out.close();
			requestSocket.close();
			
		}
		catch(IOException ioException)
		{
			ioException.printStackTrace();
		}
	
	}// End run

}// End class Client
