package lab10;

import java.util.Arrays;

public class MaxHeap {
    /** internal representation of the heap */
    private int[] theData;
    /** store the number of current elements inside the heap */
    private int size;

    /** constructor to initialize the status of the objects of this class
        based on the input parameter (i.e., size)
        @param maxsize the size for the heap
     */
    public MaxHeap(int maxsize) {
        // TODO for Lab10
    	
    	this.size = 0;
    	this.theData = new int[maxsize];
    	
    	
    }

    /** constructor that initializes a heap and put the values of the input
        array in it in such a way that the constructed max heap is valid.
        @param arr the input array
     */
    public MaxHeap(int[] arr){
        // TODO for Assignment10
    	
    	this.size = arr.length;
    	this.theData = arr.clone();
    	this.heapify(this.size-1);
    	
    	
    }
    
    public String theData() {
    	return Arrays.toString(theData);
    }

    public int size() {
        return size;
    }

    private int parent(int pos) {
    	return (pos-1)/2;
    }

    private int leftChild(int pos) {
    	return 2*pos + 1;
    }

    private int rightChild(int pos) {
    	return 2*pos + 2;
    }

    private boolean isLeaf(int pos) {
        return (pos >= size/2) && (pos < size);
    }


    /** Swap the items with index i and index j in the heap array.
        @param i index of first item in heap
        @param j index of second item in theData
     */
    private void swap(int i, int j) {
        int value = theData[i];
        theData[i] = theData[j];
        theData[j] = value;
    }


    /** Returns a string containing contents of the heap as an array
        NOTE this method should *not* be modified.
     */
    public String toString(){
        String s = "";
        for (int i = 0; i < theData.length; i++)
            s += theData[i] + ", ";
        s += "\n";
        return s;
    }

    /** Prints the tree contents, one per line, following an inorder traversal
        and using indentation to indicate node depth; prints right to left so
        that it looks correct when the output is rotated;
        NOTE this method should not be modified.
     */
    public void printSideways(){
        printSideways(0, 0);
    }

    /** Prints in reversed preorder the tree with given root, indenting each
        line to the given level
        @param root_indx the given root
        @param level indentation level
        NOTE this method should not be modified.
     */
    private void printSideways(int root_indx, int level){
        if (root_indx < theData.length){
            printSideways(rightChild(root_indx), level+1);
            for (int i = 0; i < level; i++){
                System.out.print("       ");
            }
            System.out.println(theData[root_indx]);
            printSideways(leftChild(root_indx), level+1);
        }
    }

    /**
     tests if the contents of the heap are equal to an input array
     @param arr the input array
     NOTE this method should not be modified.
    */
    public boolean IsEqual(int[] arr){
        if (arr.length != theData.length)
            return false;

        if (arr.length == 0)
            return true;

        for (int i = 0; i < arr.length; i++)
            if (arr[i] != theData[i])
                return false;

        return true;
    }


    /** Remove an item from the heap.
      pre: theData is in heap order.
      post: Removed maximum item, theData is in heap order.
      @return The item with the maximum value or -1 if empty.
     */
    public int poll() {
        // TODO for Lab10
    	
    	if(size==0) {
    		return -1;
    	}
    	
    	int max = theData[0];
    	theData[0] = 0;
    	size--;
    	swap(0, size);
    	
    	
    	int pos = 0;
    	while(!isLeaf(pos) && (theData[pos] < theData[leftChild(pos)] || theData[pos] < theData[rightChild(pos)])){   
    		if(theData[leftChild(pos)] > theData[rightChild(pos)]) {
    			swap(pos, leftChild(pos));
    			pos = leftChild(pos);
    		}
    		else {
    			swap(pos, rightChild(pos));
    			pos = rightChild(pos);
    		}
    	}
    	
    	
    	return max;
    }

    /** Insert an element into the heap.
      pre:  theData is in heap order.
      post: The element is in the heap and
            theData is in heap order.
      @param element The element to be inserted
     */
    public void offer(int element) {
        // TODO for Lab10
    	
    	
    	theData[size] = element;
    	size++;
    	
    	
    	
    	int cPos = size -1;
    	int pPos = parent(cPos);
    	while(theData[pPos] < theData[cPos]) {
    		swap(cPos, pPos);
    		cPos = pPos;
    		pPos = parent(cPos);
    	}
    	
    	
    	
    }


    /** in-place heap sort algorithm.
        @param arr the input (unsorted) array to be sorted.
        TODO finish writing siftDown() for Assignment10
        NOTE do *not* modify the signatures of sort(), heapify(), or siftDown()
     */
    public void sort(int[] arr) {
		this.theData = arr;
        this.size = arr.length;

        heapify(size-1);
		while(size > 1) {
			swap(0, size-1);
			size--;
            siftDown(0);
		}
    }


	private void heapify(int index) {

		if(index == 0) {
			return;
		}

		for (int i = parent(index); i >= 0; i--) {
			siftDown(i);
		}

	}

	private void siftDown(int index) {
		
		int leftChild = 2*index + 1;
		int rightChild = 2*index + 2;
		int largerChild;
		
		if (rightChild < size && theData[rightChild] > theData[leftChild]) {
			largerChild = rightChild;
		}
		
		else {
			largerChild = leftChild;
		}
		
		if(largerChild < size && theData[largerChild] > theData[index]) {
			int temp = theData[index];
			theData[index] = theData[largerChild];
			theData[largerChild] = temp;
			siftDown(largerChild);
		}

        // While a child has a larger value than its parent, the largest child
        // value (either leftChild(index) or rightChild(index)) is swapped with
        // the parent (element at index). index should be updated accordingly
        // before going round the loop again.

        // TODO for Assignment10
	}

}
