import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UdpEchoClient 
{

	public static void main(String[] args) 
	{
		try 
		{
			InetAddress ip=InetAddress.getLocalHost();
			DatagramSocket ods=new DatagramSocket();
			
			byte[] buffer="Hello".getBytes();
			DatagramPacket odpSending=new DatagramPacket(buffer,buffer.length,ip,9998);
			ods.send(odpSending);
			System.out.println("Hello sent");
			
			DatagramPacket odpReceiving =new DatagramPacket(buffer,buffer.length);
			ods.receive(odpReceiving);
			System.out.println("From sever:"+new String(odpReceiving.getData(), 0, odpReceiving.getLength()));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
