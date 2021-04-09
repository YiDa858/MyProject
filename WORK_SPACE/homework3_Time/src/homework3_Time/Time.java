package homework3_Time;

import java.time.LocalTime;
import java.util.Scanner;

public class Time {
	static int mode;			//�洢��ʱ��ʽ
	int hour;					//�洢Сʱ
	int minute;					//�洢����
	String flag;				//�洢12Сʱ����"AM""PM"
	public Time(int hour,int minute,int mode)		//����Time����
	{
		if(mode==24)								//24Сʱ�����
		{	
			this.hour=hour;
			this.minute=minute;
		}
		else										//12Сʱ�����
		{
			if(hour>=12)
			{
				this.hour-=12;
				this.flag="PM";
			}
			else
			{
				this.hour=hour;
				this.flag="AM";
			}
			this.minute=minute;
		}
	}
	public static Time getCurrentTime()				//��ȡ��ǰʱ��
	{
		LocalTime currentTime = LocalTime.now();
		Time ret=new Time(currentTime.getHour(),currentTime.getMinute(),mode);
		return ret;
	}
	public int lookHour()							//����ʱ��Сʱ��
	{
		return this.hour;
	}
	public int lookMinute()							//����ʱ�������
	{
		return this.minute;
	}
	public void addOneHour()						//��ʱ������1Сʱ
	{
		if(this.mode==24)
		{
			if(this.hour+1>=24)
			{
				this.hour=this.hour-23;
			}
			else
			{
				this.hour++;
			}
		}
		else
		{
			if(this.hour+1>12)
			{
				this.hour=this.hour-11;
				switch(this.flag)
				{
					case "AM":this.flag="PM";break;
					case "PM":this.flag="AM";break;
				}
			}
			else
			{
				this.hour++;
			}
		}
	}
	public void addHour(int add)				//��ʱ������addСʱ
	{
		add%=24;
		if(this.mode==24)
		{
			if(this.hour+add>=24)
			{
				this.hour=this.hour+add-24;
			}
			else
			{
				this.hour+=add;
			}
		}
		else
		{
			if(this.hour+add>=12&&this.hour+add<24)
			{
				this.hour=this.hour+add-12;
				switch(this.flag)
				{
					case "AM":this.flag="PM";break;
					case "PM":this.flag="AM";break;
				}
			}
			else if(this.hour+add<12)
			{
				this.hour+=add;
			}
			else
			{
				this.hour=this.hour+add-24;
			}
		}		
	}
	public void addOneMinute()					//��ʱ������1����
	{
		if(this.minute+1==60)
		{
			this.addOneHour();
			this.minute=0;
		}
		else
		{
			this.minute++;
		}
	}
	public void addMinute(int add)				//��ʱ������add����
	{
		this.addHour(add/60);
		add%=60;
		if(this.minute+add>=60)
		{
			this.addOneHour();
			this.minute=this.minute+add-60;
		}
		else
		{
			this.minute+=add;
		}
	}
	public static void toString(Time time)		//��ӡʱ��
	{
		if(time.flag!=null)
		{
			System.out.println(time.hour+":"+time.minute+time.flag);
		}
		else
		{
			System.out.println(time.hour+":"+time.minute);
		}
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("������24��12��ѡ��24Сʱ�ƻ�12Сʱ�ƣ�");
		mode=in.nextInt();
		System.out.println("��ȡ��ǰʱ��������1�������ض�ʱ��������2��");
		int tmp=in.nextInt();
		if(tmp==1)
		{
			Time output=getCurrentTime();
		}
		else
		{
			System.out.println("������24Сʱ���µ�Сʱ����ӣ�");
			int tmp1=in.nextInt();
			int tmp2=in.nextInt();
			Time output=new Time(tmp1,tmp2,mode);
		}
	}
}