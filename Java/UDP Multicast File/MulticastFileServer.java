import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;


public class MulticastFileServer {

	public static void main(String[] args) {
		try 
		{
			File file=new File("Input.txt");
			FileOutputStream ofos=new FileOutputStream(file);
			
			System.out.println("\n Enter contents to be written to the file");
			System.out.println("To stop writing to the file, type 'end'");
			Scanner scan=new Scanner(System.in);
			String str="";
			while(true)
			{
				str=scan.next();
				if(str.equals("end")){break;}
				str=str+"\n";
				ofos.write(str.getBytes());
			}
			InetAddress ip=InetAddress.getByName("224.0.0.1");
			MulticastSocket oms=new MulticastSocket();
			
			FileInputStream ofis=new FileInputStream(file);
			byte[] buffer=new byte[1024];
			ofis.read(buffer);
			DatagramPacket odp=new DatagramPacket(buffer,buffer.length,ip,9998);
			oms.send(odp);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
