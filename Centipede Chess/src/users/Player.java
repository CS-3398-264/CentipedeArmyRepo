/**
 * 
 */
package users;

import gameloop.Board;
import pieces.Piece;

public class Player implements User
{
	int myColor;
	Piece selectedPiece;
	Board board;
	boolean myTurn = false; 
	
	/**
	 * Initiates new player to check input and update the board based off input
	 * @param board
	 */
	public Player(Board board, boolean turn)
	{
		this.myTurn = turn;
		this.board = board;
		if(this.myTurn)
		{
			myColor = 1;//white
		}
		else
		{
			myColor = 0;//black
		}
	}
	
	public void setNextTurn(boolean turn)
	{
		this.myTurn = turn;
	}
	
	public boolean hasMoved()
	{
		return myTurn;
	}

	/**
	 * Checks input and updates board
	 */
	public void checkInput(int x, int y)
	{
		Piece piece = board.returnPiece(x, y);
		if(selectedPiece != null && selectedPiece.getColor() == this.myColor)
		{
			if(x < 0 || x > 7 || y < 0 || y > 7);
			else if(selectedPiece.getPossibleMoves()[x][y])
			{
				makeMove(selectedPiece, x, y);
				if(selectedPiece.getClass().getName().equals("pieces.Pawn"))
					selectedPiece.setMoved();
			}
		}
		if(piece != null && piece.getColor() == this.myColor)
		{
			if(board.returnPiece(x, y) != null)
			{
				selectedPiece = board.returnPiece(x, y);
				selectedPiece.updatePossibleMoves();
				board.setPossibleMoves(selectedPiece.getPossibleMoves());
			}
			
		}
		else
		{
			board.clearPossibleMoves();
		}
	}

	@Override
	public void makeMove(Piece p, int x, int y) 
	{
		myTurn = false;
		board = p.moveTo(x, y);
	}
}
