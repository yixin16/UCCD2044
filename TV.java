
public class TV extends Product {

	private String screen_type, resolution;
	private float display_size;
	
	public TV(String no, String name, int qty, double price, String type, String res, float size) {
		super(no, name, qty, price);
		this.screen_type = type;
		this.resolution = res;
		this.display_size = size;
	}
	

	public void setScreenType(String type) {
		this.screen_type = type;
	}
	
	public String getScreenType() {
		return this.screen_type;
	}
	
	public void setResolution(String res) {
		this.resolution = res;
	}
	
	public String getResolution() {
		return this.resolution;
	}
	
	public void setDisplaySize(float size) {
		display_size = size;
	}
	
	public float getDisplaySzie() {
		return this.display_size;
	}
	
	public double getInventoryValue() {
		return super.getInventoryValue();
	}
	
	@Override
	public String toString() {
		return "\nItem number\t: " + super.getItemNo() + "\nProduct name\t: " + super.getItemName() 
		+ "\nScreen Type\t: " + screen_type + "\nResolution\t: " + resolution 
		+ "\nDisplay size\t: " + display_size + "\nQuantity available: " + super.getItemQuantity()
		+ "\nPrice (RM)\t: " + String.format("%,.2f", super.getItemPrice())
		+ "\nInventory value(RM): " + String.format("%,.2f", this.getInventoryValue()) 
		+ "\nProduct status\t: " + super.getItemStatus(); 
	}
	
}
