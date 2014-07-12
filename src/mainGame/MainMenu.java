package mainGame;

import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class MainMenu extends GameScreen {

	TrueTypeFont font;
	
	MainMenuOption startGame;
	
	
	public MainMenu(JapaneseGame theGame) {
		super(theGame);
	}
	
	

	@Override
	public void addGameObject(GameObject obj) {


	}

	@Override
	public void removeGameObject(GameObject obj) {

	}

	public boolean load() {
		
		startGame = new MainMenuOption(game);
		startGame.positionX = 500;
		startGame.positionY = 500;
		return true;
	
	}

	public void setupFont() throws SlickException
	{
		Font awtFont = new Font("MS PGothic", Font.BOLD, 40);
		font = new TrueTypeFont(awtFont, true);
	}
	
	public void render(GameContainer gc, Graphics g) {
		startGame.render(gc, g);
	}
	
	public void update(GameContainer gc) {
		startGame.update(gc);
		
	}

	@Override
	public void handleInput(int key) {
		
	}

}
