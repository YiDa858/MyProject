package text3;

import java.util.Scanner;

public class Text3 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter a Binary string:");
		int a=in.nextInt();
		String s = Integer.toString(a);
		int ret=a;
		int flag=1;
		while(ret>10)
		{
			int i=ret%10;
			if(i>2)
			{
				flag=0;
				break;
			}
			ret/=10;
		}
		if(flag==1)
		{
			int b=Integer.parseInt(s, 2);
			System.out.println("The equivalent decimal number for binary \""+a+"\" is "+b);
		}
		else
		{
			System.out.println("Error:Invalid Binary String \""+a+"\"");
		}
	}

}
