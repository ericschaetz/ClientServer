import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Server {
	public static ServerSocket server;
	
	
	
	public static void handleConnection(Socket client) throws IOException{
		Scanner in = new Scanner(client.getInputStream()); //Der Eingang vom Server
		PrintWriter out = new PrintWriter(client.getOutputStream(), true); //Der Datenstrom wieder zurueck
		String s[] = in.nextLine().split(Pattern.quote("#"));
		System.out.print("Eingehende Verbindung erkannt. ("+s[0]+" - "+ s[1] +")");
		out.println("Hallo "+s[1]+", wir freuen uns das du heute gekommen bist.");
	}
	
	public static void run() throws IOException{
		server = new ServerSocket(1714);
		System.out.println("Der Server wurde gestartet. ("+InetAddress.getLocalHost().getHostAddress().toString()+")");
		
		while (true){
			//Hoert am Socket, ob was ankommt.
			Socket client = null;
			try{
				//Verbindung annehmen
				client = server.accept();
				//Rufen Methode auf, in dem der Client verarbeitet wird
				handleConnection(client);
			} catch(IOException e){
				e.printStackTrace();	
			} finally {
				//Am Ende versuchen, die Klasse wieder zu schliessen
				if (client != null){
					try{ client.close(); 
					} catch(IOException e){
						
					}
				} 
			}
		}
	}
	
	
}
