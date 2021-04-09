package text4;

import java.util.Scanner;

public class Text4 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String[] hexbits= {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
		System.out.println("Enter a Hexadecimal string:");
		String a=in.nextLine();
		char[] ret=a.toCharArray();
		System.out.print("The equivalent binary for hexadecimal \""+a+"\" is");
		for(int i:ret)
		{
			switch(i)
			{
				case '0':System.out.print(" "+hexbits[0]);break;
				case '1':System.out.print(" "+hexbits[1]);break;
				case '2':System.out.print(" "+hexbits[2]);break;
				case '3':System.out.print(" "+hexbits[3]);break;
				case '4':System.out.print(" "+hexbits[4]);break;
				case '5':System.out.print(" "+hexbits[5]);break;
				case '6':System.out.print(" "+hexbits[6]);break;
				case '7':System.out.print(" "+hexbits[7]);break;
				case '8':System.out.print(" "+hexbits[8]);break;
				case '9':System.out.print(" "+hexbits[9]);break;
				case 'a':System.out.print(" "+hexbits[10]);break;
				case 'b':System.out.print(" "+hexbits[11]);break;
				case 'c':System.out.print(" "+hexbits[12]);break;
				case 'd':System.out.print(" "+hexbits[13]);break;
				case 'e':System.out.print(" "+hexbits[14]);break;
				case 'f':System.out.print(" "+hexbits[15]);break;
			}
		}
	}

}
