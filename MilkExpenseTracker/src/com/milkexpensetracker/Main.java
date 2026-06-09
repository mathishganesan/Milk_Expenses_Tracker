package com.milkexpensetracker;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		MilkManagement mm = new MilkManagement();
		
		int ch=0;
		
		while(true) {
			System.out.println("============ Milk Expense Tracker ===========");
			System.out.println("1. Add Entry");
			System.out.println("2. Display Entries");
			System.out.println("3. Search Entry");
			System.out.println("4. Delete Entry");
			System.out.println("5. Total Milk Consumed");
			System.out.println("6. Total Expense");
			System.out.println("7. Monthly Expense Report");
			System.out.println("8. Exit");
			
			try {
				System.out.println("Enter your Choice : ");
				ch = scan.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Invalid Input");
				scan.nextLine();
				continue;
			}
			
			switch(ch) {
			case 1:
				mm.addEntry();
				break;
				
			case 2:
				mm.displayEntries();
				break;
				
			case 3:
				mm.searchAndDisplay();
				break;
				
			case 4:
				scan.nextLine();
				System.out.println("Enter Date : ");
				String date = scan.nextLine();
				mm.deleteEntry(date);
				break;
				
			case 5:
				mm.totalMilkConsumed();
				break;
				
			case 6:
				mm.totalExpense();
				break;
				
				
			case 7:
				mm.calculateMonthlyExpense();
				break;
				
			case 8:
				System.out.println("Thank you!!!");
				System.out.println("Program Exited...");
				scan.close();
				return;
				
			}
			
		}
	}
}
