package  petManagement;

import java.text.DecimalFormat;

/** This is a class to define Pet objects. Pets should be compared 
according to their owner's names, ignoring capitalization. Ties
should be broken based on the pet's name, ignoring capitalization.

Your job is to add the necessary data and methods to support the
P3main program, as well as the related classes in this system. Some
required methods are noted below with comments, but these are not the
only things you will need.
*/
public class Pet implements Comparable<Pet>{

   /** Handy for formatting. */
   private static DecimalFormat money = new DecimalFormat("0.00");

   /* The access specifiers for these variables must not be changed! */

   private String name;
   private String owner;
   private double weight;
   protected int count;
   protected double sum;


   /** Create a Pet object, initializing data members.
    *  @param pname the Pet's name
    *  @param oname the owner's name
    *  @param wt the weight of the pet
    */
   public Pet(String pname, String oname, double wt) {
	   this.name=pname;
	   this.owner=oname;
	   this.weight=wt;
	   this.sum=0;
	   this.count=0;
   }

   @Override
   public String toString() {
	   String m;
	   if(this instanceof Cat)
	   {
		   Cat a=(Cat)this;
		   if(a.getMode()==1)
		   {
			   m="outside cat ";
		   }
		   else
		   {
			   m="inside cat ";
		   }
		   return m+this.name + " (owner " + this.owner + ") " + this.weight
			          + " lbs, $" + money.format(this.avgCost()) + " avg cost/visit  ";
	   }
	   if(this instanceof Dog)
	   {
		   Dog a=(Dog)this;
		   m=a.getSize()+" dog ";
		   return m+this.name + " (owner " + this.owner + ") " + this.weight
			          + " lbs, $" + money.format(this.avgCost()) + " avg cost/visit  ";
	   }
      return this.name + " (owner " + this.owner + ") " + this.weight
          + " lbs, $" + money.format(this.avgCost()) + " avg cost/visit  ";
   }

   /** The Pet is visiting the vet, and will be charged accordingly.
    *  The base cost for a visit is $85.00, and $30/shot is added.
    *  @param shots the number of shots the pet is getting
    *  @return the entire cost for this particular visit
    */
   public double visit(int shots) {
	   double cost=85+30*shots;
	   sum+=cost;
	   count++;
	   return cost;
   }

   /** Determine the average cost per visit for this pet.
    *  @return that cost, or 0 if no visits have occurred yet
    */
   public double avgCost() {
	  if(count!=0)
	  {
		  return sum/count;
	  }
	  else
	  {
		  return 0;
	  }
   }

   public boolean equals(Pet x)
   {
	   if(this.name.equalsIgnoreCase(x.name)&&this.owner.equalsIgnoreCase(x.owner))
	   {
		   return true;
	   }
	   else
	   {
		   return false;
	   }
   }

   @Override
   public int compareTo(Pet x) {
	   if(this.name.compareTo(x.name)>0)
	   {
		   return 1;
	   }
	   else if(this.name.compareTo(x.name)<0)
	   {
		   return -1;
	   }
	   else
	   {
		   if(this.owner.compareTo(x.owner)>0)
		   {
			   return 1;
		   }
		   else if(this.owner.compareTo(x.owner)<0)
		   {
			   return -1;
		   }
		   else
		   {
			   return 0;
		   }
	  }
   }
   
   public double getWeight()
   {
	   return weight;
   }
   
   public String getOwner()
   {
	   return owner;
   }
   
   public String getName()
   {
	   return name;
   }
   
   public double getSum()
   {
	   return sum;
   }
   
   public int getCount()
   {
	   return count;
   }
}
