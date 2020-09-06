import java.rmi.*;

public interface OsInfo extends Remote
{
	public String getOsInfo() throws RemoteException;
}