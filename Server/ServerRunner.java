import java.net.ServerSocket;
import java.net.Socket;


public class ServerRunner {
	
	public static void main(String[] args) throws Exception 
	{
		// Server listens for requests on port 2004 and has a max queue of 10
		ServerSocket server = new ServerSocket(2004,10);
		
		while(true)
		{
			
			// Server accepts connection
			Socket serverConnection = server.accept();
			
			// Pass accepted connection into Server 
			Server serverThread = new Server(serverConnection);
			
			// Start thread
			serverThread.start();
			
		}// End while
		
	}// End main

}// End class ServerRunnre
