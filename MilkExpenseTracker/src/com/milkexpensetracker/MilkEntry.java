package com.milkexpensetracker;

public class MilkEntry {
	private String date;
	private double morningMilk;
	private double eveningMilk;
	private double pricePerLiter;
	
	public MilkEntry(String date,double morMilk,
					double evnMilk,double ppLiter){
		this.date = date;
		this.morningMilk = morMilk;
		this.eveningMilk = evnMilk;
		this.pricePerLiter = ppLiter;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String dt) {
		this.date = dt;
	}
	
	public double getMorningMilk() {
		return morningMilk;
	}
	
	public void setMorningMilk(double milk) {
		this.morningMilk =milk;
	}
	
	public double getEveningMilk() {
		return eveningMilk;
	}

	public void setEveningMilk(double eveningMilk) {
		this.eveningMilk = eveningMilk;
	}
	public double getPricePerLiter() {
		return pricePerLiter;
	}

	public void setPricePerLiter(double pricePerLiter) {
		this.pricePerLiter = pricePerLiter;
	}
	
	public double getTotalMilk() {
		return morningMilk+eveningMilk;
	}
	
	public double getDailyExpenses() {
		return getTotalMilk()*pricePerLiter;
	}
	
	
	public void display() {
		System.out.println("-------- Milk Entry --------");
		System.out.println("Date : "+date);
		System.out.println("Morning Milk : "+morningMilk+" L");
		System.out.println("Evening Milk : "+eveningMilk+" L");
		System.out.println("Total Milk : "+getTotalMilk()+" L");
		System.out.println("Daily Expense : "+getDailyExpenses());
		System.out.println("------------------------------");
	}
}
