package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

import mapInternals.GameMap;
import rpgObjectClasses.HumanPlayer;


/*
 * Programmers: Edward Atkinson & Delun Shi
 * Text Adventure RPG
 * Date Started: 2/27/15
 * Current Date: 5/15/15
 * This will be where our main function will be
 * PLEASE UPDATE AND STUFF
 */
public class MainEntry {
	public static Scanner inputScan = new Scanner(System.in);
	public static HumanPlayer protagonist;
	static Hashtable<String, String> gameStrings;
	
	public static BufferedReader gameStringsFile;
	
	public static final String kTITLE = "title";
	public static final String kINTRO = "intro";
	
	public static void main(String[] args) throws IOException
	{
		ReadGameStringsFile();
		
		boolean
			exploring,
			continuingPlay;
		
		exploring = true;
		continuingPlay = false;
		
		GameMap._GameMap();
		
		protagonist = new HumanPlayer(GameMap.GetRoom(GameMap.LOBBY), FL.InputString("What is your name?\n>> "), 100, 5);
		
		showTitle();
		
		showMenu();
		
		giveStoryIntro();
		
		do {
			
			protagonist.Start();
			
			/* Do initial placement of character and setting of game environment here */
			
			// This is the game loop where player input is constantly read //
			do {
				takeTurn();
			} while (exploring);
			
			// Show appropriate ending and ask if the player wants to play again
			
		} while (continuingPlay);

	}
	
	private static void showTitle()
	{
		FL.PrintL(gameStrings.get(kTITLE));
	}
	private static void showMenu()
	{}
	
	private static void giveStoryIntro()
	{
		FL.PrintL(gameStrings.get(kINTRO));
	}	
	
	private static void takeTurn() // Gets user input and makes stuffs happen based on it
	{
		FL.PrintL();
		protagonist.WhereBeThis().PlayerTurn(protagonist);
		/*
		String entry = FL.InputString("What you want to do? ", "exit", "run");
		switch (entry)
		{
		case "exit":
			System.exit(0);
			break;
		case "run":
			FL.PrintL("You ran");
			break;
		default:
			FL.PrintL("Ooops. my String Input Function is messed up");
			break;
		}
		*/
	}
	
	private static void ReadGameStringsFile() throws IOException
	{
		gameStrings = new Hashtable<String, String>();
		gameStringsFile = new BufferedReader(new FileReader("gameStringsFile.txt")); 

		boolean continueLastLine = false;
		String lastKey = "";
		while (gameStringsFile.ready()) 
		{
			String line = gameStringsFile.readLine();
			String[] parts = line.split(":");
			if (parts.length > 1)
			{
				gameStrings.put(parts[0], parts[1]);
				lastKey = parts[0];
			}
			else if (parts.length > 0 && continueLastLine && !lastKey.equals(""))
			{
				gameStrings.put(lastKey, gameStrings.get(lastKey) + '\n' + line);
			}
			else
			{
				continueLastLine = false;
				lastKey = "";
			}
			if (line.endsWith(">"))
				continueLastLine = true;
			else
				continueLastLine = false;
		}
		gameStringsFile.close();
	}
}
