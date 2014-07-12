package mainGame;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Vector2f;

/*
 * This class extends fading text to add a "float" animation
 */
public class FadingFloatingText extends FadingText {

	Random rnd = new Random();
	
	float velX;
	
	float velY = -.5f;
	
	public FadingFloatingText(String theText, int theFadeLength,
			Color theColor, Vector2f thePosition, TrueTypeFont theFont) {
		super(theText, theFadeLength, theColor, thePosition, theFont);
		// TODO Auto-generated constructor stub
		
		//random negative or positive
		boolean b = rnd.nextBoolean();
		if(b)
		{
			velX = -.5f;
		}
		else
		{
			velX = .5f;

		}
		
	}
	
	public void Draw(GameContainer gc, Graphics g)
	{
		position.x += velX;
		position.y += velY;
		super.Draw(gc, g);
	}

}
