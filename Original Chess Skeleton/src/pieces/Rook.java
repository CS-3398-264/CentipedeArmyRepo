/**
 * 
 */
package pieces;

import gameloop.Board;

public class Rook extends Piece
{
	boolean hasMovedYet;
	/**
	 * Instantiate a new Rook on a specific board position
	 */
	public Rook(Board board, int xIndex, int yIndex)
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
