package lab06;

public class InsertionSort<E extends Comparable<E>> {

    /** The constant in the formula t = c * O() */
    private double c;

    /** The order O() of the implementation.
        If your implementation is in O(n^2), use Math.pow().
	    @param n index
	    @return the function of n inside the O()
	 */
    public double O(int n) {
        return Math.pow(n,  2);
    }

    /** Calculates the constant c using a given input array of type E.
        Units of time should be converted to microseconds
    */
    public void fit(E[] array) {
    
    	long start = System.nanoTime() / 1000;
    	sort(array);
    	long stop = System.nanoTime()/1000;
    	
    	long time = stop-start; //Something
    	double O = O(array.length);
    	c = time/O;
    	
    }

    /** Predicts the running time of an insertion sort for some index n
        @param n
        @return the estimated amount of time in unit microseconds
    */
    public double predict(int n) {

        return c*O(n);
        
    }

    /** Performs an insertion sort using a given input array
        @param array the (unsorted) array
        @return the sorted array
    */
    public E[] sort(E[] array) {
        // EXERCISE

        /* Handle case where length of array is 1 or less */
    	
    	if(array.length <= 1)
    	{
    		return array;
    	}
    	
        /* make a copy of the array to sort */
        E[] sorted = array.clone();

        /* Perform the insertion sort */
        for(int i=1; i < sorted.length; i++)
        {
            E index = sorted[i];
            int j = i;
            while(j>0 && sorted[j-1].compareTo(index) > 0) {
            	sorted[j] = sorted [j-1];
            	j--;
            }
            sorted[j] = index;
        }

       return sorted;
        
    }

}
