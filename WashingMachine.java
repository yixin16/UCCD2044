public class WashingMachine extends Product {

	private String type, color;
	private float washing_capacity;
	private int warranty_year;
	private float width, height, depth;

	public WashingMachine(String no, String name, int qty, double price, String type,
			String color, float washing_capacity, float width, float height, float depth, int warranty_year) {
		super(no, name, qty, price);
		this.type = type;
		this.color = color;
		this.washing_capacity = washing_capacity;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.warranty_year = warranty_year;
	}

	public String getType() {
		return type;
	}

	public String getColor() {
		return color;
	}

	public float getWashing_capacity() {
		return washing_capacity;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getDepth() {
		return depth;
	}


	public int getWarranty_year() {
		return warranty_year;
	}
	
	public double getInventoryValue() {

		return super.getInventoryValue();

	}

	@Override
	public String toString() {

		return "\nItem number\t: " + super.getItemNo() + "\nProduct name\t: " + super.getItemName()
				+ "\nType\t\t: " + type + "\nColor\t\t: " + color + "\nWashing Capacity (in Litres): " + washing_capacity
				+ "\nDimensions (WxHxD): " + this.width + " x " + this.height + " x " + this.depth + " mm"
				+ "\nWarranty year(s): " + this.warranty_year
				+ "\nQuantity available: " + super.getItemQuantity() 
				+ "\nPrice (RM)\t: " + String.format("%,.2f", super.getItemPrice()) 
				+ "\nInventory value (RM): " + String.format("%,.2f", this.getInventoryValue()) 
				+ "\nProduct status\t: " + super.getItemStatus();

	}
	
}
