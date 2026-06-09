package com.milkexpensetracker;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.BufferedReader;
import java.util.Scanner;
public class MilkManagement {
	Scanner scan = new Scanner(System.in);
	private ArrayList<MilkEntry> entries;
	
	public MilkManagement() {
		entries = new ArrayList<MilkEntry>();
		loadEntries();
	}
	
	public MilkEntry searchDate(String date) {
		/*for(int i =0;i<=entries.size();i++) {
			if(date.equals(entries.get(i).getDate())) {
				return entries.get(i);
			}
		}*/
		
		for(MilkEntry entry : entries) {
			if(date.equals(entry.getDate())) {
				return entry;
			}
		}
		return null;
	}
	
	public void addEntry() {
		System.out.println("Enter Date : ");
		String date = scan.nextLine();
		
		if(searchDate(date) !=null) {
			System.out.println("Entry Already Exists");
		}else {
			System.out.println("Enter Morning Milk : ");
			double mrngMilk = scan.nextDouble();
			
			System.out.println("Enter Evening Milk : ");
			double evngMilk = scan.nextDouble();
			
			System.out.println("Enter Price ₹ Per Liter : ");
			double ppLiter = scan.nextDouble();
			
			scan.nextLine();
			
			MilkEntry me = new MilkEntry(date,mrngMilk,evngMilk,ppLiter);
			entries.add(me);
			
			saveEntries();
			
			System.out.println("Entry Added Successfully...");
		}
	}
	
	public void displayEntries() {
		if(entries.isEmpty()) {
			System.out.println("No Entries Found!!!");
		}else {
			for(MilkEntry entry : entries) {
				entry.display();
			}
		}
	}
	
	public void deleteEntry(String dat) {
		MilkEntry dt = searchDate(dat);
		if(dt!=null) {
			entries.remove(dt);
			saveEntries();
			System.out.println("Entry Deleted Successfully...");
		}else {
			System.out.println("Entry Not Found!!!");
		}
	}
	
	public void totalMilkConsumed() {
		double totalMilk = 0;
		for(MilkEntry entry : entries) {
			totalMilk += entry.getTotalMilk();
		}
		
		System.out.println("Total Milk Consumed : "+totalMilk);
	}
	
	public void totalExpense() {
		double totalExpense = 0;
		for(MilkEntry entry : entries) {
			totalExpense += entry.getDailyExpenses();
		}
		
		System.out.println("Total Expense : "+totalExpense);
	}
	
	public void searchAndDisplay() {
		System.out.println("Enter Date : ");
		String dt = scan.nextLine();
		
		MilkEntry entry = searchDate(dt);
		if(entry != null) {
			entry.display();
		}else {
			System.out.println("Entry Not Found!!!");
		}
	}
	
	public void saveEntries() {
		try {
			FileWriter fw = new FileWriter("Data/MilkData.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(MilkEntry entry : entries) {
				String line = entry.getDate()+","+entry.getMorningMilk()+","+entry.getEveningMilk()+","+entry.getPricePerLiter();
				bw.write(line);
				bw.newLine();
			}
			
			bw.close();
			
		}catch(Exception e) {
			System.out.println("Something Went Wrong!!!");
		}
	}
	
	public void loadEntries() {
		entries.clear();
		try {
			FileReader fr = new FileReader("Data/MilkData.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line=br.readLine()) !=null) {
				String [] data = line.split(",");
				
				String date = data[0];
				double morningMilk = Double.parseDouble(data[1]);
				double eveningMilk = Double.parseDouble(data[2]);
				double pricePerLiter = Double.parseDouble(data[3]);
				
				MilkEntry entry = new MilkEntry(date,morningMilk,eveningMilk,pricePerLiter);
				entries.add(entry);
			}
			br.close();
			
		}catch(Exception e) {
			System.out.println("Something Went Wrong!!!");
		}
	}
	
	public void calculateMonthlyExpense() {
		double totalMilk=0;
		double totalExpense=0;
		
		for(MilkEntry entry: entries) {
			double dailyMilk = entry.getMorningMilk()+entry.getEveningMilk();
			totalMilk += dailyMilk;
			
			totalExpense += dailyMilk * entry.getPricePerLiter();
			}
		  System.out.println("Total Milk in Month: " + totalMilk + " L");
		  System.out.println("Total Expense in Month: ₹" + totalExpense);
	}
}
