
public class ArrayBasedList<T> implements ListInterface<T> {
		//instance variables
	private int numberOfItems;
	private T[] list; //reference to an array of Objects which are of type T
	
	//default constructor
	public ArrayBasedList() {
		super();
		numberOfItems = 0;
		list = (T[])new Object[5];
	}
	
	//overloaded constructor
	public ArrayBasedList(int size) {
		super();
		numberOfItems = 0;
		if(size > 0) {
			list = (T[])new Object[size];
		}
		else {
			list = (T[])new Object[5];
		}
	}
	@Override
	public void add(T item) {
		if(numberOfItems < list.length) {
			list[numberOfItems] = item;
			numberOfItems++;
		}
		else {
			T[] largerList = (T[])new Object[list.length + list.length]; //local variable
			for(int index = 0; index < list.length; index++) {
				largerList[index] = list[index]; //copy the items in the corresponding locations
			}
			largerList[numberOfItems] = item; //places the item into the largerList
			list = largerList;
			numberOfItems++;
		}

	}

	@Override
	public boolean remove(T item) {
		int index = locate(item);
		boolean removed = false;
		if(index != -1) {
			 list[index] = null; //remove the item at the index
			 numberOfItems--; //there is one less item on the list
			 list[index] = list[numberOfItems]; //copy the last item on the list to the location where the item was removed
			 list[numberOfItems] = null;
			 removed = true;
		}
		return removed;
	}

	@Override
	public boolean find(T item) {
		int index = locate(item);
		boolean found = false;
		if(index != -1) {
			found = true;
		}
		return found;
	
	}
	private int locate(T item) {
		int index = 0;
		boolean found = false;
		while(!found && index < numberOfItems) {
			if(list[index].equals(item)) {
				found = true;
			}
			else {
				index++;
			}
		}
		if(!found) {
			index = -1; //the item does not exist on the list, because -1 is never an index of an array
		}
		return index;
	}
	
	public int size() {
		return numberOfItems;
	}
	//override the toString method from the Object class
		public String toString() {
			String allItems = "";
			for(int index = 0; index < numberOfItems; index++) {
				allItems = allItems + "\n" + list[index].toString();
			}
			return allItems;
		}
		/**
		 * 	This method will be called on an object that implements ListInterface<T> and 
			the parameter that
will be passed to it will be another object that implements ListInterface<T>. This method will
return an object that implements the ListInterface<T> that represents only those elements on the
first list such that an element on the first list is not equal to any element on the second list.
 It will essentially return the elements that are on the first list, but not on the second list.
  The first and second list should be unchanged by this method. The ArrayBasedList<T> class that
   implements ListInterface<T> will need to implement the difference method that is now required 
   by the ListInterface<T>. 
		 */

	@Override
	public ListInterface<T> difference(ListInterface<T> secondList) {
		ListInterface<T> newList = new ArrayBasedList<T>();
		for(int index = 0; index < numberOfItems; index++) {
			boolean found = secondList.find(this.list[index]);
			if(found == false) {
				newList.add(this.list[index]);
			}
		}
		return newList;
			
	}
		
}


