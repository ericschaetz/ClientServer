import java.io.IOException;
import java.util.Scanner;

public class init {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("Geben Sie 1 fuer den Start des Servers und 2 fuer den Start des Clients ein!");
	String s;
	Scanner a = new Scanner(System.in);
	
	s = a.next();
	System.out.println("Sie haben "+s+" eingegeben.");
	if(s.equals("1")){
		try {
			Server.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} else if (s.equals("2")){
		Client.connect("localhost");
	}
	
	}
}
