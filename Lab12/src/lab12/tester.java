package lab12;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pacman maze1 = new Pacman("mazes/tinyOpen.txt", "out.txt");
		maze1.solveDFS();
		System.out.println(maze1);
		maze1.writeOutput();
		
		
	}

}
