/**
 * 
 */
package pieces;

import gameloop.Board;

public class Pawn extends Piece
{
	boolean hasMovedYet;
	
	/**
	 * Instantiate a new Pawn on a specific board position
	 */
	public Pawn(Board board, int xIndex, int yIndex, int color)
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
