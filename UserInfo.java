import java.util.Scanner;

public class UserInfo {

	private String user_name, user_id;
	
	public UserInfo() {
		
	}
	
	public UserInfo(String name, String id) {
		this.user_name = name;
		this.user_id = id;
	}
	
	public void setName(Scanner input) {
		System.out.print("Enter your full name with spacing: ");
		this.user_name = input.nextLine();
	}
	
	public String getName() {
		return this.user_name;
	}
	
	public boolean checkSpacing() {
		if(user_name.contains(" ")) 
			return true;
		else
			return false;
	}
	
	public void generateUserID() {
		if(checkSpacing() == true) {
			// get the position of the last space
			int position = this.user_name.lastIndexOf(" ");
						
			// get the first character of the input name
			String a = this.user_name.substring(0,1);
						
			// get the string after the last spacing
			String b = this.user_name.substring(position+1);
						
			// set the id
			this.user_id = a + b;
		}
		
		else
			this.user_id = "guest";
	}
	
	public String getUserID() {
		return this.user_id;
	}
}
