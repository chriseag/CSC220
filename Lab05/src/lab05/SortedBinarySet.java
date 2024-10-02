package lab05;

public class SortedBinarySet {
	/** represent the simple array that holds the list values */
	public double[] theData;
	/** holds the length of the storage array */
	private int capacity;
	/** holds the number of elements in the list */
	private int size;

	/** constant for initial storage array capacity */
	private static final int INITIAL_STORAGE_CAPACITY = 11;

	/** keep this FALSE for lab; we will play with this in the assignment **/
	public boolean usesBinarySearch = true;

	/** default constructor */
	public SortedBinarySet(){
		this.theData = new double[INITIAL_STORAGE_CAPACITY];
		this.capacity = INITIAL_STORAGE_CAPACITY;
		this.size = 0;
		
	}

	public SortedBinarySet(double[] input){
		// TODO (for assignment, not lab)
		
		this.theData = new double[INITIAL_STORAGE_CAPACITY];
		this.capacity = INITIAL_STORAGE_CAPACITY;
		this.size = 0;
		
		 for(int i = 0; i<input.length; i++) {
			 this.insert(input[i]);
		 }
		
	}

	public boolean empty(){
		// TODO
		return size == 0;
	}

	public int size(){
		// TODO
		return size; //placeholder
	}

	public void grow(){
		// TODO
		this.capacity *= 2;
		double [] temp = new double [capacity];
		for(int i = 0; i < size; i++) {
			temp [i] = theData[i];
		}
		
		theData = temp;
		
		
	}

	public String toString(){
		// TODO
		
		String cap = "Capacity: " + this.capacity;
		String siz = "Size: " + this.size;
		
		String data = "Data: {";
		for (int i = 0; i<size; i++) {
				if(i==size-1) {
					data += theData[i];
				}
				else {
					data+=theData[i]+ ", ";
			}
			
		}
		
		data += "}";
		return cap+", "+siz+", "+data;
		
	}
		

	public void clear() {
		// TODO
		
		this.capacity = INITIAL_STORAGE_CAPACITY;
		this.theData = new double[INITIAL_STORAGE_CAPACITY];
		this.size = 0;
		
		
	}

	public boolean insert(double newVal){
		// TODO
		
		int loc = this.findIndex(newVal);
		if(loc>=0) {
			return false;
		}
		
		loc = Math.abs(loc)-1;
		
		if(size == capacity) {
			this.grow();
		}
		
		size += 1;

		for(int i = size-1; i > loc; i--) {
			theData[i] = theData[i-1];
		}
		
		theData[loc] = newVal;
		return true;
	
		
	}

	public boolean remove(double element){
		// TODO
		
		int index = this.findIndex(element);
		
		if(index > 0) {
			this.size--;
			this.theData[index]=0.0;
			for(int i = index; i < this.size; i++) {
				this.theData[i] = this.theData[i+1];
			}
			
			return true;
		}
		
		return false;
		
	}


	private int sequentialFind(double target) {
		// TODO
		
		for(int i = 0; i < size; i++) {
			
			if(theData[i] == target) {
				return i;
			}
			
			if (theData[i] > target) {
				return -i-1;
			}
			
			
		}
		
		return -size-1;

	}

	private int binaryFind(double target) {
		// TODO
		
		int min = 0;
		int max = size-1;
		
		
		while (min<=max) {
			int mid = (max+min)/2;
			if(theData[mid]==target) {
				return mid;
			}
			else if(theData[mid] < target) {
				min = mid + 1;
			}
			else {
				max = mid - 1;
			}
		}
		
		
		return -min-1; // placeholder
	}

	public int findIndex(double target) {
		if (usesBinarySearch) {
			return binaryFind(target);
		} else {
			return sequentialFind(target);

		}
	}

	public boolean containsAll(double[] elements){
		// TODO
		
		
		for(int i = 0; i < elements.length; i++) {
			if(binaryFind(elements[i]) < 0) {
				return false;
			}
		}
		
		return true; // placeholder
	}

	public boolean contains(double element){
		// TODO
		
		int index = binaryFind(element);
		if(index>=0) {
			return true;
		}
		

		
		return false; // placeholder
	}

}
