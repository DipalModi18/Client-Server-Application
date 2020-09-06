import java.rmi.*;

public class OsClient
{
	public static void main(String args[])
	{
		try
		{
			OsInfo ofb=(OsInfo)Naming.lookup("rmi://localhost:1900/sonoo");
			String str=ofb.getOsInfo();
				System.out.println(str);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}