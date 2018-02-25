/**
 * 
 */
package pieces;

import gameloop.Board;

public class Pawn extends Piece
{
	public boolean hasMovedYet;
	
	/**
	 * Instantiate a new Pawn on a specific board position
	 */
	public Pawn(Board board, int xIndex, int yIndex, int color)
	{
		super(board, xIndex, yIndex, color);
		hasMovedYet = false;
	}

	public void setMoved()
	{
		hasMovedYet = true;
	}
	
	/* (non-Javadoc)
	 * @see pieces.Piece#updatePossibleMoves()
	 */
	@Override
	public void updatePossibleMoves()
	{ 
		int color = 1;
		if(this.pieceColor == 1)
			color = -1;
		
		if(this.pieceColor == 1 && this.posY == 0)
			return;
		if(this.pieceColor == 0 && this.posY == 7)
			return;
		
		if(!hasPieceOn(this.posX, this.posY + 1*color))
		{
			this.possibleMoves[this.posX][this.posY + 1*color] = true;
		}
		if(!hasMovedYet)
		{
			if(!hasPieceOn(this.posX, this.posY + 2*color))
			{
				this.possibleMoves[this.posX][this.posY + 2*color] = true;
			}
		}
		
		if(this.posX != 7)
			if(board.returnPiece(this.posX + 1, this.posY + 1*color) != null)
				if(this.pieceColor != board.returnPiece(this.posX + 1, this.posY + 1*color).pieceColor)
				{
					this.possibleMoves[this.posX + 1][this.posY + 1*color] = true;
				}
		if(this.posX != 0)
			if(board.returnPiece(this.posX - 1, this.posY + 1*color) != null)
				if(this.pieceColor != board.returnPiece(this.posX - 1, this.posY + 1*color).pieceColor)
				{
					this.possibleMoves[this.posX - 1][this.posY + 1*color] = true;
				}
	}
}
