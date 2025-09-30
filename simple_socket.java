package networks;

import java.io.*;
import java.net.*;

public class SimpleSocket 
{
	public static void main(String[] args) 
	{ 
		if (args.length < 1) return;
	int port = Integer.parseInt(args[0]);
	try (ServerSocket serverSocket = new ServerSocket(port))
	{
	System.out.println("Server is listening on port " +port ); 
	while (true)
	{
	Socket socket= serverSocket.accept();// stage 2
	System.out.println("New client connected");//stage 3
	}
	} 
	catch (IOException ex) 
	{
	System.out.println("Server exception: " + ex.getMessage()); ex.printStackTrace();
	}
	}
}

