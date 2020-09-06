import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UdpServer 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try 
		{
			DatagramSocket ods=new DatagramSocket(9998);
			System.out.println("\n Datagram socket created...");
			//File file=new File("Info.txt");
			//FileInputStream ofis=new FileInputStream(file);
			byte[] buffer=new byte[1024];
			
				//Syntax: DatagramPacket(byte buf[], int length, InetAddress inetaddress, int port):-
				DatagramPacket odpReceiving =new DatagramPacket(buffer,buffer.length);
				ods.receive(odpReceiving);
				System.out.println(new String(odpReceiving.getData(), 0, odpReceiving.getLength()));
				
				InetAddress ip=odpReceiving.getAddress();
				int port=odpReceiving.getPort();
				buffer="Hiiiii".getBytes();
				DatagramPacket odpSending=new DatagramPacket(buffer,buffer.length,ip,port);
				ods.send(odpSending);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
