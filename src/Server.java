import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static ServerSocket server;
	
	public static void handleConnection(Socket client) throws IOException{
		Scanner in = new Scanner(client.getInputStream()); //Der Eingang vom Server
		PrintWriter out = new PrintWriter(client.getOutputStream(), true); //Der Datenstrom wieder zurueck
		String s = in.nextLine();
		out.println(s+s);
	}
	
	public static void run() throws IOException{
		server = new ServerSocket(1714);
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
