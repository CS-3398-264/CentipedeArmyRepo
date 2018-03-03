/**
 * 
 */
package users;

import java.util.Random;

import gameloop.Board;
import pieces.Piece;

public class AI implements User
{
	int myColor;
	int difficulty; //0 if Easy, 1 if Hard
	Board board; 
	boolean myTurn = false;
	
	Random random;
	
	/**
	 * Initiates new AI to calculate moves and update the board based off calculation
	 * @param board
	 */
	public AI(Board board, boolean turn)
	{
		this.random = new Random();
		this.board = board;
		this.myTurn = turn;
		
		if(myTurn)
		{
			myColor = 1;
		}
		else
		{
			myColor = 0;
		}
	}
	
	/**
	 * Sets who has the next turn
	 */
	public void setNextTurn(boolean turn)
	{
		this.myTurn = turn;
	}
	
	public boolean hasMoved()
	{
		return !myTurn;
	}
	
	/**
	 * Applies algorithm to AI and chooses a move/manipulates board
	 */
	public void calculateMove()
	{
			Piece piece = null;
			int x = 0;
			int y = 0;
			int giveUpCount = 0;
			while(!hasMoved())
			{
				//randomly selects a piece to move
				while(piece == null || piece.getColor() != this.myColor)
					piece = board.returnPiece(random.nextInt(8), random.nextInt(8));
				
				piece.updatePossibleMoves();
				board.setPossibleMoves(piece.getPossibleMoves());
				
				//gives up after an arbitrary amount of attempts because it could have
				//selected a piece that has no possible moves (Like a king move 1)
				while(giveUpCount < 40)
				{
					giveUpCount++;
					
					x = random.nextInt(8);
					y = random.nextInt(8);
					
					//if a piece finds a possible move
					if(piece.getPossibleMoves()[x][y] == true)
					{
						//Immediately take possible move
						if(difficulty == 0)
						{
							makeMove(piece, x, y);
							if(piece.getClass().getName().equals("pieces.Pawn"))
								piece.setMoved();
						}
						else
						if(difficulty == 1)
						{
							//
							
							
							
							//
							makeMove(piece, x, y);
							if(piece.getClass().getName().equals("pieces.Pawn"))
								piece.setMoved();
						}
					}
				}
				piece = null;
				giveUpCount = 0;
			}
	}

	@Override
	public void makeMove(Piece p, int x, int y) 
	{
		myTurn = false;
		board = p.moveTo(x, y);
	}
	
	public void setDifficulty(int diff)
	{
		this.difficulty = diff;
	}

}
