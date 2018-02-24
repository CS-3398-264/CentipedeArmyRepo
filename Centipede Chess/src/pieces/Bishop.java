/**
 * 
 */
package pieces;

import gameloop.Board;

public class Bishop extends Piece
{
	/**
	 * Instantiate a new Bishop on a specific board position
	 */
	public Bishop(Board board, int xIndex, int yIndex, int color)
	{
		super(board, xIndex, yIndex, color);
	}

	/* (non-Javadoc)
	 * @see pieces.Piece#updatePossibleMoves()
	 */
	@Override
	public void updatePossibleMoves()
	{
		
	}
}
