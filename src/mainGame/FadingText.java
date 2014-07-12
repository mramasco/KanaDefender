package mainGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Vector2f;

public class FadingText {

	//in milliseconds
	public int fadeLength;
	
	public String text;
	
	public Color startColor;
	
	public Vector2f position;
	
	public boolean completedFlag;
	
	float alphaReductionTick;
	
	float currentAlpha;
	
	//lets assume 17 ms per frame (60 fps), change this later
	int frameTime = 17;
	
	TrueTypeFont font;
	
	public FadingText(String theText, int theFadeLength, Color theColor, Vector2f thePosition, TrueTypeFont theFont)
	{
		currentAlpha = 1;
		text = theText;
		startColor = new Color(theColor.r, theColor.g, theColor.b, 1.0f);
		position = thePosition;
		fadeLength = theFadeLength;
		completedFlag = false;
		font = theFont;
		

		alphaReductionTick = (float)frameTime / fadeLength;
		System.out.println(alphaReductionTick);
		
	}
	
	public void Draw(GameContainer gc, Graphics g)
	{
		//store color to restore it after draw is complete
		Color c = g.getColor();
		g.setColor(startColor);
		g.setFont(font);
		font.drawString(position.x,position.y, text.toUpperCase(), startColor);
		startColor.a -= alphaReductionTick;
		//System.out.println(startColor.a);
		g.setColor(c);
		
	}
	
	public boolean isComplete()
	{
		return completedFlag;
	}
	
}
