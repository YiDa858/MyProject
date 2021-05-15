package homework5_Interface;

public class Student extends Human{
    private String major;

    public Student(String name,String major,double height)
    {
        super(name,height);
        this.major=major;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription()+"and a student majoring in "+major;
    }

    public String getMajor()
    {
        return major;
    }

    @Override
    public double height() {
        return getHeight();
    }
}