import java.rmi.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchBookClass extends UnicastRemoteObject implements FetchBook
{
	FetchBookClass() throws RemoteException
	{
		super();
	}
	
	public ResultSet fetchingRecord(String bookid)
	{
		ResultSet rs=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","root");
			Statement st=con.createStatement();
			
			rs=st.executeQuery("select * from booksrecords where bookid='"+bookid+"'");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}