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
		if(this.posX + 1 > 7);
		else if(!hasPieceOn(this.posX + 1, this.posY))
		{
			this.possibleMoves[this.posX + 1][this.posY] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX + 1, this.posY).pieceColor)
			{
				this.possibleMoves[this.posX + 1][this.posY] = true;
			}
		}
		if(this.posX - 1 < 0);
		else if(!hasPieceOn(this.posX - 1, this.posY))
		{
			this.possibleMoves[this.posX - 1][this.posY] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX - 1, this.posY).pieceColor)
			{
				this.possibleMoves[this.posX - 1][this.posY] = true;
			}
		}


		if(this.posY + 1 > 7);
		else if(!hasPieceOn(this.posX, this.posY + 1))
		{
			this.possibleMoves[this.posX][this.posY + 1] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX, this.posY + 1).pieceColor)
			{
				this.possibleMoves[this.posX][this.posY + 1] = true;
			}
		}
		if(this.posY - 1 < 0);
		else if(!hasPieceOn(this.posX, this.posY - 1))
		{
			this.possibleMoves[this.posX][this.posY - 1] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX, this.posY - 1).pieceColor)
			{
				this.possibleMoves[this.posX][this.posY - 1] = true;
			}
		}
		
		if(this.posX + 1 > 7 || this.posY + 1 > 7);
		else if(!hasPieceOn(this.posX + 1, this.posY + 1))
		{
			this.possibleMoves[this.posX + 1][this.posY + 1] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX + 1, this.posY + 1).pieceColor)
			{
				this.possibleMoves[this.posX + 1][this.posY + 1] = true;
			}
		} 
		if(this.posX - 1 < 0 || this.posY - 1 < 0);
		else if(!hasPieceOn(this.posX - 1, this.posY - 1))
		{
			this.possibleMoves[this.posX - 1][this.posY - 1] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX - 1, this.posY - 1).pieceColor)
			{
				this.possibleMoves[this.posX - 1][this.posY - 1] = true;
			}
		}


		if(this.posY + 1 > 7 || this.posX - 1 < 0);
		else if(!hasPieceOn(this.posX - 1, this.posY + 1))
		{
			this.possibleMoves[this.posX - 1][this.posY + 1] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX - 1, this.posY + 1).pieceColor)
			{
				this.possibleMoves[this.posX - 1][this.posY + 1] = true;
			}
		}
		if(this.posY - 1 < 0 || this.posX + 1 > 7);
		else if(!hasPieceOn(this.posX + 1, this.posY - 1))
		{
			this.possibleMoves[this.posX + 1][this.posY - 1] = true;
		}
		else
		{
			if(this.pieceColor != board.returnPiece(this.posX + 1, this.posY - 1).pieceColor)
			{
				this.possibleMoves[this.posX + 1][this.posY - 1] = true;
			}
		}
		
		
		if(!this.hasMovedYet())
		{
			if(this.getColor() == 1)//white king
			{
				if(board.returnPiece(0, 7) != null && board.returnPiece(0, 7).hasMovedYet() == false//left rook
						&& board.returnPiece(2, 7) == null && board.returnPiece(3, 7) == null)
				{
					this.possibleMoves[0][7] = true;
				}
				if(board.returnPiece(7, 7) != null && board.returnPiece(7, 7).hasMovedYet() == false//right rook
						&& board.returnPiece(5, 7) == null && board.returnPiece(6, 7) == null)
				{
					this.possibleMoves[7][7] = true;
				}
			}
			else//black king
			{
				if(board.returnPiece(0, 0) != null && board.returnPiece(0, 0).hasMovedYet() == false//left rook
						&& board.returnPiece(2, 0) == null && board.returnPiece(3, 0) == null)
				{
					this.possibleMoves[0][0] = true;
				}
				if(board.returnPiece(7, 0) != null && board.returnPiece(7, 0).hasMovedYet() == false//right rook
						&& board.returnPiece(5, 0) == null && board.returnPiece(6, 0) == null)
				{
					this.possibleMoves[7][0] = true;
				}
			}
		}
	}
}
