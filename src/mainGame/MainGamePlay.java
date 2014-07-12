package mainGame;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class MainGamePlay extends GameScreen {

	Kana[] kana;
	
	long spawnFrequencyInMS = 4000;
	
	long randomSpawnValue = 0;
	
	long minSpawnRate = 1000;
	
	int numberCorrect = 0;
	
	int maxCharInput = 3;
	
	int currentCharIndex = 0;
	
	int fontSize = 70;
	
	int fadeTextLength = 2000;
	
	long lastCreate;
	
	ArrayList<Rock> rocks;
	
	Random generator;
	
	UnicodeFont font;
	
	char[] currentInput;
	
	int score;
	
	int maxHealth = 10;
	
	int currentHealth;
	
	Rectangle castleBounds;

	HashMap<Integer, String> keyboardValues;
	
	TrueTypeFont revealAnswerFont;
	
	FadingText fadingText;
	
	ArrayList<FadingText> fadingTexts;
	
	AngelCodeFont angel;
	
	public MainGamePlay(JapaneseGame theGame) {
		super(theGame);
	}

	@Override
	public void addGameObject(GameObject obj) {
		gameObjects.add(obj);
	}
	
	public void render(GameContainer gc, Graphics g) {

		//draw all contained game objects
		for (Rock obj : rocks) {
			obj.render(gc, g);
		}
		
		for(FadingText fad : fadingTexts)
		{
			fad.Draw(gc, g);
		}
		String inputAsString = String.valueOf(currentInput);
		
		font.drawString(gc.getWidth()/2 - font.getWidth(inputAsString)/2, gc.getHeight() - 100, inputAsString);
		
		String scoreString = "Score: " + score;
		font.drawString(gc.getWidth()/2 - font.getWidth(scoreString)/2, 50, scoreString);
		
		
//		Rectangle healthBG = new Rectangle(500, 500, 100, 100);
//        ShapeFill fill = new GradientFill(500, 550, new Color(0,0,255), 600, 550, new Color(0,255,0));
//
//         g.fill(healthBG, fill);
         
         g.draw(castleBounds);
         
         fadingText.Draw(gc, g);
        
	}
	
	public boolean load()
	{
		
		//import kana and save to local variable
		try
		{
			importKana();
			setupFont();
		}
		catch(Exception e)
		{
			return false;
		}
		
		fadingText = new FadingText("Test", 2000, new Color(255,0,0), new Vector2f(700,700), revealAnswerFont);
		
		generator = new Random();
		rocks = new ArrayList<Rock>();
		currentInput = new char[3];
		keyboardValues = new HashMap<Integer, String>();
		//setup slick keyboard mapping to char values
		setupKeyboardValues();
		score = 0;
		randomSpawnValue = generator.nextInt((int) spawnFrequencyInMS) + minSpawnRate;
		currentHealth = maxHealth;
		castleBounds = new Rectangle(100, 300, 400, 1000);
		fadingTexts = new ArrayList<FadingText>();

		return true;
	}
	
	@SuppressWarnings("unchecked")
	public void setupFont() throws SlickException
	{
		java.awt.Color c = new java.awt.Color(50,50,50);
		Font awtFont = new Font("MS PGothic", Font.BOLD, fontSize);
		//font = new TrueTypeFont(awtFont, true);
		font = new UnicodeFont(awtFont);
		font.addAsciiGlyphs();
		font.addGlyphs(12352, 12543);
		font.getEffects().add(new ColorEffect(c));
		font.loadGlyphs();
		
		Font testF = new Font("Jing Jing", Font.BOLD, 50);
		
		revealAnswerFont = new TrueTypeFont(testF, true);
	
	}
	
	public void importKana()
	{
		try
		{
			InputStream stream = getClass().getResourceAsStream("data/hiragana.txt");

			//File fileDir = new File("src/resources/kana_code.txt");
			BufferedReader in = new BufferedReader(
					   new InputStreamReader(
							   stream, "UTF8"));
			String strLine;
			ArrayList<Kana> tempKana = new ArrayList<Kana>();
			//Read File Line By Line
			while ((strLine = in.readLine()) != null)   {
				//System.out.println(strLine);
				String[] tokens = strLine.split(" ");
				if(2 == tokens.length)
				{
					tempKana.add(new Kana(tokens[0], tokens[1]));
				}		
			}
			
			kana = new Kana[tempKana.size()];
			
			//transfer to list
			for(int i = 0; i<tempKana.size(); i++)
			{
				kana[i] = tempKana.get(i);
			}
			
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
			
		}
	}
	
	public void update(GameContainer gc) 
	{
		long currentTime = gc.getTime();
		
		if((currentTime - lastCreate) > randomSpawnValue)
		{
			int random = generator.nextInt(kana.length);
			Kana randomKana = kana[random];
			Rock rock = new Rock(game, randomKana, font);
			rock.positionX = gc.getWidth() + 100;
			rock.positionY = 500 + generator.nextInt(gc.getHeight() - 500);
			rocks.add(rock);
			lastCreate = currentTime;		
			randomSpawnValue = generator.nextInt((int) spawnFrequencyInMS) + minSpawnRate;
			//System.out.println(randomSpawnValue);
			//System.out.println(randomKana.kana + " " +randomKana.phonetic);
		}
		
		Rock rockToRemove = null;
		String phonetic = String.copyValueOf(currentInput);
		
		//iterate over rocks and remove colldied ones
		Iterator<Rock> i = rocks.iterator();
		while (i.hasNext()) {
		   Rock r = i.next(); // must be called before you can call i.remove()
		   
		   r.update(gc);
			
			if(phonetic.contains(r.kana.phonetic.toUpperCase()))
			{
				System.out.println("ROCK FOUND");
				rockToRemove = r;
			}
			
			if(castleBounds.contains((float)r.positionX, (float)r.positionY))
			{
				r.hasCollided = true;
			}
		   
		   //remove rock and reduce health points
		   if(r.hasCollided)
		   {
			   currentHealth--;
			   fadingTexts.add(new FadingFloatingText(r.kana.phonetic, fadeTextLength, new Color(255,0,0), new Vector2f((float)r.positionX, (float)r.positionY), revealAnswerFont));
			   i.remove();
		   }
		   
		}
		
		//iterate over text to remove and remove colldied ones
		Iterator<FadingText> textIt  = fadingTexts.iterator();
		while(textIt.hasNext())
		{
			FadingText textToCheck = textIt.next();
			if(textToCheck.isComplete())
			{
				textIt.remove();
			}
		}
		
		//if rock was found remove
		if(rockToRemove != null)
		{
			score++;
			clearInput();		
			rocks.remove(rockToRemove);
			rockToRemove = null;
			
			//increase spawn rate
			if(score%5 == 0)
			{
				spawnFrequencyInMS *= .9;
			}
		}
		
		//clear input if they typed 3 incorrect chars
		if(currentCharIndex == 3)
		{
			clearInput();	
		}
		
		
	}
	
	@Override
	public void handleInput(int key) {
		
		if(key == Input.KEY_ESCAPE)
		{
			System.exit(0);
		}
		
		boolean isPhoneticValue = keyboardValues.containsKey(key);
		
		if(isPhoneticValue)
		{
			if(currentCharIndex < maxCharInput)
			{
				System.out.println("Player Typed: " + keyboardValues.get(key));
				//will always be 1 char to index 0 will be fine
				currentInput[currentCharIndex] =  keyboardValues.get(key).toCharArray()[0];
				currentCharIndex++;
			}
		}
		else
		{
			switch(key) {
				case Input.KEY_BACK: 
					if(currentCharIndex > 0)
					{
						currentCharIndex--;
						currentInput[currentCharIndex] = '\0';				
					}
					break;
				case Input.KEY_SPACE:
					clearInput();
					break;
			}
		}
	}

	@Override
	public void removeGameObject(GameObject obj) {
		// TODO Auto-generated method stub
		
	}
	
	private void clearInput()
	{
		currentCharIndex = 0;
		currentInput[0] = '\0';
		currentInput[1] = '\0';
		currentInput[2] = '\0';
	}
	
	private void setupKeyboardValues()
	{
		keyboardValues.put(Input.KEY_A, "A");
		keyboardValues.put(Input.KEY_B, "B");
		keyboardValues.put(Input.KEY_C, "C");
		keyboardValues.put(Input.KEY_D, "D");
		keyboardValues.put(Input.KEY_E, "E");
		keyboardValues.put(Input.KEY_F, "F");
		keyboardValues.put(Input.KEY_G, "G");
		keyboardValues.put(Input.KEY_H, "H");
		keyboardValues.put(Input.KEY_I, "I");
		keyboardValues.put(Input.KEY_J, "J");
		keyboardValues.put(Input.KEY_K, "K");
		keyboardValues.put(Input.KEY_L, "L");
		keyboardValues.put(Input.KEY_M, "M");
		keyboardValues.put(Input.KEY_N, "N");
		keyboardValues.put(Input.KEY_O, "O");
		keyboardValues.put(Input.KEY_P, "P");
		keyboardValues.put(Input.KEY_Q, "Q");
		keyboardValues.put(Input.KEY_R, "R");
		keyboardValues.put(Input.KEY_S, "S");
		keyboardValues.put(Input.KEY_T, "T");
		keyboardValues.put(Input.KEY_U, "U");
		keyboardValues.put(Input.KEY_V, "V");
		keyboardValues.put(Input.KEY_W, "W");
		keyboardValues.put(Input.KEY_X, "X");
		keyboardValues.put(Input.KEY_Y, "Y");
		keyboardValues.put(Input.KEY_Z, "Z");		
	}
}
