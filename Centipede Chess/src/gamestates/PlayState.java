/**
 * 
 */
package gamestates;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

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
		board = new Board(2);
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
	public void update(int x, int y)
	{
		board.updateBoard(x, y);
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
