import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ProxyIntermediateServer 
{

	public static void main(String[] args) 
	{
		try 
		{
			ServerSocket oss=new ServerSocket(9998); // at 9998 proxy server will listen to the incoming client's requests
			System.out.println("\n Waiting for client to join");
			Socket osClient=oss.accept();
			System.out.println("\n Client request accepted");
			
			DataInputStream odisClient=new DataInputStream(osClient.getInputStream());
			DataOutputStream odosClient=new DataOutputStream(osClient.getOutputStream());
			
			InetAddress ip=InetAddress.getByName("localhost");
			System.out.println("\n Connecting to server...");
			Socket osToServer=new Socket(ip,8000);
			System.out.println("\n Connected to the server successfully");
			DataInputStream odisServer=new DataInputStream(osToServer.getInputStream());
			DataOutputStream odosServer=new DataOutputStream(osToServer.getOutputStream());
			
			//proxy server will read msg coming from server, filters it, and sends it to client
			String msg=odisServer.readUTF();
			System.out.println("\n Server has sent message :"+msg+" for client");
			
			//whatever msg came from server forward it to client
			odosClient.writeUTF(msg);
			
			//Now client has sent msg for server
			msg=odisClient.readUTF();
			System.out.println("\n Client has responded :"+msg);
			
			//send that msg to server
			odosServer.writeUTF(msg);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
