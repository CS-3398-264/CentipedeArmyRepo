/**
 * 
 */
package gameloop;

public class Game implements Runnable
{
	boolean isRunning;
	Thread loopThread;
	Display display;
	
	/**
	 * Creates new Game object in order to avoid statics
	 * @param args
	 */
	public static void main(String args[])
	{
		Game game = new Game();
		game.start();
	}
	
	/**
	 * Initiates Display
	 * Starts GameLoop thread in order to take advantage of Runnable
	 */
	public void start()
	{
		display = new Display();
		
		if(isRunning)
			return;
		isRunning = true;
		
		loopThread = new Thread(this);
		loopThread.start();
	}

	/**
	 * Algorithm that works to update and render the game at 60 Ticks per Second
	 * by using real world time intervals
	 * 
	 * Algorithm will also be used to create timers
	 */
	public void run()
	{
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		while(isRunning)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			
			while(delta >= 1)
			{
				display.update();
				display.render();
				delta -= 1;
			}
			
			if(System.currentTimeMillis() - lastTimer > 1000)
			{
				lastTimer += 1000;
			}
		}
	}

}
