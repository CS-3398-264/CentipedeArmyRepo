/**
 * 
 */
package gamestates;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface GameState
{
	
	/**
	 * Calls the state initiation method whenever the
	 * state is switched to the active state
	 */
	public void init();
	
	/**
	 * Calls the state update feature
	 */
	public void update();
	
	/**
	 * Calls the state render feature to draw
	 * any objects/text to the screen
	 */
	public void render(Graphics2D g);

	/**
	 * checks to see if a button is being clicked, and performs
	 * an action if that button is being clicked
	 * @param rect
	 */
	public void isClickingButton(Rectangle rect);

	void update(int x, int y);
}
