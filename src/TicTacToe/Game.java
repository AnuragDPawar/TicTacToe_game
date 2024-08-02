package TicTacToe;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	public static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] gameBoard = {
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
		};
		printGameboard(gameBoard);		
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your position (1-9)");
			int playerPos= sc.nextInt();
			while(cpuPositions.contains(playerPos)|| playerPositions.contains(playerPos) || playerPos>9 && playerPos<1)
			{
				System.out.println("Position is already taken/Invalid postion, please enter new position");
				playerPos= sc.nextInt();
			}
			placePosition(gameBoard,playerPos,"player");
			printGameboard(gameBoard);
			Random rd = new SecureRandom();
			int cpuPos = rd.nextInt(9)+1;
			while(cpuPositions.contains(cpuPos)|| playerPositions.contains(cpuPos))
			{
				cpuPos = rd.nextInt(9)+1;
			}
			placePosition(gameBoard,cpuPos,"cpu");
			printGameboard(gameBoard);
			System.out.println(checkWinner());
		}
		
	}
	public static String checkWinner()
	{
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List bottomRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List  cross2 = Arrays.asList(3,5,7);
		List<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(midRow);
		winningConditions.add(bottomRow);
		winningConditions.add(leftCol);
		winningConditions.add(midCol);
		winningConditions.add(rightCol);
		winningConditions.add(cross1);
		winningConditions.add(cross2);
		for(List l: winningConditions)
		{
			if(playerPositions.containsAll(l))
			{
				return "Congratulations you won";
			}
			if(cpuPositions.containsAll(l))
			{
				return "Computer is smarter than you";
			}
			if(playerPositions.size()+cpuPositions.size()==9)
			{
				return "Its a tie";
			}
		}
		
		return "";
		
	}
	public static void placePosition(char[][] gameBoard, int pos, String player)
	{
		char symbol = 'X';
		 if(player == "player")
		 {
			 symbol = 'X';
			 playerPositions.add(pos);
		 }
		 else if(player == "cpu")
		 {
			 symbol = 'O';
			 cpuPositions.add(pos);
		}
		switch (pos) {
		case 1: {	
			gameBoard[0][0]=symbol;
			break;
			}
		case 2: {	
			gameBoard[0][2]=symbol;
			break;
			}
		case 3: {	
			gameBoard[0][4]=symbol;
			break;
			}
		case 4: {	
			gameBoard[2][0]=symbol;
			break;
			}
		case 5: {	
			gameBoard[2][2]=symbol;
			break;
			}
		case 6: {	
			gameBoard[2][4]=symbol;
			break;
			}
		case 7: {	
			gameBoard[4][0]=symbol;
			break;
			}
		case 8: {	
			gameBoard[4][2]=symbol;
			break;
			}
		case 9: {	
			gameBoard[4][4]=symbol;
			break;
			}
		default:
			throw new IllegalArgumentException("Unexpected value: " + pos);
		}
		
	}
	public static void printGameboard(char[][] gameBoard)
	{
		for(int i=0;i<gameBoard.length;i++)
		{
			for(int j=0;j<gameBoard[0].length;j++)
			{
				System.out.print(gameBoard[i][j]);
			}
			System.out.println();
		}
		System.out.println();

	}

}
