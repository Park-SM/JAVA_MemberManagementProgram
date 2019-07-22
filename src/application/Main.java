package application;

import java.io.IOException;

import display.ApplicationService;

public class Main {
	public static void main(String[] args) {
		
		ApplicationService as = new ApplicationService();
		while(as.escape) {
			for (int row = 0; row < 40; row++) System.out.println(" ");
			as.MainDisplay();
			/*
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
