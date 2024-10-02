package lab01;

public class SumExperiment {
	public static int checkSum(int[] array){
		
		int s = 0;
		int e = array.length-1;
		
		int sum = array[s] + array[e];
		
		while(s<e) {
			
			sum = array[s] + array[e];
		
		if (sum>20) {
			e--;
		}
		
		else if (sum<20) {
			s++;
		}
		
		else if (sum==20){
			return s;
		}
		
		}
		
		return -1;
		
		}
		
	
	
	public static void main(String[] args) {
		int[] array1 = new int[]{5, 7, 8, 9, 10, 15, 16};
		if (checkSum(array1) != 0)
			System.err.println("TEST1 FAILED");
		
		int[] array2 = new int[]{3, 5, 8, 9, 10, 15, 16};
		if (checkSum(array2) != 1)
			System.err.println("TEST2 FAILED");

		
		int[] array3 = new int[]{3, 4, 6, 9, 10, 14, 15};
		if (checkSum(array3) != 2)
			System.err.println("TEST3 FAILED");
		
		int[] array4 = new int[]{6, 7, 8, 9, 10, 15, 16};
		if (checkSum(array4) != -1)
			System.err.println("TEST4 FAILED");
		
		System.out.println("Done!!!");
	}
}
