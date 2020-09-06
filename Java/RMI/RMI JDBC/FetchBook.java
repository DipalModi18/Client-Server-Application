import java.rmi.*;
import java.sql.ResultSet;

public interface FetchBook extends Remote
{
	public ResultSet fetchingRecord(String bookid) throws RemoteException;
}