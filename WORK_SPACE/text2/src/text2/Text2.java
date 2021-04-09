package text2;

import java.util.Scanner;

public class Text2 {

	public static void main(String[] args) {
		Scanner in = new Scanner ( System.in );
		System.out.println("Enter an integer:");
		int a=in.nextInt();
		System.out.println("Enter a floating point number:");
		float b=in.nextFloat();
		System.out.println("Enter your name:");
		String s=in.next();
		System.out.println("Hi!"+s+",the sum of "+a+" and "+b+" is "+(a+b));
	}

}
