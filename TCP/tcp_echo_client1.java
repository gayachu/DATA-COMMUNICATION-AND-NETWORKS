package networks;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPEchoClient1 
{
public static void main(String[] args)
{
if (args.length< 2) return;
String hostname = args[0];
int port = Integer.parseInt(args[1]);
Scanner console = new Scanner(System.in);
try (Socket socket = new Socket(hostname, port)) 
{
OutputStream output = socket.getOutputStream();
PrintWriter writer = new PrintWriter(output, true);
String text;
do 
{
System.out.println("Client 1: Enter text :");
text = console.nextLine();
writer.println(text);
InputStream input = socket.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(input));
String time = reader.readLine();
System.out.println(time);
}
while (!text.equals("bye"));
socket.close();
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
