/**
 * 
 */
package gameloop;

public class Game
{
	private static boolean isRunning;
	private static Display display;
	
	/**
	 * Begins the program by passing off control to the start -> run() method
	 * @param args
	 */
	public static void main(String args[])
	{
		start();
	}
	
	/**
	 * Initiates Display
	 * Starts GameLoop
	 */
	public static void start()
	{
		display = new Display();
		
		if(isRunning)
			return;
		isRunning = true;
		
		run();
	}

	/**
	 * Algorithm that works to update and render the game at 60 Ticks per Second
	 * by using real world time intervals
	 * 
	 * Algorithm will also be used to create timers
	 */
	public static void run()
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
