package petManagement;

import java.util.Arrays;

/** Class to keep track of client (Pet) information for a Veterinary
    practice. Some methods are sketched for you, but others will need
    to be added in order to implement the Database interface and
    support the P3main program and expected output. You'll also need
    to add the data members.
*/
public class Vet implements Database {

	private String vname;
	private Pet[] clients;
	private int maxSize;
	private int cnt;

   /** Create a veterinary practice.
    * @param startSize the capacity for how
    * many clients they can handle
    * @param who the name of the vet practice
    */
   public Vet(int startSize, String who) {
	   vname=who;
	   maxSize=startSize;
	   clients=new Pet[maxSize];
	   cnt=0;
   }

    /** Display the name of the Vet and all the clients, one per line,
     * on the screen. (See sample output for exact format.)
    */
   public void display() {
	   System.out.println("Vet "+vname+" client list:");
	   for(int i=0;i<cnt;i++)
	   {
		   if(clients[i] instanceof Cat)
		   {
			   Cat a=(Cat)clients[i];
			   if(a.getMode()==1)
			   {
				   System.out.printf("outside cat ");
			   }
			   else
			   {
				   System.out.printf("inside cat ");
			   }
		   }
		   if(clients[i] instanceof Dog)
		   {
			   Dog a=(Dog)clients[i];
			   System.out.printf(a.getSize()+" dog ");
		   }
		   System.out.printf("%s(owner %s) %.1f lbs, $%.2f avg cost/visit\n",clients[i].getName(),clients[i].getOwner(),clients[i].getWeight(),clients[i].avgCost());
	   }
   }


    /** Add an item to the database, if there is room.
        You are limited by the initial capacity.
        @param o the object to add (must be a Pet)
        @return true if added, false otherwise
    */
   @Override
	public boolean add(Object o) {
	   if(o instanceof Pet||o instanceof Cat||o instanceof Dog) {
		   if(cnt<maxSize-1)
		   {
			  clients[cnt++]=((Pet)o);
			  return true;
		   }
	   }
	   return false;
	}

    /** Delete an item from the database, if it is there,
        maintaining the current ordering of the list.
        @param o the object to delete
        @return the item if one is deleted, null otherwise
    */
   public Object delete(Object o) {
	   if(!(o instanceof Pet||o instanceof Cat||o instanceof Dog))
	   {
		   return null;
	   }
	   for(int i=0;i<cnt;i++)
	   {
		   Pet x=clients[i];
		   if(x.equals((Pet)o))
		   {
			   cnt--;
			   for(;i<cnt;i++)
			   {
				   clients[i]=clients[i+1];
			   }
			   return o;
		   }
	   }
	   return null;
   }

    /** Compute the average weight over all clients.
        @return the average
    */
   public double averageWeight() {
	   double sum=0;
	   for(int i=0;i<cnt;i++)
	   {
		   sum+=clients[i].getWeight();
	   }
	   return sum/cnt;
   }

    /** Sort the clients. (This is complete.)
     */
   public void sort() {
       Arrays.sort(this.clients, 0, this.size());
   }

	@Override
	public int size() {
		return cnt;
	}

	@Override
	public Object find(Object o) {
		for(int i=0;i<cnt;i++)
		{
			if(clients[i].equals((Pet)o))
			{
				return o;
			}
		}
		return null;
	}

	

}
