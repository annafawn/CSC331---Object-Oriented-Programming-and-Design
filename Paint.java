package test1;

public class Paint {
	
	// Properties
	private String name;
	private int redContent;
	private int greenContent;
	private int blueContent;
	private double price;
	
	// Constructor
	public Paint(String name, int red, int green, int blue, double price) {
		this.name = name;
		redContent = red;
		greenContent = green;
		blueContent = blue;
		this.price = price;
	}
	
	
	// Behavior
	public String getName() {
		return name;
	}
	
	public int getRed() {
		return redContent;
	}
	
	public int getGreen() {
		return greenContent;
	}
	
	public int getBlue() {
		return blueContent;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return "name = " + name +", red = " + redContent + ", green = " + greenContent + ", blue = " + blueContent + ", price = " + price;
	}
	
	public boolean equals(Paint other) {
		if (redContent == other.redContent && greenContent == other.greenContent && blueContent == other.blueContent) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Paint mix(Paint other) {
//		String newName = name + " " + other.name;
		String newName = name + " " + other.getName();
//		int newRed = (redContent + other.redContent) / 2;
		int newRed = (redContent + other.getRed()) / 2;
//		int newGreen = (greenContent + other.greenContent) / 2;
		int newGreen = (greenContent + other.getGreen()) / 2;
//		int newBlue = (blueContent + other.blueContent) / 2;
		int newBlue = (blueContent + other.getBlue()) / 2;
//		double newPrice = (price + other.price) / 2;
		double newPrice = (price + other.getPrice()) / 2;
		Paint newPaint = new Paint(newName, newRed, newGreen, newBlue, newPrice);
		return newPaint;
		
	}
	
	public double distanceTo(Paint other) {
		return Math.sqrt(Math.pow(redContent - other.redContent, 2) + Math.pow(greenContent - other.greenContent, 2) + Math.pow(blueContent - other.blueContent, 2));
	}
	
	public void updatePrice(double newPrice) {
		price = newPrice;
	}

}
