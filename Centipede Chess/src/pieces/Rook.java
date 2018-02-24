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
	public Rook(Board board, int xIndex, int yIndex, int color)
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
			if(!hasPieceOn(this.posX, i))
			{
				this.possibleMoves[this.posX][i] = true;
			}
			else
			{
				if(this.pieceColor != board.returnPiece(this.posX, i).pieceColor)
				{
					this.possibleMoves[this.posX][i] = true;
				}
				break;
			}
		}
		for(int i = this.posY - 1; i >= 0; i--) 
		{
			if(!hasPieceOn(this.posX, i))
			{
				this.possibleMoves[this.posX][i] = true;
			}
			else
			{
				if(this.pieceColor != board.returnPiece(this.posX, i).pieceColor)
				{
					this.possibleMoves[this.posX][i] = true;
				}
				break;
			}
		}
		
		for(int i = this.posX + 1; i < 8; i++) 
		{
			if(!hasPieceOn(i, this.posX))
			{
				this.possibleMoves[i][this.posX] = true;
			}
			else
			{
				if(this.pieceColor != board.returnPiece(this.posX, i).pieceColor)
				{
					this.possibleMoves[i][this.posX] = true;
				}
				break;
			}
		}
		for(int i = this.posX - 1; i >= 0; i--) 
		{
			if(!hasPieceOn(i, this.posX))
			{
				this.possibleMoves[this.posX][i] = true;
			}
			else
			{
				if(this.pieceColor != board.returnPiece(this.posX, i).pieceColor)
				{
					this.possibleMoves[this.posX][i] = true;
				}
				break;
			}
		}
	}
}
