/**
 * 
 */
package gamestates;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MenuState implements GameState
{
	Rectangle menuButtons[];
	int menuChoices;
	
	/**
	 * Instantiates a new MenuState to be used by the GameLoop
	 */
	public MenuState()
	{
		menuButtons = new Rectangle[0];
		menuChoices = 0;
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#init()
	 */
	@Override
	public void init()
	{
		
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#update()
	 */
	@Override
	public void update()
	{
		
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#render(java.awt.Graphics2D)
	 */
	@Override
	public void render(Graphics2D g)
	{
		
	}

	/* (non-Javadoc)
	 * @see gamestates.GameState#isClickingButton(java.awt.Rectangle)
	 */
	@Override
	public void isClickingButton(Rectangle rect)
	{
		
	}
	
	/**
	 * Changes the GameLoop gamestate to the PlayState,
	 * performing any actions required to initiate the playstate
	 * game loop.
	 */
	public void beginGame()
	{
		
	}

}
