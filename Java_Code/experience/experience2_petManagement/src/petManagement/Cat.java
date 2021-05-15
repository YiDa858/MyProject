package  petManagement;

public class Cat extends Pet{
	
	private int mode=0;//0 presents inside and 1 presents outside
	
	public Cat(String name,String owner,double weight)
	{
		super(name,owner,weight);
	}
	
	@Override
	public double visit(int shots)
	{
		double cost=85+20+30*shots;
		if(mode==1)cost+=30;
		sum+=cost;
		count++;
		return cost;
	}
	
	public void goOutside()
	{
		this.mode=1;
	}

	public int getMode()
	{
		return mode;
	}
}
