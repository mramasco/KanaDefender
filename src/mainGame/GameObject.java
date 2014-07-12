package mainGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

abstract class GameObject {

	public JapaneseGame game;
	
	public Image image;
	
	public double positionX;
	
	public double positionY;
	
	public double rotationAngle;
    
    public float scale;
    
    public Vector2f centerOfRotation;
	
	
    public GameObject(JapaneseGame theGame)
    {
    	game = theGame;
    	
    	positionX = 0;
    	positionY = 0;
    	rotationAngle = 0;
    	scale = 1;
    	centerOfRotation = new Vector2f(0,0);
    	
    	//try and set image to set image path
    	try {
			image = new Image(getImagePath());
		} catch (SlickException e) {
			e.printStackTrace();
		}
    }
    
    
	public void render(GameContainer gc, Graphics g)
	{
		if(positionX > (0 - image.getWidth()) && 
				positionX < (gc.getWidth() + image.getWidth()) &&
				positionY > (0 - image.getHeight()) &&
				positionY < (gc.getHeight() + image.getWidth()))
		{		
			image.draw((float)(positionX - (scale*image.getWidth())/2), (float)(positionY - (scale*image.getHeight())/2), scale);
		}
	}
	
	abstract void update(GameContainer gc);
	
	//Return image used for drawing
	abstract String getImagePath();
	
	
	
}
