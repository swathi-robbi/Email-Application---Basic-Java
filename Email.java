package emailapp;  
import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String departnment;
	private String email;
	private int mailBoxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	//Constructor to receive the first name and last name
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		
		System.out.println("Email Created:"+ this.firstName +" " + this.lastName );
		
		//Call method asking for department - return department
		this.departnment = setDepartment();
		System.out.println("Department:" + this.departnment);
		
		//Call to generate random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("The Password is: "+ this.password);
		
		//Combine elements to join email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + departnment + "." + companySuffix;
		System.out.println("Email created is:" + email);
	}
	
	//Ask for department
	private String setDepartment(){
		System.out.print("Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for other\nEnter Department Code:");
		
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		
		if(departmentChoice == 1) return "sales";
		else if (departmentChoice == 2) return "dev";
		else if (departmentChoice == 3) return "acc";
		else return "";
	}
	
	//Generate random password
	private String randomPassword(int length){
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZZ0123456789!@#$";
		char[] password = new char[length];
		
		for(int i=0;i<length;i++){
			
			//default random() return number between 0 and 1.
			int random = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(random);
		}
		
		return new String(password);
	}
	
	//Set mailbox capacity
	public void setMailboxCapcity(int capacity){
		this.mailBoxCapacity = capacity;
	}
	
	//get mailbox capacity
	public int getMailBoxCapacity(){
		return this.mailBoxCapacity;
	}
	
	//set alternate email
	public void setAlternateEmail(String altEmail){
		this.alternateEmail = altEmail;
	}
	
	//get alternate email
	public String getAlternateEmail(){
		return this.alternateEmail;
	}
	
	//change password
	public void changePassword(String changepswd){
		this.password = changepswd;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String showInfo(){
		return "Display Name: " + firstName + " " + lastName +
		"\nEmail: " + email + "\nMaximum Capacity: " + mailBoxCapacity;
	}
	
	
}
