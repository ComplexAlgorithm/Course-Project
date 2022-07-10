
public interface ListInterface<T> {
	
		//method headings
		
		//adds an item to the list
		public void add(T item);
		
		//removes an item from the list if this item already exists on the list and return true
		//otherwise return false without changing list 
		public boolean remove(T item);
		
		//returns true if this item exists on the list otherwise returns false
		//find does not change the list
		public boolean find(T item);
		
		//returns numberOfItems on the list
		public int size();
		
		//all methods in the Object class were listed implicitly in every interface
		//interfaces do not inherit from the Object class, but they have an implicitly relationship
		//such that all public methods of the Object class are implicitly listed in every interface
		public String toString();  //this method heading is listed implicitly, but can also be explicit
		
		/**
		 * The next step in the development process is to revise the ListInterface<T> that
		 *  was developed in class. You will need to add one more method that determines the 
		 *  difference between one list and another list. This method’s heading should be as 
		 *  follows:
			public ListInterface<T> difference(ListInterface<T> secondList);
			
		
		 */
		public ListInterface<T> difference(ListInterface<T> secondList);
		
	}


