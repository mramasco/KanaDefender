package mainGame;

import java.awt.Font;

import org.newdawn.slick.GameContainer;

public class MainMenuOption extends MenuOption {

	//in MS
	int growthFrequency = 30;
	
	boolean increaseSize = true;
	
	int imageSize = 1;
	
	double maxSize = 1.2;
	
	long updateTimer = 0;
	
	boolean growthDirection = true;
	
	public MainMenuOption(JapaneseGame game) {
		
		super(game);
	}

	@Override
	void update(GameContainer gc) {
		
		if(!selected)
		{
			long currentTime = gc.getTime();
			
			if((currentTime - updateTimer) > growthFrequency)
			{	
				if(growthDirection)
				{
					scale += .01;
				}
				else
				{
					scale -= .01;
				}
				
				if(scale <= 1)
				{
					growthDirection = true;
				}
				else if(scale >= maxSize)
				{
					growthDirection = false;
				}
				
				updateTimer = currentTime;		
			}
		}
	}

	Font getFont() {

		return new Font("MS PGothic", Font.BOLD, 24);
	}

	@Override
	String getImagePath() {
		return "mainGame/data/Joystick_Ball.png";
	}
	
	public void deselect()
	{
		selected = false;
		scale = 1;
	}
	
	

}
