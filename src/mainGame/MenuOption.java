package mainGame;

import org.newdawn.slick.TrueTypeFont;

public abstract class MenuOption extends GameObject{

	protected boolean selected;
	
	protected TrueTypeFont font;
	
	public MenuOption(JapaneseGame theGame) 
	{
		super(theGame);
		game = theGame;
		selected = false;
	}
	
	public void select()
	{
		selected = true;
	}
	
	public void deselect()
	{
		selected = false;
	}
	
}
