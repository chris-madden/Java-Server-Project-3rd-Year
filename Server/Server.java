import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server extends Thread{
	
	// Variables
	private Socket clientSocket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private ReadUsers ru;
	private boolean notUsername = true;
	private String username, password; 
	
	//Constructor
	public Server(Socket serverConnection) 
	{
		// Initialize clientSocket
		clientSocket = serverConnection;
	}
	
	//=========================== THREAD STARTS ===============================================
	
	// Run a thread
	public void run() {
		
		// Create new object
		ru = new ReadUsers();
		
		
		//==================== READ USER DETAILS INTO HASHMAP ================================= 
		
		try 
		{
			// Create hashmap containing the usernames and passwords for logins
			// Usernames are 'Key' and Passwords are 'Values'
			ru.createHashMap();
			
		} catch (Exception e1) 
		{
			e1.printStackTrace();
		}
		
		//====================== SET UP INPUT AND OUTPUT STREAMS ================================
		
		try
		{
			// Set up input stream
			in = new ObjectInputStream(clientSocket.getInputStream());
			
			// Set up output stream
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			
		} catch (IOException e) 
		{
			
			e.printStackTrace();
			
		}// End try catch
		
		//=============================== READ IN AND SEARCH USERNAME AND PASSWORD=============================
		
		do{
			
			try 
			{
				// Read in the username
				username = (String) in.readObject();
				
				password = (String) in.readObject();
				
				// Search for username and return boolean value
				notUsername = ru.searchLoginDetails(username, password);
				
				/*// Search for password and return boolean
				notPassword = ru.searchPassword(password);*/
				
				// Send back answer 
				out.writeBoolean(notUsername);
				out.flush();
				
			}
			catch (ClassNotFoundException e) 
			{
				
				e.printStackTrace();
				
			} 
			catch (IOException e) 
			{
				
				e.printStackTrace();
				
			}
			
		}while(notUsername);
			
		//====================== Close connections ======================================
		
		try{
			
			in.close();
			out.close();
			clientSocket.close();
			
		}
		catch(IOException ioException)
		{
			ioException.printStackTrace();
		}
		
	}// End run 
		
}// End class Server
