import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ProxyServer 
{

	public static void main(String[] args) 
	{
		
		try 
		{
			Scanner scan=new Scanner(System.in);
			
			ServerSocket oss=new ServerSocket(8000);
			System.out.println("\n Waiting for Proxy server to join");
			Socket os=oss.accept();
			System.out.println("\n Proxy server connected");
			DataInputStream odis=new DataInputStream(os.getInputStream());
			DataOutputStream odos=new DataOutputStream(os.getOutputStream());
			String msg="";
			
				System.out.println("\n Write a message for client:");
				msg=scan.nextLine();
				odos.writeUTF(msg);
				odos.flush();
				
				msg=odis.readUTF();
				System.out.println("\n From client :"+msg);
				
		} 
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		

	}

}
