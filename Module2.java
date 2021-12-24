import java.util.Scanner;
// Created by: Jason Dockery
// Finished program: 10/24/2019

public class Module2 
	{
		static String firstName;
		static String middleName;
		static String lastName;
		
	public Module2() 
	{
		String firstName = "";
		String middleName = "";
		String lastName = "";
	}
	public static String monogram(String s, String t)  
	{
		return s.substring(0,1) + t.substring(0,1);
	}
	public static String monogram(String s, String t, String u)
	{
		return s.substring(0,1) + t.substring(0,1) + u.substring(0,1);
	}
	public static String completeName(String s, String t)
	{
		return s + " " + t;
	}
	public static String completeName(String s, String t, String u)
	{
		return s + " " + t + " " + u;
	}
	public static String getName(String prompt)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println(prompt);
		return scan.nextLine();
	}
	public static void main(String[] args) 
	{
		Module2 m2 = new Module2();
		System.out.println("starting application");
		firstName = m2.getName("Please enter your first name: ");
		middleName = m2.getName("Please enter your middle name: ");
		lastName = m2.getName("Please enter your last name: ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter #2 in order to generate a monogram and complete name using your first & last name.");
		System.out.println("Or");
		System.out.println("Enter #3 in order to generate a monogram and complete name using your first & middle & last name.");
		System.out.println("What is your number?: ");
		//enter two or three
		if(sc.nextInt() == 2)
		{
			System.out.println("Two name monogram: " + m2.monogram(firstName, lastName));
			System.out.println("Complete name: " + m2.completeName(firstName, lastName));
			//enter three again
		}else if(sc.nextInt() == 3)
		{
			System.out.println("Three name monogram: "+ m2.monogram(firstName, middleName, lastName));
			System.out.println("Complete name: " + m2.completeName(firstName, middleName, lastName));
		}
		System.out.println("Ending application.");
	}
}
