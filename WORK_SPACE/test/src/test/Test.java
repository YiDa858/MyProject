package test;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		System.out.printf("%tc\n",new Date());
		System.out.printf("%1$s %2$tB %2$te %2$tY", "Due Date:",new Date());
//		System.out.printf("%s %tB %<te %<tY", "Due Date:",new Date());
	}
}
