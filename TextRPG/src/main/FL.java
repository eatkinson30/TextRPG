package main;
/*
* Edward Atkinson
 * 09.08.14
 * Eclipse Indigo
 * Calc
 */

import java.text.NumberFormat;
import java.util.*;
import java.lang.Character;
import javax.swing.JOptionPane;

public abstract class FL {
	
	static Scanner keyboard = MainEntry.inputScan;
	static final int MAX_INT = Integer.MAX_VALUE;//2147483647;
	static NumberFormat formatCurrency = NumberFormat.getCurrencyInstance();
	static Random rand = new Random();
	
	public static void Print(Object msg) {
		System.out.print(msg.toString());
	}
	
	public static void PrintL(Object msg) {
		Print(msg.toString() + "\n");
	}
	
	
	public static enum Direction {
		NORTH,
		SOUTH,
		WEST,
		EAST,
		LOST
	}
	
	public static String StringDirection(Direction d)
	{
		switch(d)
		{
		case NORTH:
			return "North";
		case SOUTH:
			return "South";
		case WEST:
			return "West";
		case EAST:
			return "East";
		case LOST:
		default:
			return "You are hopelessly LOST";
		}
	}
	
	public static Direction FlipDirection(Direction start) {
		switch (start) {
		case NORTH:
			return Direction.SOUTH;
		case SOUTH:
			return Direction.NORTH;
		case EAST:
			return Direction.WEST;
		case WEST:
			return Direction.EAST;
		default:
			return Direction.LOST;
		}
	}
	
	public static Direction RotateDirection(Direction start, boolean clockwise) {
		switch (start) {
		case NORTH:
			return clockwise ? Direction.EAST : Direction.WEST;
		case SOUTH:
			return clockwise ? Direction.WEST : Direction.EAST;
		case EAST:
			return clockwise ? Direction.SOUTH : Direction.NORTH;
		case WEST:
			return clockwise ? Direction.NORTH : Direction.SOUTH;
		default:
			return Direction.LOST;
		}
	}
	
	public static String FormatCurrency(Object money) {
		return formatCurrency.format(money);
	}
	
	public static int InputInt(String msg, int min, int max) {
		int num = min - 1;
		do {
	    	Print(msg);
	        while (!keyboard.hasNextInt()) {
	        	PrintL("INT NOT ENTERED! " + msg);
	            keyboard.next(); // this is important!
	        }
	        num = keyboard.nextInt();
	    } while (num < min || num > max);
		return num;
	}
	
	public static int InputInt(String msg) {
		return InputInt(msg, -MAX_INT, MAX_INT);
	}
	
	public static String InputString(String msg, boolean showAcceptedValues, ArrayList<String> acceptedValues)
	{
		String value;
		if (showAcceptedValues)
			msg += StringifyArray(acceptedValues);
	    do
	    {
		    Print(msg);
	    	while (!keyboard.hasNextLine()) {
	    		PrintL("STRING NOT ENTERED!");
	    		keyboard.next(); // this is important!
	    	}
		    value = keyboard.nextLine();
		    if ((acceptedValues == null || acceptedValues.isEmpty() || Contains(ConvertArrayListToArray(acceptedValues), true, value) != -1))
		    	break;
		    else
		    {
		    	PrintL("VALID STRING NOT ENTERED! Accepted values are " + StringifyArray(ConvertArrayListToArray(acceptedValues)));
		    	continue;
		    }
	    } while (true);
		return value;
	}
	
	public static String InputString(String msg, String...strParams)
	{
		return InputString(msg, false, strParams);
	}
	
	public static String InputString(String msg, ArrayList<String> acceptedValues)
	{
		return InputString(msg, false, acceptedValues);
	}
	
	
	
	public static String InputString(String msg, boolean showAcceptedValues, String...strParams)
	{
		ArrayList<String> acceptedValues = new ArrayList<String>();
		for (int i = 0; i < strParams.length; i++)
			if (!strParams[i].equals(""))
				acceptedValues.add(strParams[i]);
		return InputString(msg, showAcceptedValues, acceptedValues);
	}
	
	public static String InputString(String msg)
	{
		return InputString(msg, false, "");
	}
	
	public static void DisplayError(Object errorMsg, String errorTitle) {
		DisplayMessage(errorMsg, errorTitle, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void DisplayError(Object errorMsg) {
		DisplayError(errorMsg, "ERROR");
	}
	
	public static void DisplayMessage(Object message, String title, int messageType) {
		JOptionPane.showMessageDialog(null, message.toString(), title, messageType);
	}
	
	public static void DisplayMessage(Object message, String title) {
		DisplayMessage(message, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void DisplayMessage(Object message) {
		DisplayMessage(message, "MESSAGE");
	}
	
	public static String AvsAn(String word) {
		char letter = word.charAt(0);
		String str = "";
		switch (Character.toLowerCase(letter)) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			str += "an";
			break;
		default:
			str += "a";
			break;
		}
		str += " " + word;
		return str;
	}
	
	public static String SingularVsPlural(int num, String single, String plural) {
		if (num == 1)
			return single;
		else
			return plural;
	}
	/*
	public static String StringifyArray(int[] data) {
		if (data.length == 0)
			return "EMPTY";
		else {
			String str = "[";
			for (int i = 0; i < data.length; i++) {
				str += String.valueOf(data[i]);
				if (i < data.length - 1)
					str += ", ";
				else
					str += "]";
			}
			return str;
		}
	}
	*/
	
	public static String StringifyArrayWithNumbers(ArrayList<String> data) {
		if (data.size() == 0)
			return "EMPTY";
		else {
			String str = "[";
			for (int i = 0; i < data.size(); i++) {
				str += String.valueOf(i + 1) + ". ";
				str += String.valueOf(data.get(i));
				if (i < data.size() - 1)
					str += ", ";
				else
					str += "]";
			}
			return str;
		}
	}
	
	
	public static String StringifyArray(ArrayList<String> data) {
		if (data.size() == 0)
			return "EMPTY";
		else {
			String str = "[";
			for (int i = 0; i < data.size(); i++) {
				str += String.valueOf(data.get(i));
				if (i < data.size() - 1)
					str += ", ";
				else
					str += "]";
			}
			return str;
		}
	}
	
	public static String StringifyArray(Object[] data) {
		if (data.length == 0)
			return "EMPTY";
		else {
			String str = "[";
			for (int i = 0; i < data.length; i++) {
				str += data[i].toString();
				if (i < data.length - 1)
					str += ", ";
				else
					str += "]";
			}
			return str;
		}
	}
	
	public static int Sum(ArrayList<Integer> lst) {
		int sum = 0;
		for (int i = 0; i < lst.size(); i++) {
			sum += lst.get(i);
		}
		return sum;
	}
	
	public static String AddNumberEnding(int num) {
		/*
	}
		String str = "", oldStr = String.valueOf(num);
		for (int i = 0; i < oldStr.length(); i++)
			if (oldStr.charAt(i) != 0)
				str += oldStr.charAt(i);
		int lowerBound = 2;
		if (str.length() == 1) 
			lowerBound = 1;
		for (int i = str.length() - 1; i >= lowerBound; i--) {
			num -= Integer.parseInt(String.valueOf(str.charAt(i))) * Math.pow(10, i);
		}
		*/
		String str = String.valueOf(num);
		int remainder = num % 10 + (((num / 10) % 10) * 10);
		switch (remainder) {
		case 1:
		case 21:
		case 31:
		case 41:
		case 51:
		case 61:
		case 71:
		case 81:
		case 91:
			str += "st";
			break;
		case 2:
		case 22:
		case 32:
		case 42:
		case 52:
		case 62:
		case 72:
		case 82:
		case 92:
			str += "nd";
			break;
		case 3:
		case 23:
		case 33:
		case 43:
		case 53:
		case 63:
		case 73:
		case 83:
		case 93:
			str += "rd";
			break;
		default:
			str += "th";
			break;
		}
		return str;
	}
	
	public static String[] ConvertArrayListToArray(ArrayList<String> arr) {
		String[] strArr = new String[arr.size()];
		arr.toArray(strArr);
		return strArr;
	}
	
	public static int Contains(String[] arr, boolean ignoreCase, String...check) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < check.length; j++) {
				if (ignoreCase == true && arr[i].equalsIgnoreCase(check[j]))
					return i;
				else if (ignoreCase == false && arr[i].equals(check[j]))
					return i;
			}	
		}
		return -1;
	}
	
	public static int Contains(String[] arr, String...check) {
		return Contains(arr, false, check);
	}

}
