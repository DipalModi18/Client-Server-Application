import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UdpClient 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try 
		{
			InetAddress ip=InetAddress.getLocalHost();
			DatagramSocket ods=new DatagramSocket();
			
			byte[] buffer="Hello".getBytes();
			DatagramPacket odpSending=new DatagramPacket(buffer,buffer.length,ip,9998);
			ods.send(odpSending);
			
			DatagramPacket odpReceiving =new DatagramPacket(buffer,buffer.length);
			ods.receive(odpReceiving);
			System.out.println(new String(odpReceiving.getData(), 0, odpReceiving.getLength()));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
