import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class TcpChatClient 
{

	public static void main(String[] args) 
	{
		InetAddress ip;
		try 
		{
			Scanner scan=new Scanner(System.in);
			
			ip = InetAddress.getByName("localhost");
			Socket os=new Socket(ip,9990);
			
			DataInputStream odis=new DataInputStream(os.getInputStream());
			DataOutputStream odos=new DataOutputStream(os.getOutputStream());
			String msg="";
			
			while(true)
			{
				msg=odis.readUTF();
				if(msg.equals("end"))
				{
					System.out.println("\n Server has ended the chat");
					break;
				}
				System.out.println("\n Message from server :"+msg);
				
				System.out.println("\n Write a msg for server :");
				msg=scan.nextLine();
				odos.writeUTF(msg);
				if(msg.equals("end")){System.out.println("\n Chat has been ended!");
					break;}
				odos.flush();
				
			}
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
