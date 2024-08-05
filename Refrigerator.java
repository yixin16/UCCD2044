
public class Refrigerator extends Product{

	private String door_design, color;
	private int capacity;
	
	// public Product(int n, String name, int qty, double p)
	public Refrigerator(String no, String name, int qty, double p,
			String design, String color, int capacity) {
		super(no, name, qty, p);
		this.door_design = design;
		this.color = color;
		this.capacity = capacity;
	}
	
	public void setDoorDesign(String d) {
		this.door_design = d;
	}
	
	public String getDoorDesign() {
		return this.door_design;
	}
	
	public void setColor(String c) {
		this.color = c;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setCapacity(int c) {
		this.capacity = c;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	// method to calculate the value of the stock of refrigirator
	public double getInventoryValue() {
		return super.getInventoryValue(); // inherit from Product
	}
	
	@Override
	public String toString() {
		return "\nItem number\t: " + super.getItemNo() + "\nProduct name\t: " + super.getItemName() 
		+ "\nDoor design\t: " + door_design + "\nColor\t\t: " + color 
		+ "\nCapacity (in Litres): " + capacity
		+ "\nQuantity available: " + super.getItemQuantity() + "\nPrice (RM)\t: " 
		+ String.format("%,.2f", super.getItemPrice()) 
		+ "\nInventory value (RM): " + String.format("%,.2f", this.getInventoryValue()) 
		+ "\nProduct status\t: " + super.getItemStatus();
	}
}
