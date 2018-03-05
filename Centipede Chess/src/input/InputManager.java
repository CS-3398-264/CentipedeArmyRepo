/**
 * 
 */
package input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputManager implements MouseListener, MouseMotionListener
{
	boolean isClicking;
	Point mousePosition;

	public InputManager()
	{
		mousePosition = new Point();
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	//@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		mousePosition = e.getPoint();
		isClicking = true;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{
		mousePosition = e.getPoint();
		isClicking = false;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e)
	{
		mousePosition = e.getPoint();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e)
	{
		mousePosition = e.getPoint();
	}
	
	public void setClicking(boolean isClicking) {this.isClicking = isClicking;}
	public boolean isClicking() {return isClicking;}
	
	public Point getMousePosition() {return mousePosition;}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		mousePosition = e.getPoint();
	}
	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent e)
	{
		mousePosition = e.getPoint();
	}

}
