/**
 * 
 */
package pieces;

import gameloop.Board;

public class King extends Piece
{
	/**
	 * Instantiate a new King on a specific board position
	 */
	public King(Board board, int xIndex, int yIndex, int color)
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
