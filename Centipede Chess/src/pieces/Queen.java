/**
 * 
 */
package pieces;

import gameloop.Board;

public class Queen extends Piece
{
	/**
	 * Instantiate a new Queen on a specific board position
	 */
	public Queen(Board board, int xIndex, int yIndex, int color)
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
