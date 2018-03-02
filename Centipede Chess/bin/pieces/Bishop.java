/**
 * 
 */
package pieces;

import gameloop.Board;

public class Bishop extends Piece
{
	boolean hasMovedYet;
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
		for(int i = this.posY + 1; i < 8; i++) 
		{
		int j = i + 1;
			
				if(!hasPieceOn(j, i))
					{
						this.possibleMoves[j][i] = true;
					}
				else
				{
					if(this.pieceColor != board.returnPiece(j, i).pieceColor)
						{
							this.possibleMoves[j][i] = true;
						}
					break;
				}
		
		}
			
		
	}
}
