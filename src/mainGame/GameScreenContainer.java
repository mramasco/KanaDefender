package mainGame;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GameScreenContainer implements IGameScreen {

	//List of game 
	ArrayList<GameScreen> screens;
	
	@Override
	public void render(GameContainer gc, Graphics g) {

	}

	@Override
	public boolean load() {
		return false;
	}

	@Override
	public boolean unload() {
		return false;
	}

	@Override
	public void update(GameContainer gc) {

	}

	@Override
	public boolean transitionIn() {
		return false;
	}

	@Override
	public boolean transitionOut() {
		return false;
	}

	@Override
	public void addGameObject(GameObject obj) {
		
	}

	@Override
	public void removeGameObject(GameObject obj) {
	}
	
	

}
