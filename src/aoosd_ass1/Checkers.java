package aoosd_ass1;

import java.util.Scanner;

public class Checkers {
	
	/**
	 * Method used to print the checkers board according to the 2-D char array
	 * 
	 * @param board  2-D array describing the position of the stones on the board
	 * 
	 * @author Matej Majtan
	 */
	public static void printBoard (char[][] board) {
		System.out.println("     0 1 2 3 4 5 6 7   <- X axis");
		System.out.println("   +-----------------+");
		
		for (int i = 0; i < board.length; i++) {
			System.out.print(" " + i + " | ");
			for (char spot: board[i]) {
				System.out.print(spot + " ");
			}
			System.out.println("|");
		}
		
		System.out.println("   +-----------------+");
	}
	
	/**
	 * Method used to ask the player to input the old and new coordinates of the stone desired to be moved
	 * 
	 * @param player  integer representing the player id 
	 * 
	 * @return an array representing the old and the new coordinates : [old_x,old_y,new_x,new_y]
	 * 
	 * @author Mihaela Nistor
	 * 
	 */
	public static int[] getCoords (int player) {
		Scanner s = new Scanner(System.in);
		int[] res = new int[4];
		
		System.out.println("Turn of player no. " + player);
		
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
		
		s.close();
		return res;
	}
	
	public static void main(String[] args) {
		char[][] board = {
			{' ', '1', ' ', '1', ' ', '1', ' ', '1'},
			{'1', ' ', '1', ' ', '1', ' ', '1', ' '},
			{' ', '1', ' ', '1', ' ', '1', ' ', '1'},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
			{'2', ' ', '2', ' ', '2', ' ', '2', ' '},
			{' ', '2', ' ', '2', ' ', '2', ' ', '2'},
			{'2', ' ', '2', ' ', '2', ' ', '2', ' '}
		};
		
		int[] temp = getCoords(1);
		for (int i: temp) {
			System.out.println(i);
		}
		printBoard(board);
	}
}