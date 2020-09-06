import java.rmi.*;
import java.rmi.server.*;

public class OsInfoClass extends UnicastRemoteObject implements OsInfo
{
	public OsInfoClass() throws RemoteException
	{
		super();
	}
	
	public String getOsInfo()
	{
		String str="OS :"+System.getProperty("os.name")+"Processors :"+Runtime.getRuntime().availableProcessors()+" \n Free memory :"+Runtime.getRuntime().freeMemory()+"\n Maximum memory (bytes):"+Runtime.getRuntime().maxMemory();
		
		return str;
	}
}