package menuInput;

import java.util.List;
import java.util.ArrayList;

import main.FL;
/*
 * asedf asdf asdf 
 * 
 * Middle stuff added
 * 
 * newer asdf and stuff
 */
public class ChoiceMenu {
	private List<String> elements; 
	
	public ChoiceMenu() {
		elements = new ArrayList<String>();
	}
	
	public ChoiceMenu(String[] l)
	{
		int counter;
		
		elements = new ArrayList<String>();
		
		for (counter = 0; counter < l.length; ++counter)
		{
			elements.add(l[counter]);
		}
	}
	

	public static int InputPlayerInput(String msg, ArrayList<String> options, boolean includeBackOption)
	{
		ArrayList<String> newOptions = new ArrayList<String>();
		if (includeBackOption)
			newOptions.add("Back");
		for (String str : options)
			newOptions.add(str);
		
		return FL.InputInt(msg + StringifyArrayWithNumbers(newOptions, includeBackOption)  + "\n>> ",  includeBackOption ? 0 : 1, options.size());
	}
	
	private static String StringifyArrayWithNumbers(ArrayList<String> data, boolean zeroBased) {
		
		if (data.size() == 0)
			return "EMPTY";
		else {
			String str = "[";
			for (int i = 0; i < data.size(); i++) {
				str += String.valueOf(i + (zeroBased ? 0 : 1)) + ". ";
				str += String.valueOf(data.get(i));
				if (i < data.size() - 1)
					str += ", ";
				else
					str += "]";
			}
			return str;
		}
	}
	
	private static String StringifyArray(Object[] data) {
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
}
