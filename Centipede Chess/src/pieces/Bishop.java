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
		for(int i = 1; i < 8; i++)
		{
			if(this.posX + i > 7 || this.posY + i > 7)
				;
			else if(!hasPieceOn(this.posX + i,this.posY + i))
			{
				this.possibleMoves[this.posX + i][this.posY + i] = true;
			}
			else
			{
				if(this.pieceColor != board.returnPiece(this.posX + i,this.posY + i).pieceColor)
				{
					this.possibleMoves[this.posX + i][this.posY + i] = true;
				}
				break;
			}
		}
		for(int i = 1; i < 8; i++)
		{
			if(this.posX - i < 0 || this.posY - i < 0)
				;
			else if(!hasPieceOn(this.posX - i,this.posY - i))
			{
				this.possibleMoves[this.posX - i][this.posY - i] = true;
			}
			else
			{
				if(this.pieceColor != board.returnPiece(this.posX - i,this.posY - i).pieceColor)
				{
					this.possibleMoves[this.posX - i][this.posY - i] = true;
				}
				break;
			}
		}
		
		for(int i = 1; i < 8; i++)
		{
			if(this.posY + i > 7 || this.posX - i < 0)
				;
			else if(!hasPieceOn(this.posX - i,this.posY + i))
			{
				this.possibleMoves[this.posX - i][this.posY + i] = true;
			}
			else
			{
				if(this.pieceColor != board.returnPiece(this.posX - i,this.posY + i).pieceColor)
				{
					this.possibleMoves[this.posX - i][this.posY + i] = true;
				}
				break;
			}
		}
		for(int i = 1; i < 8; i++)
		{
			if(this.posY - i < 0 || this.posX + i > 7)
				;
			else if(!hasPieceOn(this.posX + i,this.posY - i))
			{
				this.possibleMoves[this.posX + i][this.posY - i] = true;
			}
			else
			{
				if(this.pieceColor != board.returnPiece(this.posX + i,this.posY - i).pieceColor)
				{
					this.possibleMoves[this.posX + i][this.posY - i] = true;
				}
				break;
			}
		}
	}
}
