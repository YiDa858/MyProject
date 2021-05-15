package homework4_Inheritance;

import java.util.Objects;

public class Human extends Object{

    private String name;
    private String sex;
    private String nation;
    private int year_old;
    private int height;
    private int weight;

    public Boolean equals(Human a)
    {
        if(!(a.name.equals(this.name)&&a.nation.equals(this.nation)&&a.sex.equals(this.sex)&&a.weight==this.height&&a.weight==this.weight&&a.year_old==this.year_old))return false;
        return true;
    }

    public String toString()
    {
        String str=new String(this.name+" is a "+this.sex+" from "+this.nation+" who is "+this.year_old+" years old and "+this.height+"cm high and "+this.weight+"kg.");
        return str;
    }

    public Human(String name,String sex,String nation,int year_old,int height,int weight)
    {
        this.name=name;
        this.sex=sex;
        this.nation=nation;
        this.year_old=year_old;
        this.height=height;
        this.weight=weight;
    }

    public int hashCode()
    {
        int hash=Objects.hash(this.name,this.nation,this.sex)+Integer.hashCode(this.height)+Integer.hashCode(this.weight)+Integer.hashCode(this.year_old);
        return hash;
    }

    public int getOld()
    {
        return this.year_old;
    }

    public String getName()
    {
        return this.name;
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getWeight()
    {
        return this.weight;
    }

    public String getSex()
    {
        return this.sex;
    }

    public String getNation()
    {
        return this.nation;
    }

    public static void main(String[] args) {
        //test
        Human John=new Human("John","man","England",20,180,65);
        Human Tom=new Human("Tom","man","America",20,180,65);
        System.out.println(John.toString());
        System.out.println("hashcode is:"+John.hashCode());
        System.out.println("(should be false)"+John.equals(Tom));
    }

}
