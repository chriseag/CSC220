package lab01;

public class CoinFlipExperiment {
	
	static public int coinFlipExperiment ()
	{
		
		int winnings=0;
		
		int i;
		for (i = 0; i < 100; i++) {
			double flip = Math.random();
			if (flip < 0.505) {
				winnings++;
			}
			else {
				winnings--;
			}
			}
		return(winnings);
	}
	
	public static void main(String[] args) {
		
		int amount = coinFlipExperiment ();
		System.out.println ("Win/loss amount: " + amount);
	
		
		
		/*
		
		// Declare an int variable to keep track of winnings.
		
		int winnings;
		
		// Set winnings to 0.
		
		winnings=0;
		
		// Loop 100 times.
		int i;
		for (i = 0; i < 100; i++) {
			double flip = Math.random();
			if (flip < 0.505) {
				winnings++;
			}
			else {
				winnings--;
			}
			}
		System.out.println(winnings);
		
		*/
	}
}
		
		// Flip the coin – reuse the code you wrote in the lab
		// If heads, add $1 to winnings.
		// If tails, subtract $1 from winnings.
		// Print out winnings.
		
		

