import java.util.Scanner;
public class Time {

	public static void main(String[] args) {
		System.out.println("Enter in the number of seconds as an integer:");
		Scanner keyboard=new Scanner(System.in);
		int input=keyboard.nextInt();
		int hours=(input/60)/60;
		int minutes=(input%3600)/60;
		int seconds=(input%3600)%60;
		System.out.println(input +" seconds is equivalent to " + hours + " hours " + minutes + " minutes and " +seconds +" seconds.");

	}

}
