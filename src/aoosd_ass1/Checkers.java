package aoosd_ass1;

import java.util.Scanner;

public class Checkers {
	static char[][] board = {
			{' ', '1', ' ', '1', ' ', '1', ' ', '1'},
			{'1', ' ', '1', ' ', '1', ' ', '1', ' '},
			{' ', '1', ' ', '1', ' ', '1', ' ', '1'},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{'2', ' ', '2', ' ', '2', ' ', '2', ' '},
			{' ', '2', ' ', '2', ' ', '2', ' ', '2'},
			{'2', ' ', '2', ' ', '2', ' ', '2', ' '}
		};
	
	static Scanner s = new Scanner(System.in);
	
	/**
	 * Method used to print the checkers board according to the 2-D char array
	 * 
	 * @param _board  2-D array describing the position of the stones on the board
	 * 
	 * @author Matej Majtan
	 */
	public static void printBoard (char[][] _board) {
		System.out.println("     0 1 2 3 4 5 6 7   <- X axis");
		System.out.println("   +-----------------+");
		
		for (int i = 0; i < _board.length; i++) {
			System.out.print(" " + i + " | ");
			for (char spot: _board[i]) {
				System.out.print(spot + " ");
			}
			System.out.println("|");
		}
		
		System.out.println("   +-----------------+");
	}
	
	/**
	 * Method used to ask the player to input the old and new coordinates of the stone desired to be moved
	 * 
	 * @param _player  integer representing the player id 
	 * 
	 * @return an array representing the old and the new coordinates : [old_x,old_y,new_x,new_y]
	 * 
	 * @author Mihaela Nistor
	 * 
	 */
	public static int[] getCoords (int _player) {
		int[] res = new int[4];
		
		System.out.println("Turn of player no. " + _player);
		
		System.out.println("Coordinate of piece to move");
		System.out.print("Enter X: ");
		res[0] = s.nextInt();
		System.out.print("Enter Y: ");
		res[1] = s.nextInt();
		
		System.out.println("Coordinate of new position");
		System.out.print("Enter X: ");
		res[2] = s.nextInt();
		System.out.print("Enter Y: ");
		res[3] = s.nextInt();
		
		return res;
	}
	
	/**
	 * Main function of the program
	 * 
	 * @param args	arguments of the program
	 * 
	 * @author 	Matej Majtan, Mihaela Nistor
	 */
	public static void main(String[] args) {
		int ox = 0, oy = 0, nx = 0, ny = 0;
		int player = 1;
		
		while (true) {
			// print board
			printBoard(board);
			// ask player for coords
			boolean coordsReceived = false;
			while (!coordsReceived) {
				int[] coords = getCoords(player);
				coordsReceived = true;
				
				// check for coordinates outside of scope
				for (int c : coords) {
					if (c < 0 || c > 7) {
						System.err.println("The coordinates are outside of the scope of the board");
						coordsReceived = false;
						break;
					}
				}
				
				//assign individual coordinates to more readable variables
				ox = coords[0];
				oy = coords[1];
				nx = coords[2];
				ny = coords[3];
				
				// check if tile belongs to player
				if (board[oy][ox] != Character.forDigit(player, 10)) {
					System.err.println("The tile you want to move doesn't belong to you");
					coordsReceived = false;
					continue;
				}
				
				// check whether the tile is in diagonal position
				if (!(((nx == ox - 1) || (nx == ox + 1)) && 	// if new x is +- 1 from the old x
				      (((ny == oy + 1) && (player == 1)) || 	// if new y for player 1 is one larger than the old y
				       ((ny == oy - 1) && (player == 2)))) ) {	// if new y for player 2 is one smaller than the old y
					System.err.println("The new tile is not on diagonal forward direction from the old tile");
					coordsReceived = false;
					continue;
				}
				
				// check whether the place where you want to move to is empty
				if (board[ny][nx] != ' ') {
					System.err.println("The tile you want to move to is occupied");
					coordsReceived = false;
					continue;
				}
			}
			
			// move the tiles
			board[oy][ox] = ' ';
			board[ny][nx] = Character.forDigit(player, 10);
			
			// toggle between players
			player = player == 1 ? 2 : 1;
		}	
	}
}