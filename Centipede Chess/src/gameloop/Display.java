/**
 * 
 */
package gameloop;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import gamestates.MenuState;
import gamestates.PlayState;
import input.InputManager;

public class Display extends Canvas
{
	private static final long serialVersionUID = 1L;

	private Graphics2D g;
	private BufferStrategy bs;
	
	private InputManager listener;
	private JFrame frame;
	
	private PlayState playstate;
	private MenuState menustate;
	
	private int width, height;
	
	/**
	 * 0 = Menu
	 * 1 = Play
	 */
	private int currentState;
	
	/**
	 * Initializes new Display window and managers
	 */
	public Display()
	{
		listener = new InputManager();
		currentState = 0;
		width = 800;
		height = 600;
		
		playstate = new PlayState(this);
		menustate = new MenuState(this);
		menustate.init();
		
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		createWindow();
	}
	
	/**
	 * Initializes the JFrame and BorderLayout that the
	 * graphics will be displayed on
	 */
	public void createWindow()
	{
		frame = new JFrame("Chess");
		
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setFocusable(false);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.add(this, BorderLayout.CENTER);
	}
	
	/**
	 * Updates the selected GameState
	 */
	public void update()
	{
		if(currentState == 0)
		{
			menustate.update();
		}
		else
		{
			playstate.update();
		}
	}
	
	/**
	 * Creates the bufferstrategy and graphics library that will
	 * be used to render to the JFrame, and
	 * Draws from the graphics library into the JFrame,
	 * calls render methods from selected GameState
	 */
	public void render()
	{
		bs = this.getBufferStrategy();
		if(bs == null) { createBufferStrategy(2); return;}
		
		g = (Graphics2D) bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		//Anti-Aliasing thing to keep menu text from looking ugly as hell
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(currentState == 0)
		{	
			menustate.render(g);
		}
		else
		{
			playstate.render(g);
		}
		
		g.dispose();
		bs.show();
	}

	/**
	 * @return
	 */
	public InputManager getMouseListener()
	{
		return listener;
	}

	/**
	 * @param i
	 */
	public void setCurrentState(int i)
	{
		currentState = i;
		
		if(currentState == 0)
			menustate.init();
		if(currentState == 1)
			playstate.init();
	}

	/**
	 * @return
	 */
	public PlayState getPlayState()
	{
		return playstate;
	}
}
