import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StockManagement {
	
	// array for Product.
	static Product[] product;
	
	// display the welcome message to users
	public static void displayWelcome() {
		//java.util.Date date = new java.util.Date();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("eeee | MMM dd yyyy | HH:mm:ss a");
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println("<< Welcome to Store Management System >>");
		System.out.println(" " + dtf.format(now));
		System.out.println("\n==========================================");
		System.out.println("|\t\tCredit by:\t\t |\n|1. Hazal Yong Xin Tong\t2. Ngu Jian Le   |"
				+ "\n|3. Quah Yong Jun\t4. Tan Yi Xin    |");
		System.out.println("==========================================");
		System.out.println();
	}
	
	// get maximum number of product
	public static int getMaxProduct(Scanner input) {
		int max = 1;
		
		do {
			try {
				System.out.print("Please enter the number of product you wish to add into the inventory: ");
				max = input.nextInt();
				
				if (max < 0) 
				{
					System.out.println("Invalid number. Only accept positive values of 0 and above.");
				}
			}
			
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input. Only integer is accepted.Try again...");
				input.next(); // Clear the invalid input
				continue;
			}
			
			break;
			
		} while(true);
		
		return max;
	}
	
	
	public static int selectProduct(Product[] product, Scanner input) {
	    int num = 0;

	    do {
	        System.out.println("List of Products.");

	        // Display products
	        for (int i = 0; i < product.length; i++) 
	        {
	            System.out.println("\nProduct[" + (i + 1) + "] " );
	            System.out.println("----------------------------------------------");
	            System.out.println(product[i].toString());
	            System.out.println("----------------------------------------------");
	        }

	        try {
	            System.out.print("Select an item by entering the index: ");
	            num = input.nextInt();

	            // Validate the index given
	            if (num < 1 || num > product.length) 
	                System.out.println("Invalid input. Please try again...");
	            else 
	                break; // Break out of the loop if valid input is provided

	        } 
	        
	        catch (InputMismatchException e) 
	        {
	            System.out.println("Invalid input type. Please enter a valid number.");
	            input.next(); // Clear the invalid input
	        }

	    } while (true);

	    // Adjust the index to start from zero for array
	    return num - 1;
	}



	
	public static int displayMenu(Scanner input) {
		int choice = 0;
		
		do {
			
			try {
				System.out.println("\n\n\n============================================");
				System.out.println("<<\tMain Menu\t>>\n");
				System.out.println("1. View products");
				System.out.println("2. Add stock");
				System.out.println("3. Deduct stock");
				System.out.println("4. Discontinue product");
				System.out.println("0. Exit");
				System.out.println("============================================");
				System.out.print("\nPlease enter a menu option: ");
				choice = input.nextInt();
				
				if (choice < 0 || choice > 4) {
					System.out.println("Invalid option input. Try again...");
				}
				
				else
					break;
				
			}
			
			catch (InputMismatchException e) {
	            System.out.println("Invalid input type. Please enter a valid number.");
	            input.next(); // Clear the invalid input
	        }
			
		}while(choice < 0 || choice > 4);
		
		return choice;
	}
	
	// add stock value to each identified product
	public static void addStock(Product[] product, Scanner input) {
		int select, qty=0;
		
		// reuse the selectProduct method to display and prompt user selection
		select = selectProduct(product, input);
		System.out.println("=================================================");
		System.out.println("Product Details: " + product[select].toString());
		System.out.println("=================================================");
			
			// Validate the quantity 
		do {
			try {
				System.out.print("Enter the number of product to add: ");
				qty = input.nextInt();
				
				if (qty < 0)
				{
					System.out.println("Invalid quantity entered. Must be greater than zero! \nTry again...");
				}
				
				else
				{
					product[select].addItemQuantity(qty);
					break;
				}
			}
			
			
			catch (InputMismatchException e) {
	            System.out.println("Invalid input type. Please enter a valid number.");
	            input.next(); // Clear the invalid input
	        }
			
		}while(true);
		
	}
	
	// deduct stock values to each identified product
	public static void deductStock(Product[] product, Scanner input) {
		int select, qty = 0;
		
		// reuse the selectProduct method to display and prompt user selection
		select = selectProduct(product, input);
		int current = product[select].getItemQuantity();
		System.out.println("================================================");
		System.out.println("\nProduct Details: " + product[select].toString());
		System.out.println("================================================");
			
		// Validate the quantity 
		do {
			
			try {
				System.out.print("Enter the number of product to deduct: ");
				qty = input.nextInt();
				
				if (qty < 0)
				{
					System.out.println("Invalid quantity entered. Must be greater than zero! \nTry again...");
				}
				
				if (qty > current) {
					System.out.printf("\nThere is currently only %d items in stock. \n",current);
					System.out.println("Please try again with quantity smaller than the current inventory.");
				}
				
				else
				{
					product[select].deductItemQuantity(qty);
					break;
				}
			}
			
			
			catch (InputMismatchException e) {
	            System.out.println("Invalid input type. Please enter a valid number.");
	            input.next(); // Clear the invalid input
	        }
			
		}while(true);
		
	}
	
	public static void setProductStatus(Product[] product, Scanner input) {
	    System.out.println("Please enter the product you wish to set status on: ");

	    // Select the product
	    int choice = selectProduct(product, input);

	    // Check if the selected index is valid
	    if (choice >= 0 && choice < product.length && product[choice] != null) {
	        // Set the status of the selected product to discontinued
	        product[choice].setItemStatus(false);
	        System.out.println("Product " + product[choice].getItemName() + " has been discontinued.");
	    } 
	    
	    else 
	        // The selected product cannot be found
	        System.out.println("Product cannot be found.");
	}

	
public static void executeMenu(int choice, Product[] product, Scanner input) {
		
		switch(choice) {
		
		case 1: 
			System.out.println();
			System.out.println("\n----------------Displaying Product----------------");

			try {
				for(int i = 0; i < product.length; i++) {
					System.out.println("\t\t[Product " + (i+1) + "]");
					System.out.println("=================================================");
					System.out.println("\nProduct Details: " + product[i].toString());
					System.out.println("=================================================\n\n");
				}
			}
			catch(NullPointerException e){
				System.out.println("There are no product in the inventory yet...");
			}
			break;
			
		case 2:
			System.out.println("-----------------Adding Product Stock----------------");
			addStock(product, input);
			break;
			
			
		case 3:
			System.out.println("----------------Deducting Product Stock---------------");
			deductStock(product, input);
			break;
			
		
		case 4:
			System.out.println("----------------Changing Status of Product---------------");
			setProductStatus(product, input);
			break;
			
		}
			
	}
	
	
	
	
	public static void addProduct(Product[] product, Scanner input) {
		
		int choice = 0;
		
		do {
			
			try {
				System.out.println("********** Adding a New Product to the Ivnentory **********");
				System.out.println("-----------------------------------------------------------");
				System.out.println("\t\t\t1. Refrigerator");
				System.out.println("\t\t\t2. TV");
				System.out.println("\t\t\t3. Washing Machine");
				System.out.println("-----------------------------------------------------------");
				// input.nextLine();
				System.out.print("Enter product type you want to add: ");
				choice = input.nextInt();
				
				if(choice == 1 || choice == 2 || choice == 3) 
					break;
				
				else {
					System.out.println("Only number 1 or 2 or 3 is allowed to enter. Try again...");
				}
				
			}
			
			catch (InputMismatchException e) {
	            System.out.println("Invalid input type. Please enter a valid number.");
	            input.next(); // Clear the invalid input
	        }
			
		}while(true);
		
		
		switch(choice) {
		
		case 1:
			//public static void addRefrigerator(Product[] product, Scanner input, int current) {
			addRefrigerator(product, input);
			System.out.print("Press [ENTER] to continue.");
			input.nextLine();
			break;
			
		case 2:
			addTV(product, input);
			System.out.print("Press [ENTER] to continue.");
			input.nextLine();
			break;
			
		case 3:
			addWashingMachine(product, input);
			System.out.print("Press [ENTER] to continue.");
			input.nextLine();
			break;
		}
	}
	
	public static void addRefrigerator(Product[] product, Scanner input) {
	    // Find the first null element in the product array
	    int index = 0;
	    while (index < product.length && product[index] != null)
	        index++;
	    

	    // Check if there is space in the array
	    if (index < product.length) 
	    {
	        input.nextLine(); // Clear the input buffer

	        // Refrigerator attributes
	        String name, design, color, no;
	        int capacity, qty;
	        double price;

	        System.out.println("\n\n****------------ Adding a New Refrigerator: -----------****");
	        System.out.print("Refrigerator Name: ");
	        name = input.nextLine();
	        System.out.print("Door Design: ");
	        design = input.nextLine();
	        System.out.print("Color: ");
	        color = input.nextLine();
	        System.out.print("Capacity (in Litres): ");
	        capacity = input.nextInt();
	        System.out.print("Quantity available in stock: ");
	        qty = input.nextInt();
	        System.out.print("Price (RM): ");
	        price = input.nextDouble();
	        input.nextLine(); // Consume newline character

	        System.out.print("Item No: ");
	        no = input.nextLine();
	        System.out.println("****-------------------------------------****");
	        // Add new product into array
	        product[index] = new Refrigerator(no, name, qty, price, design, color, capacity);
	        System.out.println("*** Item has been successfully added into Inventory.");
	        System.out.println("Item Details:");
	        System.out.println(product[index]); // Print product details
	    } 
	    
	    else
	        System.out.println("Inventory is full. Cannot add more products.");

	}

	
	public static void addTV(Product[] product, Scanner input) {
	    // Find the first null element in the product array
	    int index = 0;
	    while (index < product.length && product[index] != null) {
	        index++;
	    }

	    // Check if there is space in the array
	    if (index < product.length) {
	        // TV attributes
	        String no, name, screenType, res;
	        int qty;
	        double price;
	        float displaySize;

	        System.out.println("\n***--------------- Adding a New TV: ---------------***");
	        boolean validInput;
	        
	        do {
	            validInput = true; // Assume input is valid
	            try {
	            	input.nextLine();
	                System.out.print("Product Name: ");
	                name = input.nextLine();
	                System.out.print("Screen Type: ");
	                screenType = input.nextLine();
	                System.out.print("Resolution: ");
	                res = input.nextLine();
	                System.out.print("Display Size: ");
	                displaySize = input.nextFloat();
	                System.out.print("Quantity available in stock: ");
	                qty = input.nextInt();
	                input.nextLine(); // Consume newline character
	                System.out.print("Price (RM): ");
	                price = input.nextDouble();
	                input.nextLine(); // Consume newline character

	                System.out.print("Item No: ");
	                no = input.nextLine();
	                System.out.println("****-------------------------------------****");

	                // Add new product into array
	                // public TV(String no, String name, int qty, double p, String type, String res, float size) {
	                product[index] = new TV(no, name, qty, price, screenType, res, displaySize);

	                System.out.println("*** Item has been successfully added into Inventory.");
	                System.out.println("Item Details:");
	                System.out.println(product[index]); // Print product details
	            } 
	            
	            catch (InputMismatchException e) 
	            {
	           
	                System.out.println("Invalid input format. Please enter the correct data format.");
	                input.nextLine(); // Consume the newline character
	                validInput = false; // Set flag to false to repeat the loop
	            }
	            
	        } while (!validInput); // Repeat the loop if input is invalid
	    } 
	    
	    else 
	    	System.out.println("Inventory is full. Cannot add more products.");
	
	}
	
	
	public static void addWashingMachine(Product[] product, Scanner input) {
		
		// Find the first null element in the product array
	    int index = 0;
	    while (index < product.length && product[index] != null) {
	        index++;
	    }

	    // Check if there is space in the array
	    if (index < product.length) {

	    	String no, name, type, color;
	    	int qty, year;
	    	float width, height, depth, capacity;
	    	double price;

	        System.out.println("\n***--------------- Adding a New Washing Machine: ---------------***");
	        boolean validInput;
	        
	        do {
	            validInput = true; // Assume input is valid
	            try {
	            	input.nextLine();
	                System.out.print("Product Name: ");
	                name = input.nextLine();
	                System.out.print("Machine Type: ");
	                type = input.nextLine();
	                System.out.print("Color: ");
	                color = input.nextLine();
	                System.out.print("Capacity (in Litres): ");
	                capacity = input.nextFloat();
	                System.out.print("Width (mm)\t: ");
	        		width = input.nextFloat();
	        		System.out.print("Height (mm)\t: ");
	        		height = input.nextFloat();
	        		System.out.print("Depth (mm)\t: ");
	        		depth = input.nextFloat();
	        		System.out.print("Warranty period(in year): ");
	        		year = input.nextInt();
	        		System.out.print("Quantity available in stock: ");
	        		qty = input.nextInt();
	        		System.out.print("Price (RM)\t: ");
	        		price = input.nextDouble();
	        		input.nextLine();
	                System.out.print("Item No: ");
	                no = input.nextLine();

	                System.out.println("****-------------------------------------****");
	                // public WashingMachine(String no, String name, int qty, double price, String type,
	    			//String color, float washing_capacity, float width, float height, float depth, int warranty_year) {
	                
	                product[index] = new WashingMachine(no, name, qty, price, type, color, capacity, width, height, depth, year);

	                System.out.println("*** Item has been successfully added into Inventory.");
	                System.out.println("Item Details:");
	                System.out.println(product[index]); // Print product details
	            } 
	            
	            catch (InputMismatchException e) 
	            {
	           
	                System.out.println("Invalid input format. Please enter the correct data format.");
	                input.nextLine(); // Consume the newline character
	                validInput = false; // Set flag to false to repeat the loop
	            }
	            
	        } while (!validInput); // Repeat the loop if input is invalid
	    } 
	    
	    else 
	    	System.out.println("Inventory is full. Cannot add more products.");
	
	
	}

	
	public static void inventory(Scanner input) {
		int num = getMaxProduct(input);
		product = new Product[num];
		
		for(int i = 0; i < num; i++) {
			System.out.println("\n[Product " + (i + 1) + "]");
			addProduct(product, input); 
		}
	}

// main() method
	// main() method
		public static void main(String[] args) {
		    Scanner input = new Scanner(System.in);
		    int option = 0, menuOption;
		    
		    displayWelcome();
		    
		    // Generate ID for session login user
		    UserInfo login = new UserInfo();
		    login.setName(input);
		    login.generateUserID();
		    String name = login.getName(), id = login.getUserID();

		    do {
		        try {
		            System.out.println("\n\nDo you wish to add any product? ");
		            System.out.println("[0]: No\n[1]: Yes");
		            System.out.print(">>> ");
		            option = input.nextInt();
		            
		            if (option == 0) 
		            {
		                // When user does not want to add any product
		                int confirm = 0; // Initialize the confirm to 09
		                
		                do {
		                	
		                    try {	                    	
		                        System.out.println("\nSince you didn't wish to add product. Do you wish to exit the program?");
		                        System.out.println("[0] exit\t\t[1] No");
		                        System.out.print(">>> ");
		                        confirm = input.nextInt();
		                        if (confirm == 0)
		                        {
		                            // Exiting Program
		                            System.out.println("===============================================");
		                            System.out.println("Exitinh Program");
		                            System.out.println("Name of user: " + name);
		                            System.out.println("Session userID: " + id);
		                            System.out.println("===============================================");
		                            System.out.println("**************** Session Ended ****************");
		                            System.out.println("\t\t\tGoodbye!");
		                            System.exit(0);
		                        } 
		                        
		                        else if (confirm == 1) 
		                        {
		                        	
		                        	System.out.println("**Note: If you wish to stay in the program. Please add product.");
		                        	product = new Product[getMaxProduct(input)];
		                            // Return to the inventory page
		                            inventory(input);
		                            if (product.length == 0) 
		                                System.out.println("No items in the inventory currently...");
		                            
		                            
		                            else 
		                            {
		                                do {
		                                    // Display menu to the user so that they can choose the service option
		                                    menuOption = displayMenu(input);
		                                    if (menuOption == 0) {
		                                    	// Exiting Program
		    		                            System.out.println("===============================================");
		    		                            System.out.println("Exitinh Program");
		    		                            System.out.println("Name of user: " + name);
		    		                            System.out.println("Session userID: " + id);
		    		                            System.out.println("===============================================");
		    		                            System.out.println("**************** Session Ended ****************");
		    		                            System.out.println("\t\t\tGoodbye!");
		    		                            System.exit(0);
		                                    }
		                                    executeMenu(menuOption, product, input);
		                                } while (menuOption != 0);
		                            }
		                        } 
		                        
		                        else 
		                        
		                        {
		                            System.out.println("Only Numbers [0] or [1] are accepted. Try again...");
		                        }
		                        
		                    } 
		                    
		                    catch (InputMismatchException e) 
		                    {
		                        System.out.println("Only digits are accepted. Try again...");
		                        input.next(); // Clear the invalid input
		                        continue;
		                    }
		                    
		                } while (true);
		            }
		            
		            else if (option == 1) 
		            {
		                // User wishes to add a product
		                inventory(input);
		                if (product.length == 0) 
		                {
		                    System.out.println("No items in the inventory currently...");
		                } 
		                
		                
		                else 
		                {
		                    do {
		                        // Display menu to the user so that they can choose the service option
		                        menuOption = displayMenu(input);
		                        if (menuOption == 0) {
		                            // Exit the program
		                            System.out.println("\n\n===============================================");
		                            System.out.println("Exiting Program");
		                            System.out.println("Name of user: " + name);
		                            System.out.println("Session userID: " + id);
		                            System.out.println("===============================================");
		                            System.out.println("**************** Session Ended ****************");
		                            System.out.println("Goodbye!");
		                            System.exit(0);
		                        }
		                        executeMenu(menuOption, product, input);
		                    } while (menuOption != 0);
		                }
		            } 
		            
		            else 
		                System.out.println("Only Numbers [0] or [1] are accepted. Try again...");
		            
		            
		            break; 
		            
		        } 
		        
		        catch (InputMismatchException e) 
		        {
		            System.out.println("Invalid input type. Please enter a valid number.");
		            input.next(); // Clear the invalid input
		            continue;
		        }
		        
		    } while (true);
		    
		    input.close();
		}
}