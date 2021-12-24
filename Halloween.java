import java.util.Scanner;

public class Halloween 
	{
		 String name;
		 String treat;
		 String trick;
		public Halloween()
		{
			String name = " ";
			String treat = " ";
			String trick = " ";
		}
		public static String yourName(String prompt)
		{
			Scanner s = new Scanner(System.in);
			System.out.print(prompt);
			return s.next();
		}
		public static String theName(String s)
		{
			return s;
		}
	public static void main(String[] args) {
		Halloween Hal = new Halloween();
		System.out.println("Happy Halloween!");
		Hal.name = Hal.yourName("What is your name?:");
		System.out.println("Hello " + Hal.theName(Hal.name) + "! Would you like a trick or a treat?:");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 1 or 2 and discover a trick or treat: " );
		if (sc.nextInt() == 1){
			System.out.println("Please enjoy some sweet treats!" + " " + Hal.theName(Hal.name) + "!");
		}
		else if  (sc.nextInt() == 2){
			System.out.println("Cavities await you!" + " " + Hal.theName(Hal.name) + "!");
		}
		
	}

}
