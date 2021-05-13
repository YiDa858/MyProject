import java.time.LocalTime;
import java.util.Scanner;

public class Time {
    private static int mode;			//存储计时方式
    private int hour;					//存储小时
    private int minute;					//存储分钟
    private String flag;				//存储12小时制下"AM""PM"

    public Time(int hour,int minute,int mode)		//创建Time对象
    {
        if(mode==24)								//24小时制情况
        {
            this.hour=hour;
            this.minute=minute;
        }
        else										//12小时制情况
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
    public static Time getCurrentTime()				//获取当前时间
    {
        LocalTime currentTime = LocalTime.now();
        Time ret=new Time(currentTime.getHour(),currentTime.getMinute(),mode);
        return ret;
    }
    public int lookHour()							//访问时间小时数
    {
        return this.hour;
    }
    public int lookMinute()							//访问时间分钟数
    {
        return this.minute;
    }
    public void addOneHour()						//将时间增加1小时
    {
        if(mode==24)
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
    public void addHour(int add)				//将时间增加add小时
    {
        add%=24;
        if(mode==24)
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
    public void addOneMinute()					//将时间增加1分钟
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
    public void addMinute(int add)				//将时间增加add分钟
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
    public static void toString(Time time)		//打印时间
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
        System.out.println("请输入24或12以选择24小时制或12小时制：");
        mode=in.nextInt();
        System.out.println("获取当前时间请输入1，设置特定时间请输入2：");
        int tmp=in.nextInt();
        if(tmp==1)
        {
            Time output=getCurrentTime();
        }
        else
        {
            System.out.println("请输入24小时制下的小时与分钟：");
            int tmp1=in.nextInt();
            int tmp2=in.nextInt();
            Time output=new Time(tmp1,tmp2,mode);
        }
        in.close();
    }
}

