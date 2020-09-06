import java.rmi.*;
import java.rmi.registry.*;

public class BookServer
{
	public static void main(String[] args)
	{
		try
		{
			FetchBook ofb=new FetchBookClass();
			LocateRegistry.createRegistry(1900);
			Naming.rebind("rmi://localhost:1900/modi",ofb);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}