/**
 * 
 */
package gamestates;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import gameloop.Board;

public class PlayState implements GameState
{
	Rectangle playButtons[];
	Board board;
	
	/**
	 * Instantiates a new MenuState to be used by the GameLoop
	 */
	public PlayState()
	{
		playButtons = new Rectangle[0];
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
	 * Performs required changes to the board based on any buttons clicked
	 */
	public void updateBoard()
	{
		
	}

}
