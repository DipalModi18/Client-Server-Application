import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class TcpChatServer 
{
	public static void main(String[] args) 
	{
		try 
		{
			Scanner scan=new Scanner(System.in);
			
			ServerSocket oss=new ServerSocket(9990);
			Socket os=oss.accept();
			DataInputStream odis=new DataInputStream(os.getInputStream());
			DataOutputStream odos=new DataOutputStream(os.getOutputStream());
			String msg="";
			
			while(true)
			{
				System.out.println("\n Write a message for client:");
				msg=scan.nextLine();
				if(msg.equals("end")){System.out.println("\n Chat has been ended!");
					break;}
				odos.writeUTF(msg);
				odos.flush();
				
				msg=odis.readUTF();
				if(msg.equals("end"))
				{
					System.out.println("\n Client has ended the chat");
					break;
				}
				System.out.println("\n From client :"+msg);
				
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
