package display;

import java.io.IOException;
import java.util.Scanner;
import model.Member;
import model.MemberHandler;

public class ApplicationService {
	private MemberHandler MemHandler;
	private Scanner sc;
	public boolean escape;
	
	public ApplicationService() {
		this.MemHandler = new MemberHandler();
		this.sc = new Scanner(System.in);
		this.escape = true;
	}
	
	public void MainDisplay() {
		System.out.println("=========================================================");
		System.out.println("Command list.");
		System.out.println(" - print\t=> Print the member list.");
		System.out.println(" - add\t\t=> Add new member.");
		System.out.println(" - modify\t=> Modify the member.");
		System.out.println(" - delete\t=> Delete the member.");
		System.out.println(" - deleteALL\t=> Destroy the member list.");
		System.out.println(" - exit\t\t=> Exit program.");
		System.out.println("=========================================================");
		System.out.print(">> command:: ");
		String command = sc.nextLine();
		
		if (command.equals("print")) this.PrintMenu();
		else if (command.equals("add")) this.AddMenu();
		else if (command.equals("modify")) this.ModifyMenu();
		else if (command.equals("delete")) this.DeleteMenu();
		else if (command.equals("deleteALL")) this.DeleteALLMenu();
		else if (command.equals("exit")) this.escape = false;
		
		for (int row = 0; row < 40; row++) System.out.println(" ");	// clear console window.
		/*
		try {
			Runtime.getRuntime().exec("cls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	public void PrintMenu() {
		System.out.println("=========================================================");
		System.out.println("::: PRINT MENU :::");
		this.MemHandler.PrintMemberList();
		System.out.println("=========================================================");
		System.out.println(">> Please press ENTER key to continue..");
		sc.next();
	}
	
	public void AddMenu() {
		Member TempMember = new Member();
		System.out.println("=========================================================");
		System.out.println("::: ADD MENU :::");
		System.out.println("=========================================================");
		System.out.print(">> Name: ");
		TempMember.setName(sc.nextLine());
		System.out.print(">> Age: ");
		TempMember.setAge(sc.nextInt());
		sc.nextLine(); // Clear buffer.
		System.out.print(">> phone: ");
		TempMember.setPhone(sc.nextLine());
		System.out.print(">> Address: ");
		TempMember.setAddress(sc.nextLine());
		
		if (this.MemHandler.CreateMember(TempMember))
			System.out.println("Success!");
		else
			System.out.println(">> Error:: Failed to create member node. please input data in the correct data format");
		
		System.out.println("=========================================================");
		System.out.println(">> Please press ENTER key to continue..");
		sc.next();
	}
	
	public void ModifyMenu() {
		
	}
	
	public void DeleteMenu() {
		
	}
	
	public void DeleteALLMenu() {
		
	}
}
