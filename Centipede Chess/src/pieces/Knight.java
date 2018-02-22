/**
 * 
 */
package pieces;

import gameloop.Board;

public class Knight extends Piece
{
	boolean hasMovedYet;
	/**
	 * Instantiate a new Knight on a specific board position
	 */
	public Knight(Board board, int xIndex, int yIndex)
	{
		super(board, xIndex, yIndex);
	}

	/* (non-Javadoc)
	 * @see pieces.Piece#updatePossibleMoves()
	 */
	@Override
	public void updatePossibleMoves()
	{
		
	}
}
