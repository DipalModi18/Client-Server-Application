import java.rmi.*;

public class MyClient
{
	public static void main(String[] args)
	{
		try
		{
			FileRead ofr=(FileRead)Naming.lookup("rmi://localhost:1900/modi");
			byte[] buffer=ofr.readingFile("Info.txt");
		
			int i=0;
			while(i<buffer.length)
			{
				System.out.print((char)buffer[i]);
				i++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}