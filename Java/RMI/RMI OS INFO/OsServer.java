import java.rmi.*;
import java.rmi.registry.*;

public class OsServer
{
	public static void main(String[] args)
	{
		try
		{
			OsInfo ofb=new OsInfoClass();
			LocateRegistry.createRegistry(1900);
			Naming.rebind("rmi://localhost:1900/sonoo",ofb);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}