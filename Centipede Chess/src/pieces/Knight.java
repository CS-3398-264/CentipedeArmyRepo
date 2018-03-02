/**
 * 
 */
package pieces;

import gameloop.Board;

public class Knight extends Piece
{
	/**
	 * Instantiate a new Knight on a specific board position
	 */
	public Knight(Board board, int xIndex, int yIndex, int color)
	{
		super(board, xIndex, yIndex, color);
	}

	/* (non-Javadoc)
	 * @see pieces.Piece#updatePossibleMoves()
	 */
	@Override
	public void updatePossibleMoves()
	{
		if(this.posX + 2 > 7 || this.posY + 1 > 7)
			;
		else if(!hasPieceOn(this.posX + 2,this.posY + 1))
		{
			this.possibleMoves[this.posX + 2][this.posY + 1] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX + 2,this.posY + 1).pieceColor)
			{
				this.possibleMoves[this.posX + 2][this.posY + 1] = true;
			}
		}
		if(this.posX - 2 < 0 || this.posY + 1 > 7)
			;
		else if(!hasPieceOn(this.posX - 2,this.posY + 1))
		{
			this.possibleMoves[this.posX - 2][this.posY + 1] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX - 2,this.posY + 1).pieceColor)
			{
				this.possibleMoves[this.posX - 2][this.posY + 1] = true;
			}
		}
		
		if(this.posX + 2 > 7 || this.posY - 1 < 0)
			;
		else if(!hasPieceOn(this.posX + 2,this.posY - 1))
		{
			this.possibleMoves[this.posX + 2][this.posY - 1] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX + 2,this.posY - 1).pieceColor)
			{
				this.possibleMoves[this.posX + 2][this.posY - 1] = true;
			}
		}
		if(this.posX - 2 < 0 || this.posY - 1 < 0)
			;
		else if(!hasPieceOn(this.posX - 2,this.posY - 1))
		{
			this.possibleMoves[this.posX - 2][this.posY - 1] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX - 2,this.posY - 1).pieceColor)
			{
				this.possibleMoves[this.posX - 2][this.posY - 1] = true;
			}
		}
		
		
		
		if(this.posX + 1 > 7 || this.posY + 2 > 7)
			;
		else if(!hasPieceOn(this.posX + 1,this.posY + 2))
		{
			this.possibleMoves[this.posX + 1][this.posY + 2] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX + 1,this.posY + 2).pieceColor)
			{
				this.possibleMoves[this.posX + 1][this.posY + 2] = true;
			}
		}
		if(this.posX - 1 < 0 || this.posY + 2 > 7)
			;
		else if(!hasPieceOn(this.posX - 1,this.posY + 2))
		{
			this.possibleMoves[this.posX - 1][this.posY + 2] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX - 1,this.posY + 2).pieceColor)
			{
				this.possibleMoves[this.posX - 1][this.posY + 2] = true;
			}
		}
		
		if(this.posX + 1 > 7 || this.posY - 2 < 0)
			;
		else if(!hasPieceOn(this.posX + 1,this.posY - 2))
		{
			this.possibleMoves[this.posX + 1][this.posY - 2] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX + 1,this.posY - 2).pieceColor)
			{
				this.possibleMoves[this.posX + 1][this.posY - 2] = true;
			}
		}
		if(this.posX - 1 < 0 || this.posY - 2 < 0)
			;
		else if(!hasPieceOn(this.posX - 1,this.posY - 2))
		{
			this.possibleMoves[this.posX - 1][this.posY - 2] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX - 1,this.posY - 2).pieceColor)
			{
				this.possibleMoves[this.posX - 1][this.posY - 2] = true;
			}
		}
		
	}
}
