package homework5_Interface;

public  class Human implements DataSet_interface{

    private String name;
    private double height;

    public Human(String name,double height)
    {
        this.name=name;
        this.height=height;
    }

    public String getName()
    {
        return name;
    }

    public double getHeight()
    {
        return height;
    }

    public  String getDescription()
    {
        return "a human named "+name+"whose height is "+height;
    }

    @Override
    public double height() {
        return height;
    }
}
