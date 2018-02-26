/**
 * 
 */
package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.text.NumberFormat;

import gameloop.Board;
import gameloop.Display;

public class PlayState implements GameState
{
	Rectangle playButtons[];
	Board board;
	Display display;
	
	int aiDifficulty1;
	int aiDifficulty2;
	int gameChoice;
	boolean hasCountDownTimer;
	
	int gameTimerMinutes;
	int gameTimerSeconds;
	int timerTracker;
	
	/**
	 * Instantiates a new MenuState to be used by the GameLoop
	 */
	public PlayState(Display display)
	{
		this.display = display;
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#init()
	 */
	@Override
	public void init()
	{
		//These values set by MenuState before Init of PlayState
		board = new Board(gameChoice, aiDifficulty1, aiDifficulty2);
		
		//If AI vs AI (Different Button Set)
		if(gameChoice == 0)
		{
			playButtons = new Rectangle[0];
		}
		else
		{
			playButtons = new Rectangle[0];
		}
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#update()
	 */
	@Override
	public void update()
	{
		//Timer Updater Begin
		timerTracker++;
		
		if(timerTracker >= 60)
		{
			gameTimerSeconds++;
			timerTracker = 0;
		}
		if(gameTimerSeconds >= 60)
		{
			gameTimerMinutes++;
			gameTimerSeconds = 0;
		}
		//Timer Updater End
		
		//Button Updater Begin
		for(int x = 0; x < playButtons.length ; x++)
		{
			if (isClickingButton(playButtons[x]))
			{
				if(gameChoice == 0)
				{
					//if x == 0, etc.
				}
				else	//not ai vs ai
				{
					//if x == 0, etc.
				}
			}
		}
		//Button Updater End
		
		//Will be false if any buttons are clicked above
		//Board Updater Begin
		if(display.getMouseListener().isClicking())
		{
			display.getMouseListener().setClicking(false);
			int x = display.getMouseListener().getMousePosition().x / 60;
			int y = display.getMouseListener().getMousePosition().y / 60;
			
			board.updateBoard(x, y);
		}
		
		display.getMouseListener().setClicking(false);
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#render(java.awt.Graphics2D)
	 */
	@Override
	public void render(Graphics2D g)
	{
		try {
			board.render(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO render buttons
		
		
		//Draws the Timer
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Calibri", Font.BOLD, 15));
		
		//Fixes Problem of Timer being 0:## instead of 00:##
		if(gameTimerMinutes < 10)
			g.drawString("0" + gameTimerMinutes + " : ", 745, 15);
		else
			g.drawString(gameTimerMinutes + " : ", 745, 15);
		
		if(gameTimerSeconds < 10)
			g.drawString("0" + gameTimerSeconds, 770, 15);
		else
			g.drawString("" + gameTimerSeconds, 770, 15);
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#isClickingButton(java.awt.Rectangle)
	 */
	@Override
	public boolean isClickingButton(Rectangle r)
	{
		if(!display.getMouseListener().isClicking())
			return false;
		
		if(display.getMouseListener().getMousePosition().getX() < r.getX())
			return false;
		if(display.getMouseListener().getMousePosition().getX() > r.getX() + r.getWidth())
			return false;
		if(display.getMouseListener().getMousePosition().getY() < r.getY())
			return false;
		if(display.getMouseListener().getMousePosition().getY() > r.getY() + r.getHeight())
			return false;
		
		display.getMouseListener().setClicking(false);
		return true;
	}

	/**
	 * @param timerChoice
	 */
	public void setTimerSetting(int timerChoice)
	{
		if(timerChoice == 1)
			this.hasCountDownTimer = true;
		else
			this.hasCountDownTimer = false;
	}

	/**
	 * @param aIChoice1
	 */
	public void setAIDifficultyOne(int aIChoice1)
	{
		this.aiDifficulty1 = aIChoice1;
	}
	
	/**
	 * @param aIChoice1
	 */
	public void setAIDifficultyTwo(int aIChoice2)
	{
		this.aiDifficulty1 = aIChoice2;
	}

	/**
	 * @param gameChoice
	 */
	public void setGameSetting(int gameChoice)
	{
		this.gameChoice = gameChoice;
	}
}
