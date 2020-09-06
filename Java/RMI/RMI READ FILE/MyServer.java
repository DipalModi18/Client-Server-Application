import java.rmi.*;
import java.rmi.registry.*;

public class MyServer 
{
	public static void main(String[] args)
	{
		try
		{
			FileRead ofr=new FileReadClass();
			LocateRegistry.createRegistry(1900);
			Naming.rebind("rmi://localhost:1900/dipal",ofr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}