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
				System.out.println((this.posX + i) + " " + (this.posY + i));
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
	}
}
