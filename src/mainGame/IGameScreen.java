package mainGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Interface for classes representing different sections of the game
 * @author Mark
 *
 */
public interface IGameScreen {

	void render(GameContainer gc, Graphics g);
	
	boolean load();
	
	boolean unload();
	
	void update(GameContainer gc);
	
	boolean transitionIn();
	
	boolean transitionOut();
	
	void addGameObject(GameObject obj);
	
	void removeGameObject(GameObject obj);
}
