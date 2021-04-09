package text6;

import java.util.Scanner;
//import java.time.DayOfWeek;
//import java.time.LocalDate;

public class Text6 {

	public static void main(String[] args) {
		double[] weekdays= {0,0,0,0,0,0,0};
		Scanner in=new Scanner(System.in);
		//����������
		int year,month,day;
		year=in.nextInt();
		month=in.nextInt();
		day=in.nextInt();
		for(int q=year;q<=2021;q++)
		{
			//�ж��Ƿ�Ϊ����
			boolean isLeapYear=((q%4==0&&q%100!=0)||q%400==0)?true:false;
		//����ÿһ���Ӧ��������
		int days=31;
		switch(month)
		{
			case 2:days=isLeapYear?29:28;
			case 4:days=30;break;
			case 6:days=30;break;
			case 9:days=30;break;
			case 11:days=30;break;
		}
		int[] a=new int[days];
		//��������
		final String head="����\t��һ\t�ܶ�\t����\t����\t����\t����";
		//ͳ��������
		int sum=0;
		for(int i=1990;i<q;i++)
		{
			sum+=((i%4==0&&i%100!=0)||i%400==0)?366:365;
		}
		for(int i=1;i<month;i++)
		{
			int max=31;
			switch(i)
			{
				case 2:max=isLeapYear?29:28;break;
				case 4:max=30;break;
				case 6:max=30;break;
				case 9:max=30;break;
				case 11:max=30;break;
			}
			sum+=max;
		}
		//�����ڴ���������
		sum=sum%7+1;
		for(int i=0;i<a.length;i++,sum++)
		{
			sum%=7;
			a[i]=sum;
		}
		//��ӡ���
		int cnt=0;
		System.out.println("\n"+q);
		System.out.println(head);
		//System.out.println("test:"+a[cnt]);
		for(int j=0;j<a[cnt];j++)
		{
			if((a[cnt]+1)%7==0)
			{
				break;
			}
			else
			{
				System.out.print("\t");
			}
		}
		for(int j=1;j<=days;j++)
		{
			if(j==day&&q==year)
			{
				System.out.print(j+"*\t");
			}
			else
			{
				System.out.print(j+"\t");
			}
			if((a[cnt]+j)%7==0&&j!=days)
			{
				System.out.println();
			}
			if(j==day)
			{
				weekdays[(a[cnt]+j-1)%7]++;
			}
		}
	}
		int flag=0;
		for(double t:weekdays)
		{
			weekdays[flag++]=t/(2021-year+1);
		}
		System.out.println();
		System.out.print("����һ��");
		System.out.printf("%.3f\n", weekdays[1]);
		System.out.print("���ڶ���");
		System.out.printf("%.3f\n", weekdays[2]);
		System.out.print("��������");
		System.out.printf("%.3f\n", weekdays[3]);
		System.out.print("�����ģ�");
		System.out.printf("%.3f\n", weekdays[4]);
		System.out.print("�����壺");
		System.out.printf("%.3f\n", weekdays[5]);
		System.out.print("��������");
		System.out.printf("%.3f\n", weekdays[6]);
		System.out.print("�����գ�");
		System.out.printf("%.3f\n", weekdays[0]);
	}
}

