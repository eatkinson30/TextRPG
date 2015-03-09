package main;
//import java.util.AbstractMap;
//import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
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
	static HumanPlayer protagonist;
	static GameMap gameMap;
	static Hashtable<String, String> gameStrings;
	
	static BufferedReader gameStringsFile;
	
	static final String kTITLE = "title";
	static final String kINTRO = "intro";
	
	public static void main(String[] args) throws IOException
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
		
		
		boolean
			exploring,
			continuingPlay;
		
		exploring = true;
		continuingPlay = false;
		
		showTitle();
		
		showMenu();
		
		protagonist.Start();
		
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
	}
}
