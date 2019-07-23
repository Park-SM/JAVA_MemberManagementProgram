package application;

//import java.io.IOException;

import display.ApplicationService;

public class Main {
	public static void main(String[] args) {
		
		ApplicationService as = new ApplicationService();
		while(as.escape) {
			for (int row = 0; row < 40; row++) System.out.println(" ");	// clear console view.
			as.MainDisplay();
			
			/* When using windows cmd.
			try {
				Runtime.getRuntime().exec("cls");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
		
	}
}
