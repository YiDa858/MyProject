package  petManagement;

public class Dog extends Pet{
	private String size;
	
	public Dog(String name,String owner,double weight,String size)
	{
		super(name,owner,weight);
		this.size=size;
	}
	
	@Override
	public double visit(int shots)
	{
		double cost=85+15+30*shots;
		if(size.equals("medium"))
		{
			cost+=2.5*shots;
		}
		else if(size.equals("large"))
		{
			cost+=5*shots;
		}
		sum+=cost;
		count++;
		return cost;
	}
	
	public String getSize()
	{
		return size;
	}
}
