import java.rmi.*;
import java.sql.ResultSet;
import java.util.Scanner;

public class BookClient
{
	public static void main(String[] args)
	{
		try
		{
			FetchBook ofb=(FetchBook)Naming.lookup("rmi://localhost:1900/modi");
		
			Scanner scan=new Scanner(System.in);
			System.out.println("\n Enter bookid :");
			String bookid=scan.next();
			ResultSet rs=ofb.fetchingRecord(bookid);
			
			while(rs.next())
			{
				System.out.println("\n bookid :"+rs.getString("bookId")+" bookname :"+rs.getString("bookName")+" author :"+rs.getString("author")+" price :"+rs.getInt("price")+" genre :"+rs.getString("genre")+" available :"+rs.getInt("available")+" publication :"+rs.getString("publication"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
