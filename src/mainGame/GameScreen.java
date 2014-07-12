package mainGame;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Abstract type for different screens in game
 * @author Mark
 *
 */
abstract class GameScreen implements IGameScreen{
	
	ArrayList<GameObject> gameObjects;
	
	public JapaneseGame game;
	
	public GameScreen(JapaneseGame theGame)
	{
		theGame = game;
		gameObjects = new ArrayList<GameObject>();
	}
	
	public void render(GameContainer gc, Graphics g) {
		
		//draw all contained game objects
		for (GameObject obj : gameObjects) {
			obj.render(gc, g);
		}
	}

	public boolean unload() {
		return false;
	}

	public void update(GameContainer gc) {
		
		//draw all contained game objects
		for (GameObject obj : gameObjects) {
			obj.update(gc);
		}		
	}

	public boolean transitionIn() {
		return true;
	}

	public boolean transitionOut() {
		return true;
	}
	
	public abstract void handleInput(int key);
	
}
