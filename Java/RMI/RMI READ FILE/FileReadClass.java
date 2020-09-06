import java.rmi.*;
import java.rmi.server.*;
import java.io.File;
import java.io.FileInputStream;

public class FileReadClass extends UnicastRemoteObject implements FileRead
{
	FileReadClass() throws RemoteException
	{
	super();
	}
	
	public byte[] readingFile(String filename)
	{
		byte[] buffer=new byte[1024];
		try
		{
			File file=new File(filename);
			FileInputStream ofis=new FileInputStream(file);
			ofis.read(buffer);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return buffer;
	}
}