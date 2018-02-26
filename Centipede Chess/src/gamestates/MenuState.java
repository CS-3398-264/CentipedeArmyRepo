/**
 * 
 */
package gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import gameloop.Display;
import gameloop.Game;
import input.InputManager;

public class MenuState implements GameState
{
	Rectangle menuButtons[];
	int menuChoices;
	int gameChoice;
	int timerChoice;
	
	int AIChoice1;
	int AIChoice2;
	
	Display display;
	
	/**
	 * Instantiates a new MenuState to be used by the GameLoop
	 * @param listener 
	 */
	public MenuState(Display display)
	{
		menuButtons = new Rectangle[3];
		this.display = display;
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#init()
	 */ 
	@Override
	public void init()
	{
		menuButtons[0] = new Rectangle(275 , 175 , 250, 100);
		menuButtons[1] = new Rectangle(275 , 300 , 250, 100);
		menuButtons[2] = new Rectangle(275 , 425 , 250, 100);
		
		menuChoices = 0;
		timerChoice = 0;
		gameChoice = 0;
		AIChoice1 = -1;
		AIChoice2 = -1;
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#update()
	 */
	@Override
	public void update()
	{
		for(int x = 0 ; x < menuButtons.length ; x++)
		{
			if(isClickingButton(menuButtons[x]))
			{
				if(menuChoices == 0) //Game Type
				{
					//AI VS AI
					if(x == 0)
					{
						gameChoice = 0;
						menuChoices = 2;
					}
					else //Player VS AI
					if(x == 1)
					{
						gameChoice = 1;
						menuChoices = 1;
					}
					else //Player VS Player
					{
						gameChoice = 2;
						menuChoices = 1;
					}
				}
				else 
				if(menuChoices == 1) //Timer or No
				{
					//Timer
					if(x == 0)
					{
						timerChoice = 1;
						
						if(gameChoice == 2)
						{
							display.getPlayState().setGameSetting(gameChoice);
							display.getPlayState().setTimerSetting(timerChoice);
							display.setCurrentState(1);
						}
						else
							menuChoices = 2;
					}
					else //No Timer
					if(x == 1)
					{
						timerChoice = 0;
						
						if(gameChoice == 2)
						{
							display.getPlayState().setGameSetting(gameChoice);
							display.getPlayState().setTimerSetting(timerChoice);
							display.setCurrentState(1);
						}
						else
							menuChoices = 2;
					}
					else //Return to Menu
					{
						init();
						menuChoices = 0;
					}
				}
				else 
				if(menuChoices == 2) // AI Choice
				{
					//Easy
					if(x == 0)
					{
						if(gameChoice == 1)
						{
							AIChoice1 = 0;
							display.getPlayState().setGameSetting(gameChoice);
							display.getPlayState().setTimerSetting(timerChoice);
							display.getPlayState().setAIDifficultyOne(AIChoice1);
							display.setCurrentState(1);
						}
						
						//If AIvsAI and AIOne has already been picked
						if(gameChoice == 0 && AIChoice1 != -1)
						{
							AIChoice2 = 0;
							display.getPlayState().setGameSetting(gameChoice);
							display.getPlayState().setTimerSetting(timerChoice);
							display.getPlayState().setAIDifficultyOne(AIChoice1);
							display.getPlayState().setAIDifficultyTwo(AIChoice2);
							display.setCurrentState(1);
						}
						
						if(gameChoice == 0 && AIChoice1 == -1)
						{
							AIChoice1 = 0;
						}
					}
					else //Hard
					if(x == 1)
					{
						if(gameChoice == 1)
						{
							AIChoice1 = 1;
							display.getPlayState().setGameSetting(gameChoice);
							display.getPlayState().setTimerSetting(timerChoice);
							display.getPlayState().setAIDifficultyOne(AIChoice1);
							display.setCurrentState(1);
						}
						
						if(gameChoice == 0 && AIChoice1 != -1)
						{
							AIChoice2 = 1;
							display.getPlayState().setGameSetting(gameChoice);
							display.getPlayState().setTimerSetting(timerChoice);
							display.getPlayState().setAIDifficultyOne(AIChoice1);
							display.getPlayState().setAIDifficultyOne(AIChoice2);
							display.setCurrentState(1);
						}
						
						if(gameChoice == 0 && AIChoice1 == -1)
						{
							AIChoice1 = 1;
						}
					}
					else //Return to Menu
					{
						init();
						menuChoices = 0;
					}
				}
			}
		}
		
		display.getMouseListener().setClicking(false);
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#render(java.awt.Graphics2D)
	 */
	@Override
	public void render(Graphics2D g)
	{
		//Draw Buttons
		for(int x = 0 ; x < menuButtons.length ; x++)
		{	
			//highlight button if it is being hovered
			if(isHoveringButton(menuButtons[x]))
			{
				g.setColor(new Color(0, 150, 0));
				g.fill(menuButtons[x]);
			}
			
			g.setColor(Color.GREEN);
			g.draw(menuButtons[x]);
		}
		
		//Draw Text
		g.setFont(new Font("Calibri", Font.BOLD, 30));
		if(menuChoices == 0)
		{
			g.drawString("Please Pick Your Game Type", 230, 125);
			g.drawString("AI vs AI", (int) menuButtons[0].getX() + 80, (int) menuButtons[0].getY() + 60);
			g.drawString("Player vs AI", (int) menuButtons[1].getX() + 50, (int) menuButtons[1].getY() + 60);
			g.drawString("Player vs Player", (int) menuButtons[2].getX() + 25, (int) menuButtons[2].getY() + 60);
		}
		else
		if(menuChoices == 1)
		{
			g.drawString("Please Pick Your Game Mode", 225, 125);
			g.drawString("Timed Mode", (int) menuButtons[0].getX() + 50, (int) menuButtons[0].getY() + 60);
			g.drawString("Casual Mode", (int) menuButtons[1].getX() + 45, (int) menuButtons[1].getY() + 60);
			g.drawString("Return to Menu", (int) menuButtons[2].getX() + 25, (int) menuButtons[2].getY() + 60);
		}
		else
		if(menuChoices == 2)
		{
			if(AIChoice1 == -1)
				g.drawString("Please Pick Your AI", 280, 125);
			else
				g.drawString("Please Pick Your Second AI", 235, 125);
			
			g.drawString("Easy", (int) menuButtons[0].getX() + 95, (int) menuButtons[0].getY() + 60);
			g.drawString("Hard", (int) menuButtons[1].getX() + 90, (int) menuButtons[1].getY() + 60);
			g.drawString("Return to Menu", (int) menuButtons[2].getX() + 25, (int) menuButtons[2].getY() + 60);
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
	 * Changes the GameLoop gamestate to the PlayState,
	 * performing any actions required to initiate the playstate
	 * game loop.
	 */
	public void beginGame()
	{
		display.setCurrentState(1);
	}
}
