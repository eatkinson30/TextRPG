package main;
import java.util.Scanner;
import mapInternals.GameMap;
import rpgObjectClasses.HumanPlayer;


/*
 * Programmers: Edward Atkinson & Delun Shi
 * Date Started: 2/27/15
 * 
 * This will be where our main function will be
 */
public class MainEntry {
	static Scanner inputScan = new Scanner(System.in);
	static HumanPlayer Protagonist;
	static GameMap allRooms;
	
	public static void main(String[] args)
	{
		boolean
			exploring,
			continuingPlay;
		
		exploring = true;
		continuingPlay = false;
		
		showTitle();
		
		showMenu();
		
		do {
			giveStoryIntro();
			
			/* Do initial placement of character and setting of game environment here */
			
			// This is the game loop where player input is constantly read //
			do {
				takeTurn();
			} while (exploring);
			
			
			
			
		} while (continuingPlay);

	}
	
	private static void showTitle()
	{}
	private static void showMenu()
	{}
	private static void giveStoryIntro()
	{}	
	
	private static void takeTurn() // Gets user input and makes stuffs happen based on it
	{
		
		
		
	}
}
