package lab05;

public class Tester {

	
	public static void main(String[] args) {
		
		
		SortedBinarySet sbs1 = new SortedBinarySet();
		System.out.println("SBS1: " + sbs1.toString());
		
		
		double [] x = {1, 6, 3, 5, 7};
		
		
		SortedBinarySet sbs2 = new SortedBinarySet(x);
		
		
		System.out.println("Is Empty 2: " + sbs2.empty());
		System.out.println("Size() 2: " + sbs2.size());
		
	
		
System.out.println("Insert 2: " + sbs2);
		
		System.out.println("Is Empty 2: " + sbs2.empty());
		
		sbs2.remove(6);
		
		System.out.println("Remove 6 2: " + sbs2);
		
	System.out.println("Contains 1.233 2: " + sbs2.contains(1.233));
				double [] nums = {36, 26, 18, -3, 21345};
		
		System.out.println("Contains all 2: " + sbs2.containsAll(nums));
		
		
	sbs1.clear();
	System.out.println("SBS2.clear() "+sbs2);
		
	//--------------------------------------------------------------------------------------------
		
		System.out.println("Is Empty: " + sbs1.empty());
		System.out.println("Size(): " + sbs1.size());
		
		
		sbs1.insert(36);
		sbs1.insert(26);
		sbs1.insert(403);
		sbs1.insert(1);
		sbs1.insert(37);
		sbs1.insert(1.234);
		sbs1.insert(1.233);
		sbs1.insert(0);
		sbs1.insert(-3);
		sbs1.insert(18);
		sbs1.insert(54);
		sbs1.insert(21345);
		
		
		
		for(int i = 0; i < 100000; i++) {
			sbs1.insert(i);
		}
		
		sbs1.insert(543);
		sbs1.insert(6);
		
		System.out.println("Insert: " + sbs1);
		
		System.out.println("Is Empty: " + sbs1.empty());
		
		System.out.println("Remove 6: " + sbs1.remove(6));
		
		
		
		System.out.println("Remove -1: " + sbs1);
		
		System.out.println("Contains 1.233: " + sbs1.contains(1.233));
		
		
		
		System.out.println("Contains all: " + sbs1.containsAll(nums));
		
		
	sbs1.clear();
	System.out.println("SBS1.clear() "+sbs1);
	
	System.out.println("Time: " + System.nanoTime());
		//1016261231938500
	  	//1016283296553250
		//1016386627354458
		//1016418686660958
	}

}
