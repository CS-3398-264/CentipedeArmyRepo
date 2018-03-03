/**
 * 
 */
package pieces;

import gameloop.Board;

public class Rook extends Piece
{
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
			if(!hasPieceOn(i, this.posY))
			{
				this.possibleMoves[i][this.posY] = true;
			}
			else
			{
				if(this.pieceColor != board.returnPiece(i, this.posY).pieceColor)
				{
					this.possibleMoves[i][this.posY] = true;
				}
				break;
			}
		}
		for(int i = this.posX - 1; i >= 0; i--) 
		{
			if(!hasPieceOn(i, this.posY))
			{
				this.possibleMoves[i][this.posY] = true;
			}
			else
			{
				if(this.pieceColor != board.returnPiece(i, this.posY).pieceColor)
				{
					this.possibleMoves[i][this.posY] = true;
				}
				break;
			}
		}
		if(!this.hasMovedYet())
		{
			if(this.getColor() == 1)
			{
				if(board.returnPiece(4, 7) != null && board.returnPiece(4, 7).hasMovedYet() == false
						&& board.returnPiece(2, 7) == null && board.returnPiece(3, 7) == null)
				{
					this.possibleMoves[4][7] = true;
				}
				else
				{
					if(board.returnPiece(4, 7) != null && board.returnPiece(4, 7).hasMovedYet() == false
							&& board.returnPiece(6, 7) == null && board.returnPiece(5, 7) == null)
					{
						this.possibleMoves[4][7] = true;
					}
				}
			}
			else
			{
				if(board.returnPiece(4, 0) != null && board.returnPiece(4, 0).hasMovedYet() == false
						&& board.returnPiece(2, 0) == null && board.returnPiece(3, 0) == null)
				{
					this.possibleMoves[4][0] = true;
				}
				else
				{
					if(board.returnPiece(4, 0) != null && board.returnPiece(4, 0).hasMovedYet() == false
							&& board.returnPiece(6, 0) == null && board.returnPiece(5, 0) == null)
					{
						this.possibleMoves[4][0] = true;
					}
				}
			}
		}
	}
}
