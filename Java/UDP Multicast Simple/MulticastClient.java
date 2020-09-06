import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class MulticastClient 
{
	public static void main(String[] args) 
	{
		try 
		{
			InetAddress ip=InetAddress.getByName("224.0.0.1");
			MulticastSocket oms=new MulticastSocket(9998);
			oms.joinGroup(ip);
			
			byte[] buffer=new byte[1024];
			DatagramPacket odp=new DatagramPacket(buffer,buffer.length);
			oms.receive(odp);
			System.out.println(new String(buffer));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
