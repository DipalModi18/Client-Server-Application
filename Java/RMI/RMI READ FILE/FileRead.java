import java.rmi.*;

public interface FileRead extends Remote
{
	public byte[] readingFile(String filename) throws RemoteException;
}