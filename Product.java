
public abstract class Product {

	private String item_name,  item_no;
	private int item_quantity;
	private double item_price;
	private boolean item_status = true;
	
	// default constructor
	public Product() {
		
	}
	
	// parameterized constructor
	public Product(String no, String name, int qty, double p) {
		this.item_no = no;
		this.item_name = name;
		this.item_quantity = qty;
		this.item_price = p;
	}
	
	public void setItemName(String name) {
		this.item_name = name;
	}
	
	public String getItemName() {
		return this.item_name;
	}

	
	public void setItemQuantity(int qty) {
		this.item_quantity = qty;
	}
	
	public int getItemQuantity() {
		return this.item_quantity;
	}
	
	
	public void setItemNo(String no) {
		this.item_no = no;
	}
	
	public String getItemNo() {
		return this.item_no;
	}
	
	public void setItemPrice(double price) {
		this.item_price = price;
	}
	
	public double getItemPrice() {
		return this.item_price;
	}
	
	public void setItemStatus(boolean status) {
		this.item_status = status;
	}
	
	public boolean getItemStatus() {
		return this.item_status;
	}
	
	
	public double getInventoryValue() {
		return item_price * item_quantity;
	}
	
	public void addItemQuantity(int qty) {
		// discountinued product line
		if(this.item_status == false)
			System.out.printf("/nSorry, the item[%d]: {%s} has been discountinued.", getItemNo(), getItemName());
		else {
			int current = getItemQuantity();
			this.setItemQuantity(this.getItemQuantity() + qty);
			System.out.printf("\nProduct No: [%s]: \nProduct Name: {%s}.\nThe product's quantity has been updated.", getItemNo(), getItemName());
			System.out.printf("\nPrevios stock: %d \nCurrent stock: %d", current, this.getItemQuantity());
			System.out.println();
		}
	}
	
	public void deductItemQuantity(int qty) {
		if(qty > this.getItemQuantity())
		{
			System.out.println("*Note: Invalid Deduction on the stock.");
			System.out.println("Your deduction quantity exceed the inventory stock");
		}
		else {
			int current = getItemQuantity();
			this.setItemQuantity(this.getItemQuantity() - qty);
			System.out.printf("\nThehe item [%s]: {%s}'s quantity has been updated.\n", getItemNo(), getItemName());
			System.out.printf("\nPrevios stock: %d \nCurrent stock: %d\n\n", current, getItemQuantity());
			System.out.println();
		}
	}
	
	@Override
	public String toString() {
		return "Item number\t: " + item_no + "\nProduct name\t: " + item_name 
				+ "\nQuantity available: " + item_quantity + "\nPrice (RM)\t: " 
				+ String.format("%,.2f", item_price) 
				+ "\nInventory value (RM): " + String.format("%,.2f", this.getInventoryValue()) 
				+ "\nProduct status\t: " + this.getItemStatus();
	}
}
