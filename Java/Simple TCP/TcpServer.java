import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServer 
{
	public static void main(String[] args) 
	{
		try 
		{
			ServerSocket oss=new ServerSocket(1234);
			System.out.println("\n Server is waiting...");
			Socket os=oss.accept();
			System.out.println("\n Connection Established!!");
			
			OutputStream output=os.getOutputStream();
			File file=new File("Info.txt");
			FileInputStream ofis=new FileInputStream(file);
			byte[] b=new byte[1024];
			int length=0;
			if((length=ofis.read(b))>0) // Reading file into byte array b by ofis
			{
				output.write(b); // writing byte array to outputstream
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
}
