import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class TcpClient 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try 
		{
			InetAddress inet=InetAddress.getByName("localhost");
			Socket os=new Socket(inet,1234);
			System.out.println("\n Connected to server");
			
			//To write to a local file
			File file=new File("Info.txt");
			FileOutputStream ofos=new FileOutputStream(file);
			
			InputStream input=os.getInputStream();
			byte[] b=new byte[1024];
			int fileLength=0;
			if((fileLength=input.read(b))>0)
			{
				ofos.write(b);
			}
			for(int i=0;i<fileLength;i++)
			{
				System.out.print((char)b[i]);
			}
			
		} 
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
