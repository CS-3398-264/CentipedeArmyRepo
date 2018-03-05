/**
 * 
 */
package users;

import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

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
		if(difficulty == 0)
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
						makeMove(piece, x, y);
						if(piece.getClass().getName().equals("pieces.Pawn"))
							piece.setMoved();
					}
				}
				piece = null;
				giveUpCount = 0;
			}
		}
		else if(difficulty == 1)
		{
			evaluateBoard();
		}
	}

	public void evaluateBoard()
	{
		boolean myPossibleMoves[][] = new boolean[8][8];
		boolean theirPossibleMoves[][] = new boolean[8][8];
		
		int bestFromX = 0;
		int bestFromY = 0;
		int bestMoveToX = -1;
		int bestMoveToY = -1;
		int bestMoveValue = -200;
		int tempValue = 0;
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{//Finds a piece to move
				if(board.returnPiece(i, j) != null && board.returnPiece(i, j).getColor() == this.myColor)
				{
					board.returnPiece(i, j).clearPossibleMoves();
					board.returnPiece(i, j).updatePossibleMoves();
					myPossibleMoves = board.returnPiece(i, j).getPossibleMoves();
					for(int x = 0; x < 8; x++)
					{
						for(int y = 0; y < 8; y++)
						{
							if(myPossibleMoves[x][y] == true)
							{//finds a piece to kill
								if(board.returnPiece(x, y) != null && board.returnPiece(x, y).getColor() != this.myColor)
								{
									Piece temp = board.returnPiece(x, y);
									board.setNull(x, y);
									for(int xx = 0; xx < 8; xx++)
									{
										for(int yy = 0; yy < 8; yy++)
										{
											if(board.returnPiece(xx, yy) != null && board.returnPiece(xx, yy).getColor() != this.myColor)
											{
												board.returnPiece(xx, yy).clearPossibleMoves();
												board.returnPiece(xx, yy).updatePossibleMoves();
												theirPossibleMoves = board.returnPiece(xx, yy).getPossibleMoves();
												if(theirPossibleMoves[x][y] == true)//checks if I kill you, can you kill me?
												{
													tempValue = this.getValue(temp) + this.getValue(board.returnPiece(i, j));
													if(tempValue > bestMoveValue)
													{
														bestMoveValue = tempValue;
														bestFromX = i;
														bestFromY = j;
														bestMoveToX = x;
														bestMoveToY = y;
													}
												}
												else
												{
													tempValue = this.getValue(temp);
													if(tempValue > bestMoveValue)
													{
														bestMoveValue = tempValue;
														bestFromX = i;
														bestFromY = j;
														bestMoveToX = x;
														bestMoveToY = y;
													}
												}
											}
										}
									}
									board.setPiece(temp, x, y);
								}
							}
						}
					}
				}
			}
		}
		if(bestMoveToX < 0)//No good moves, just move randomly
		{	
			Piece piece = null;
			int x = 0;
			int y = 0;
			int giveUpCount = 0;
			while(!hasMoved())
			{
				for(int i = 0; i < 8; i++)
				{
					for(int j = 0; j < 8; j++)
					{
						theirPossibleMoves[i][j] = false;
					}	
				}
				for(int i = 0; i < 8; i++)
				{
					for(int j = 0; j < 8; j++)
					{
						if(board.returnPiece(i, j) != null && board.returnPiece(i, j).getColor() != this.myColor)
						{
							board.returnPiece(i, j).clearPossibleMoves();
							board.returnPiece(i, j).updatePossibleMoves();
							for(int ii = 0; ii < 8; ii++)
							{
								for(int jj = 0; jj < 8; jj++)
								{
									if(board.returnPiece(i, j).getPossibleMoves()[ii][jj] == true)
										theirPossibleMoves[ii][jj] = true;
								}
							}
						}
					}
				}
				board.clearPossibleMoves();
				//randomly selects a piece to move
				while(piece == null || piece.getColor() != this.myColor)
				{
					x = random.nextInt(8);
					y = random.nextInt(8);
					piece = board.returnPiece(x, y);
				}
					
				
				board.returnPiece(x, y).clearPossibleMoves();
				board.returnPiece(x, y).updatePossibleMoves();
				for(int ii = 0; ii < 8; ii++)
				{
					for(int jj = 0; jj < 8; jj++)
					{
						if(board.returnPiece(x, y).getPossibleMoves()[ii][jj] == true && theirPossibleMoves[ii][jj] == false)
						{
							bestFromX = x;
							bestFromY = y;
							bestMoveToX = ii;
							bestMoveToY =jj;
						}
					}
				}
				if(difficulty == 1 && bestMoveToX > 0)
				{
					makeMove(piece, bestMoveToX, bestMoveToY);
				}
				piece = null;
				giveUpCount = 0;	
			}
		}
		else
		{
			Piece tempP = board.returnPiece(bestFromX, bestFromY);
			
			makeMove(tempP, bestMoveToX, bestMoveToY);
		}
	}
	
	public int getValue(Piece piece)
	{
		int value = 0;
		int pieceColor = piece.getColor();
		
		switch(piece.getClass().getSimpleName())
		{
		case ("Bishop"):
			if(pieceColor == this.myColor)
			{
				value = -30;
			}
			else
			{
				value = 30;
			}
			break;
		case ("King"):
			if(pieceColor == this.myColor)
			{
				value = -900;
			}
			else
			{
				value = 900;
			}
			break;
		case ("Knight"):
			if(pieceColor == this.myColor)
			{
				value = -30;
			}
			else
			{
				value = 30;
			}
			break;
		case ("Pawn"):
			if(pieceColor == this.myColor)
			{
				value = -10;
			}
			else
			{
				value = 10;
			}
			break;
		case ("Queen"):
			if(pieceColor == this.myColor)
			{ 
				value = -90;
			}
			else
			{
				value = 90;
			}
			break;
		case ("Rook"):
			if(pieceColor == this.myColor)
			{
				value = -50;
			}
			else
			{
				value = 50;
			}
			break;
		}
		return value;
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
