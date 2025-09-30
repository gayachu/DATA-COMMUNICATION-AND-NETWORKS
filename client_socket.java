package networks;

import java.net.*;
import java.io.*;

public class ClientSocket 
{
	public static void main(String[] args) 
	{ 
		if (args.length < 2) return;

	String hostname = args[0];
	int port = Integer.parseInt(args[1]);
	try (Socket socket = new Socket(hostname, port)) // stage 1
	{
	System.out.println("Hurray !! connected to server on localhost at port " +port ); //stage 4
	}
	catch (UnknownHostException ex) 
	{
	System.out.println("Server not found: " + ex.getMessage());
	}
              catch (IOException ex) 
              {            
	System.out.println("I/O error: " + ex.getMessage());
	}
	}
}
