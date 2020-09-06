import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class MulticastServer 
{

	public static void main(String[] args) 
	{
		try 
		{
			InetAddress ip=InetAddress.getByName("224.0.0.1");
			MulticastSocket oms=new MulticastSocket();
			
			String msg="Hello from server";
			byte[] buffer=msg.getBytes();
			DatagramPacket odp=new DatagramPacket(buffer,buffer.length,ip,9998);
			oms.send(odp);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
