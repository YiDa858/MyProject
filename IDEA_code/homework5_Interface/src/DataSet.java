import java.util.ArrayList;

/**
 Computes the average of a set of data values.
 */
public class DataSet
{
    private double sum;
    private DataSet_interface maximum;
    private int count;
    private ArrayList<DataSet_interface> list;
    /**
     Constructs an empty data set.
     */
    public DataSet()
    {
        sum = 0;
        count = 0;
        maximum = null;
        list=new ArrayList<>();
    }

    /**
     Adds a data value to the data set
     @param x a data value
     */
    public void add(DataSet_interface x)
    {
        sum = sum + x.height();
        list.add(x);
        if (count == 0 || maximum.height()< x.height()) maximum = x;
        count++;
    }

    /**
     Gets the average of the added data.
     @return the average or 0 if no data has been added
     */
    public double getAverage()
    {
        if (count == 0) return 0;
        else return sum / count;
    }

    /**
     Gets the largest of the added data.
     @return the maximum or 0 if no data has been added
     */
    public DataSet_interface getMaximum()
    {
        return maximum;
    }

    public static void main(String[] args)
    {
        DataSet test=new DataSet();
        Human a=new Human("Jack",178);
        Student b=new Student("Sue","computer science",160);

        test.add(a);
        test.add(b);
        System.out.println(test.getAverage());
        System.out.println(test.getMaximum());

    }
}

