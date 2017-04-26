import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static Socket server;
	public static Scanner in;
	public static PrintWriter out;
	
	
	public static void connect(){
		try{
			System.out.println("Bitte gib die IP des Server's an: ");
			Scanner _addr = new Scanner(System.in);
			
			server = new Socket(_addr.nextLine(),1714); //Baue Verbindung mit Server auf
			out = new PrintWriter(server.getOutputStream(), true);
			in = new Scanner(server.getInputStream());
			String message;
			System.out.println("Bitte gib deinen Namen ein: ");
			
			Scanner a = new Scanner(System.in);
			message = a.next();
			out.println(InetAddress.getLocalHost().getHostAddress().toString()+"#"+message); //Die Nachricht geht jetzt an den Server
			String s = in.nextLine();
			System.out.println("Server: "+s);
					
		} catch(UnknownHostException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			//Am Ende versuchen, die Klasse wieder zu schliessen
			if (server != null){
				try{ server.close(); 
				} catch(IOException e){
					
				}
			}
	}
}}
