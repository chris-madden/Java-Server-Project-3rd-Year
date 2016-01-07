
public class ClientRunner {

	public static void main(String[] args) {
		
		// Create object client
		Client client = new Client();
		
		try 
		{
			
			// Call the run method
			client.run();
			
		} catch (Exception e) 
		{
			
			e.printStackTrace();
		}

	}// End main

}// End class ClientRunner

//40.76.90.148