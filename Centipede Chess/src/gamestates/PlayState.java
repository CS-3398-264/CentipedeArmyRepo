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
	
	boolean hasCountdownTimer;
	boolean isPaused;
	int countdownTimer1;
	int countdownTimerSeconds1;
	int countdownTimerMinutes1;
	int countdownTimer2;
	int countdownTimerSeconds2;
	int countdownTimerMinutes2;
	
	int gameTimerMinutes;
	int gameTimerSeconds;
	int timerTracker;
	int winnerTimer;
	
	int aiWaitTime;
	int aiWaitTimer;
	
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
			playButtons = new Rectangle[3];
			playButtons[0] = new Rectangle(525 , 125 , 250, 100);
			playButtons[1] = new Rectangle(525 , 250 , 250, 100);
			playButtons[2] = new Rectangle(525 , 375 , 250, 100);
		} //Player vs. *
		else
		{
			playButtons = new Rectangle[2];
			playButtons[0] = new Rectangle(525 , 125 , 250, 100);
			playButtons[1] = new Rectangle(525 , 250 , 250, 100);
		}
		winnerTimer = 0;
		
		countdownTimer1 = 0;
		countdownTimerMinutes1 = 5;		//Timer Starts at 5Min
		countdownTimerSeconds1 = 0;
			
		countdownTimer2 = 0;
		countdownTimerMinutes2 = 5;		//Timer Starts at 5Min
		countdownTimerSeconds2 = 0;
		
		gameTimerMinutes = 0;
		gameTimerSeconds = 0;
		timerTracker = 0;
		
		aiWaitTime = 450;
		
		isPaused = false;
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#update()
	 */
	@Override
	public void update()
	{	
		if(!isPaused)
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
			
			//BEGIN COUNTDOWN TIMER UPDATE
			if(hasCountdownTimer)
			{
				if(board.getCurrentPlayerTurn() == 0)
				{
					countdownTimer1++;
					if(countdownTimer1 > 60)
					{
						countdownTimer1 = 0;
						countdownTimerSeconds1--;
						
						if(countdownTimerSeconds1 <= 0)
						{
							if(countdownTimerMinutes1 <= 0)
							{
								board.setWinner(2);
							}
							else
							{
								countdownTimerSeconds1 = 59;
								countdownTimerMinutes1--;
							}
						}
					}
				}
				else
				{
					countdownTimer2++;
					if(countdownTimer2 > 60)
					{
						countdownTimer2 = 0;
						countdownTimerSeconds2--;
						
						if(countdownTimerSeconds2 <= 0)
						{
							if(countdownTimerMinutes2 <= 0)
							{
								board.setWinner(2);
							}
							else
							{
								countdownTimerSeconds2 = 59;
								countdownTimerMinutes2--;
							}
						}
					}
				}
			}
			//END COUNTDOWN TIMER UPDATE
		}
		
		//Button Updater Begin
		for(int x = 0; x < playButtons.length ; x++)
		{
			if (isClickingButton(playButtons[x]))
			{
				//AI vs AI
				if(gameChoice == 0)
				{
					if(x == 0)
					{
						display.setCurrentState(0);
					}
					
					if(x == 1)
					{
						if(aiWaitTime >= 100)
							aiWaitTime -= 100;
					}
					
					if(x == 2)
					{
						aiWaitTime += 100;
					}
				}
				else	//not AI vs AI
				{
					if(x == 0)
					{
						isPaused = !isPaused;
					}
					if(x == 1)
					{
						if(board.getCurrentPlayerTurn() == 0)
						{
							board.setWinner(2);
						}
						else
						{
							board.setWinner(1);
						}
					}
				}
			}
		}
		//Button Updater End
		
		//Will be false if any buttons are clicked above
		//Board Updater Begin
		
		if(!isPaused)
		{
			//AI vs AI
			if(gameChoice == 0)
			{
				aiWaitTimer++;
				
				if(aiWaitTimer > aiWaitTime)
				{
					aiWaitTimer = 0;
					board.updateBoard(0, 0);
				}
			}
			else
				if(board.currentPlayerIsAI() == false)
				{
					if(display.getMouseListener().isClicking())
					{
						int x = display.getMouseListener().getMousePosition().x / 60;
						int y = display.getMouseListener().getMousePosition().y / 60;
					
						board.updateBoard(x, y);
					}
				}
				else
					board.updateBoard(0, 0);
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
		
		//Draw Buttons
		for(int x = 0 ; x < playButtons.length ; x++)
		{	
			//highlight button if it is being hovered
			if(isHoveringButton(playButtons[x]))
			{
				g.setColor(new Color(0, 150, 0));
				g.fill(playButtons[x]);
			}
			
			g.setColor(Color.GREEN);
			g.draw(playButtons[x]);
		}
		
		//Draw Text
		g.setFont(new Font("Calibri", Font.BOLD, 30));
		
		if(gameChoice == 0)
		{
			g.drawString("End Game", (int) playButtons[0].getX() + 60, (int) playButtons[0].getY() + 60);
			g.drawString("Speed Up", (int) playButtons[1].getX() + 60, (int) playButtons[1].getY() + 60);
			g.drawString("Slow Down", (int) playButtons[2].getX() + 55, (int) playButtons[2].getY() + 60);
			
			g.setFont(new Font("Calibri", Font.BOLD, 15));
			g.drawString("Current AI wait time is " + aiWaitTime + "ms", 560, 100);
		}
		
		if(gameChoice != 0)
		{
			if(isPaused)
				g.drawString("Resume", (int) playButtons[0].getX() + 60, (int) playButtons[0].getY() + 60);
			else
				g.drawString("Pause", (int) playButtons[0].getX() + 80, (int) playButtons[0].getY() + 60);
			
			g.drawString("Forfeit", (int) playButtons[1].getX() + 80, (int) playButtons[1].getY() + 60);
		}
		
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
		
		//renders "Player [num] Wins!! for 5 seconds before resetting the game"
		if(board.getWinner() != 0)
		{
			if(winnerTimer < 300)
			{
				g.setFont(new Font("Calibri", Font.BOLD, 25));
				g.setColor(Color.GREEN);
				g.drawString("Player " + board.getWinner() + " wins! Congratulations!", 450, 540);
				winnerTimer++;
				g.setColor(Color.YELLOW);
			}
			else
				display.setCurrentState(0);
		}
		
		//Begin CountdownTimer rendering
		if(hasCountdownTimer)
		{
			//Countdown Clock Rendering
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Calibri", Font.BOLD, 20));
			
			//RENDER Player1 TIMER
			
			g.drawString("Player 1 Time Left", 40, 520);
			
			if(countdownTimerMinutes1 < 10)
				g.drawString("0" + countdownTimerMinutes1 + " : ", 80, 550);
			else
				g.drawString(countdownTimerMinutes1 + " : ", 80, 550);
			
			if(countdownTimerSeconds1 < 10)
				g.drawString("0" + countdownTimerSeconds1, 120, 550);
			else
				g.drawString("" + countdownTimerSeconds1, 120, 550);
			
			//RENDER Player2 TIMER
			
			g.drawString("Player 2 Time Left", 280, 520);
			
			if(countdownTimerMinutes2 < 10)
				g.drawString("0" + countdownTimerMinutes2 + " : ", 325, 550);
			else
				g.drawString(countdownTimerMinutes2 + " : ", 325, 550);
			
			if(countdownTimerSeconds2 < 10)
				g.drawString("0" + countdownTimerSeconds2, 360, 550);
			else
				g.drawString("" + countdownTimerSeconds2, 360, 550);
		}
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
	
	public boolean isHoveringButton(Rectangle r)
	{
		if(display.getMouseListener().getMousePosition().getX() < r.getX())
			return false;
		if(display.getMouseListener().getMousePosition().getX() > r.getX() + r.getWidth())
			return false;
		if(display.getMouseListener().getMousePosition().getY() < r.getY())
			return false;
		if(display.getMouseListener().getMousePosition().getY() > r.getY() + r.getHeight())
			return false;
		
		return true;
	}

	/**
	 * @param timerChoice
	 */
	public void setTimerSetting(int timerChoice)
	{
		if(timerChoice == 1)
			this.hasCountdownTimer = true;
		else
			this.hasCountdownTimer = false;
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
