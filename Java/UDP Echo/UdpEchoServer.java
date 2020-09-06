import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UdpEchoServer 
{

	public static void main(String[] args) 
	{
		try 
		{
			DatagramSocket ods=new DatagramSocket(9998);
			System.out.println("\n Datagram socket created...");

			byte[] buffer=new byte[1024];
			
				//Syntax: DatagramPacket(byte buf[], int length, InetAddress inetaddress, int port):-
				DatagramPacket odpReceiving =new DatagramPacket(buffer,buffer.length);
				ods.receive(odpReceiving);
				byte[] receivedData=odpReceiving.getData();
				System.out.println("\n From Client :"+new String(receivedData));
				
				InetAddress ip=odpReceiving.getAddress();
				int port=odpReceiving.getPort();
				DatagramPacket odpSending=new DatagramPacket(receivedData,receivedData.length,ip,port);
				ods.send(odpSending);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
