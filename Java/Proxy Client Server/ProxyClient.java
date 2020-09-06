import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class ProxyClient 
{

	public static void main(String[] args) 
	{
		InetAddress ip;
		try 
		{
			Scanner scan=new Scanner(System.in);
			
			ip = InetAddress.getByName("localhost");
			Socket os=new Socket(ip,9998);
			System.out.println("\n Connected to the proxy server");
			DataInputStream odis=new DataInputStream(os.getInputStream());
			DataOutputStream odos=new DataOutputStream(os.getOutputStream());
			String msg="";
			
				msg=odis.readUTF();
				System.out.println("\n Message from Proxy server :"+msg);
				
				System.out.println("\n Write a msg for Proxy server :");
				msg=scan.nextLine();
				odos.writeUTF(msg);
				odos.flush();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
