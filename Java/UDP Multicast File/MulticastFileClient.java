import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class MulticastFileClient 
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
			
			File file=new File("Input.txt");
			FileOutputStream ofos=new FileOutputStream(file);
			ofos.write(buffer);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}


	}

}
