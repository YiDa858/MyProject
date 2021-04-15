package homework4_inheritance;

import java.util.Objects;

public class Student extends Human{

	private String name;
	private String sex;
	private String nation;
	private int year_old;
	private int height;
	private int weight;
    private int grade;
	
    public Boolean equals(Student a)
	{
		if(!(a.getName().equals(this.name)&&a.getNation().equals(this.nation)&&a.getSex().equals(this.sex)&&a.getHeight()==this.height&&a.getWeight()==this.weight&&a.getOld()==this.year_old&&a.getGrade()==this.grade))return false;
		return true;
	}
    
    public String toString()
	{
		String str=new String(this.getName()+" is a grade "+this.getGrade()+" student from "+this.getNation()+" who is a "+this.getOld()+" years old "+this.getSex()+" and "+this.getHeight()+"cm high and "+this.getWeight()+"kg.");
		return str;
	}
    
    public int hashCode()
	{
		int hash=Objects.hash(this.getName(),this.getNation(),this.getSex())+Integer.hashCode(this.getHeight())+Integer.hashCode(this.getWeight())+Integer.hashCode(this.getOld())+Integer.hashCode(this.getGrade());
		return hash;
	}
    
    public int getGrade()
    {
    	return this.grade;
    }
    
	public Student(String name,String sex,String nation,int year_old,int height,int weight,int grade)
	{
		super(name,sex,nation,year_old,height,weight);
		this.grade=grade;
	}
	public static void main(String[] args) {
		Student Billy=new Student("Billy","man","Germany",18,175,75,1);
		var people=new Human[3];
		people[0]=Billy;
		people[1]=new Human("John","man","England",20,180,65);
		people[2]=new Human("Tom","man","America",20,180,65);
		for(Human a:people)
		{
			System.out.println(a.toString());
		}
	}

}
