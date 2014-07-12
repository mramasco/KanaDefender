package mainGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.UnicodeFont;

public class Rock extends GameObject {

	public Kana kana;
	
	public UnicodeFont font;
	
	boolean dead;
	
	//in m/ms^2 
	double gravity = .01;
	
	double xVel = -3;
	
	double yVel = -3;
	
	long gravityTick = 0;
	
	long timeDelta = 1;
	
	public boolean isAlive;
	
	public double textLocX;
	
	public double textLocY;
	
	public boolean hasCollided = false;
	
	int fontWidthHalved;
	int fontHeightHalved;
	
	public Rock(JapaneseGame theGame, Kana theKana, UnicodeFont theFont) {
		super(theGame);
		kana = theKana;
		font = theFont;
		dead = false;
		isAlive = true;
		fontWidthHalved =  font.getWidth(kana.kana)/2;
		fontHeightHalved = font.getHeight(kana.kana)/2;
	}

	@Override
	void update(GameContainer gc) {

		long currentTime = gc.getTime();
		
		if((currentTime - gravityTick) > timeDelta)
		{
			yVel += gravity;
			positionY += yVel;
			positionX += xVel;
		    gravityTick = currentTime;	
		}
		
		textLocX = positionX - fontWidthHalved;
		textLocY = positionY - fontHeightHalved;
	}

	@Override
	String getImagePath() {
		return "mainGame/data/Boulder.png";
	}
	
    
	public void render(GameContainer gc, Graphics g)
	{
		if(isAlive)
		{
			super.render(gc, g);		
			font.drawString((float)textLocX, (float)textLocY, kana.kana);
		}

	}

}
