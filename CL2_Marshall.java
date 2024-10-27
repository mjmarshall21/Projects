import java.util.Scanner;
import java.io.*;


public class CL2_Marshall{
	static char[][] maze; // maze variable 
	static int[] startPos = new int[2]; // Start position set
	static String input;
	static int startRow = 0;				// finds the rown and collum of the start position 
	static int startCol= 0;
	static int endRow = 0;				// finds the rown and collum of the start position 
	static int endCol= 0;	
	static boolean win = false;
	static char move;
	public static void main(String[] args){
		System.out.println("Enter the file path:");   
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();  // enter the file path
		maze = createSquareMaze(input);
		loadMaze(input);
		findEndPosition(maze);
		findStartPosition(maze);
		displayMaze(maze);
		while(win==false){					// while win is false the program will run
		move = scanner.next().charAt(0);		// takes the input on (WASD)
		movePlayer(move);
		displayMaze(maze);					// displays the maze after the movement
		if(maze[endRow][endCol] == 'P'){    // if the maze end point is at the same position as P the program ends
			win = true;
		}
		}
		System.out.println("congradulations you've found the goal");
		
	}
	public static char[][] createSquareMaze(String input){

			try{
			Scanner in = new Scanner(new File(input));
			int num = 0;
					while(in.hasNextLine()){
						num++;					// reads through each line of the file counting the lines
						in.nextLine();
					}
					maze = new char[num][num];  // since a square sets the lines counted to the size of the selected maze
			}

		catch(Exception e){
			System.out.println("Error" + e);
		}
		return maze;
	}

	public static void loadMaze(String input){
				
		try{
			int r = 0;
			Scanner in = new Scanner(new File(input));
			while (in.hasNextLine()){					
				String nextLine = in.nextLine();
				for(int i = 0; i<maze[r].length;i++){ // traverses throught the maze saving each line into the variable maze
					maze[r][i] = nextLine.charAt(i);
				} 	
				r++;	
			}
			
		}
		catch(Exception e){
			System.out.println("Error" + e);
		}

	} 
	public static void findStartPosition(char[][] maze){
		for(int i =0;i<maze.length;i++){
			for(int j=0; j<maze[i].length;j++){			// finds start position
				if (maze[i][j] == 'S'){				//traverses through the maze until it finds S then sets S to P
					startRow = i;
					startCol = j;
					maze[i][j] = 'P';
					
				}
			}
		}

		startPos[0] = startRow;
		startPos[1] = startCol;			// Saves the start position 

	}

	public static void findEndPosition(char[][] maze){
		for(int i =0;i<maze.length;i++){
			for(int j=0; j<maze[i].length;j++){
				if (maze[i][j] == 'F'){				//traverses through the maze untill it finds the end position
					endRow = i;
					endCol = j;
					
				}
			}
		}
	}	

	public static void displayMaze(char[][] maze){
		for(int i =0;i<maze.length;i++){
			for(int j=0; j<maze[i].length;j++){
				System.out.print(maze[i][j]);      // Prints the maze
			}
			System.out.println(" ");
		}
	}
	public static void movePlayer(char move){
		switch(move){

			case 's':
				int row = 0;
				int col = 0;
					for(int i =0;i<maze.length;i++){
						for(int j=0; j<maze[i].length;j++){ //finds P
							if (maze[i][j] == 'P'){
								row = i;
								col = j;
								
							}
						}
					}

				if(maze[row+1][col] == '#'){
						System.out.println("You cant move through walls!");  // dosent let the player move through walls
						break;
				}
				else{
					maze[startRow][startCol] = 'S';
					maze[row+1][col] = 'P';    // moves the character down and sets start position back to S
					maze[row][col] = '.';
					
					
				}

				break;

			case 'w':
				int row1 = 0;
				int col1 = 0;
					for(int i =0;i<maze.length;i++){
						for(int j=0; j<maze[i].length;j++){     // finds P
							if (maze[i][j] == 'P'){
								row1 = i;
								col1 = j;
								
							}
						}
					}
					
				if(maze[row1-1][col1] == '#'){
						System.out.println("You cant move through walls!");
						break;
				}
				else{
					maze[startRow][startCol] = 'S';
					maze[row1-1][col1] = 'P';     // moves the character up and sets start position back to S
					maze[row1][col1] = '.';
					
					
				}
				break;

			case 'd':
				int row2 = 0;
				int col2 = 0;
					for(int i =0;i<maze.length;i++){
						for(int j=0; j<maze[i].length;j++){   // finds P
							if (maze[i][j] == 'P'){
								row2 = i;
								col2 = j;
								
							}
						}
					}
					
				if(maze[row2][col2+1] == '#'){
						System.out.println("You cant move through walls!");
						break;
				}
				else{
					maze[startRow][startCol] = 'S';
					maze[row2][col2+1] = 'P';    // moves the character right and sets start position back to S
					maze[row2][col2] = '.';
					
				}
				break;

			case 'a':
				int row3 = 0;
				int col3 = 0;
					for(int i =0;i<maze.length;i++){
						for(int j=0; j<maze[i].length;j++){// finds P
							if (maze[i][j] == 'P'){
								row3 = i;
								col3 = j;
								
							}
						}
					}
					
				if(maze[row3][col3-1] == '#'){
						System.out.println("You cant move through walls!");
						break;
				}
				else{
					maze[startRow][startCol] = 'S';
					maze[row3][col3-1] = 'P';          // moves the character left and sets the start position back to S
					maze[row3][col3] = '.';
					
					
				}
				break;

			default:
				break;
		}

	}

}
