/**
 * 
 */
package users;

import gameloop.Board;
import pieces.Piece;

public class AI implements User
{
	Board board; 
	boolean myTurn = false;
	
	/**
	 * Initiates new AI to calculate moves and update the board based off calculation
	 * @param board
	 */
	public AI(boolean turn)
	{
		this.myTurn = turn;
	}
	
	/**
	 * Sets who has the next turn
	 */
	public void setNextTurn(boolean turn)
	{
		this.myTurn = turn;
	}
	
	public boolean hasMoved()
	{
		return myTurn;
	}
	
	/**
	 * Applies MiniMax algorithm to AI and chooses a move/manipulates board
	 */
	public void calculateMove()
	{
		
	}

	@Override
	public void makeMove(Piece p, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
