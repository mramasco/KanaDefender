package mainGame;

import java.util.HashMap;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.Input;

public class JapaneseGame extends BasicGame {

	Image land = null;
	UnicodeFont font;
	HashMap<String, String> d;
	String[] keys;
	
	MainGamePlay main;
	MainMenu mainMenu;
	
	Input input;
	
	long timer;
	
	public JapaneseGame() {
		super("Japanese Game");
		// TODO Auto-generated constructor stub
		
		main = new MainGamePlay(this);
		mainMenu = new MainMenu(this);
	}
	
	  @Override
	  public void render(GameContainer gc, Graphics g) throws SlickException
	  {	  
		  main.render(gc, g); 
		//  mainMenu.render(gc, g);
	  }

	@Override
	public void init(GameContainer gc) throws SlickException {
		input = gc.getInput();
		main.load();
		mainMenu.load();
	}

	@Override
	public void update(GameContainer gc, int time) throws SlickException {
		main.update(gc);
		mainMenu.update(gc);
		
		main.handleInput(handleInput());
		
	}

	/**
	 * @param args
	 * @throws SlickException 
	 */
	public static void main(String[] args) throws SlickException {
		
		JapaneseGame game = new JapaneseGame();
		AppGameContainer app = new AppGameContainer(game);
		app.setDisplayMode(1920, 1080, true);
		app.setTargetFrameRate(60);
		app.setVSync(true);
		app.start();

	}
	
	public int handleInput()
	{
		if(input.isKeyPressed(Input.KEY_ESCAPE))
		{
			return Input.KEY_ESCAPE;	
		}
		
		if(input.isKeyPressed(Input.KEY_A))
		{
			return Input.KEY_A;	
		}
		
		if(input.isKeyPressed(Input.KEY_B))
		{
			return Input.KEY_B;	
		}
		
		if(input.isKeyPressed(Input.KEY_C))
		{
			
			return Input.KEY_C;	
		}
		
		if(input.isKeyPressed(Input.KEY_D))
		{
			
			return Input.KEY_D;	
		}
		
		if(input.isKeyPressed(Input.KEY_E))
		{
			
			return Input.KEY_E;	
		}
		
		if(input.isKeyPressed(Input.KEY_F))
		{
			
			return Input.KEY_F;	
		}
		
		if(input.isKeyPressed(Input.KEY_G))
		{
			
			return Input.KEY_G;	
		}
		
		if(input.isKeyPressed(Input.KEY_H))
		{
			
			return Input.KEY_H;	
		}
		
		if(input.isKeyPressed(Input.KEY_I))
		{
			
			return Input.KEY_I;	
		}
		
		if(input.isKeyPressed(Input.KEY_J))
		{
			
			return Input.KEY_J;	
		}
		
		if(input.isKeyPressed(Input.KEY_K))
		{
			
			return Input.KEY_K;	
		}
		
		if(input.isKeyPressed(Input.KEY_L))
		{
			
			return Input.KEY_L;	
		}
		
		if(input.isKeyPressed(Input.KEY_M))
		{
			
			return Input.KEY_M;	
		}
		
		if(input.isKeyPressed(Input.KEY_N))
		{
			
			return Input.KEY_N;	
		}
		
		if(input.isKeyPressed(Input.KEY_O))
		{
			
			return Input.KEY_O;	
		}
		
		if(input.isKeyPressed(Input.KEY_P))
		{
			
			return Input.KEY_P;	
		}
		
		if(input.isKeyPressed(Input.KEY_Q))
		{
			
			return Input.KEY_Q;	
		}
		
		if(input.isKeyPressed(Input.KEY_R))
		{
			
			return Input.KEY_R;	
		}
		
		if(input.isKeyPressed(Input.KEY_S))
		{
			
			return Input.KEY_S;	
		}
		
		if(input.isKeyPressed(Input.KEY_T))
		{
			
			return Input.KEY_T;	
		}
		
		if(input.isKeyPressed(Input.KEY_U))
		{
			
			return Input.KEY_U;	
		}
		
		if(input.isKeyPressed(Input.KEY_V))
		{
			
			return Input.KEY_V;	
		}
		
		if(input.isKeyPressed(Input.KEY_W))
		{
			
			return Input.KEY_W;	
		}
		
		if(input.isKeyPressed(Input.KEY_X))
		{
			return Input.KEY_X;	
		}
		
		if(input.isKeyPressed(Input.KEY_Y))
		{
			return Input.KEY_Y;	
		}
		
		if(input.isKeyPressed(Input.KEY_Z))
		{
			return Input.KEY_Z;	
		}
		
		if(input.isKeyPressed(Input.KEY_S))
		{
			
			return Input.KEY_S;	
		}
		
		if(input.isKeyPressed(Input.KEY_BACK))
		{
			return Input.KEY_BACK;
		}
		
		if(input.isKeyPressed(Input.KEY_SPACE))
		{
			return Input.KEY_SPACE;
		}
		
		return 0;
	}

}
