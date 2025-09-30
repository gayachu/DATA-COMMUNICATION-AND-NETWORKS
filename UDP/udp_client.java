package networks;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient
{
public static void main(String args[]) throws IOException
{
Scanner sc = new Scanner(System.in);

// Create the socket object

DatagramSocket ds = new DatagramSocket();
InetAddress ip = InetAddress.getLocalHost();
byte buf[] = null;

// loop till input not equal to "bye"

while (true)
{
System.out.print("Enter text");
String text = sc.nextLine();
buf = new byte[65535];

// convert the String input into the byte array.

buf = text.getBytes();

// Create the datagramPacket for sending the data.

DatagramPacket DpSend =new DatagramPacket(buf, buf.length, ip, 1234);

// invoke the send call to actually send the data.

ds.send(DpSend);

// break the loop if user enters "bye"

if (text.equals("bye"))
break;
buf = new byte[65535];
DatagramPacket DpReceive = new DatagramPacket(buf, buf.length);
ds.receive(DpReceive);
System.out.println("Response from server = " + new String(buf,0,buf.length));
}
}
}
