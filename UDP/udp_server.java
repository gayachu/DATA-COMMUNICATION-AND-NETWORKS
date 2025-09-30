package networks;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer 
{
public static void main(String[] args) throws IOException
{
// Create a socket to listen at port 1234
	
DatagramSocket ds = new DatagramSocket(1234);
byte[] buf = null;
DatagramPacket DpReceive = null;
DatagramPacket DpSend = null;
while (true)
{
buf = new byte[65535];

// create a DatgramPacket to receive the data.

DpReceive = new DatagramPacket(buf, buf.length);

// receive the data in byte buffer.

ds.receive(DpReceive);
String text = new String(buf, 0, buf.length);
text = text.trim();
System.out.println("Converting to uppercase and sending the result as" +text.toUpperCase());
String res = text.toUpperCase();

// Clear the buffer after every message.

buf = res.getBytes();

// get the port of client.

int port = DpReceive.getPort();
DpSend = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), port);
ds.send(DpSend);
}
}
}
