package menuInput;

public class MenuOption {
	private int action;
	private int optionType;
	private String optionName;
	
	// Constructors //
	public MenuOption() {
		action = 0;
		optionType = 0;
		optionName = "";
	}
	
	public MenuOption(int op, int type, String name)
	{
		action = op;
		optionType = type;
		optionName = name;
	}
	
	// Getter & Setter //
	public int getAction()
	{
		return action;
	}
	
	public int getType()
	{
		return optionType;
	}
	public String getName()
	{
		return optionName;
	}
	
	
}
