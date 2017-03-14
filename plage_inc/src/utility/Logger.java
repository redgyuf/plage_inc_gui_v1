package utility;

public class Logger {

	public void print(String text)
	{
		System.out.println(text);
	}
	
	public void print(String text, boolean clearScreen)
	{
		if (clearScreen)
		{
			clearScreen();
		}
		System.out.println(text);
	}
	
	public void clearScreen()
	{
		System.out.print(String.format("\033[H\033[2J"));
	}
}
