/**
 * 
 */
package users;

import gameloop.Board;
import pieces.Piece;

public class Player implements User
{
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
		if(selectedPiece != null)
			if(selectedPiece.getPossibleMoves()[x][y])
			{
				makeMove(selectedPiece, x, y);
				if(selectedPiece.getClass().getName().equals("pieces.Pawn"))
					selectedPiece.setMoved();
			}
		if(piece != null)
		{
			selectedPiece = board.returnPiece(x, y);
			selectedPiece.updatePossibleMoves();
			board.setPossibleMoves(selectedPiece.getPossibleMoves());
		}
		else
		{
			board.clearPossibleMoves();
		}
	}

	@Override
	public void makeMove(Piece p, int x, int y) {
		
		board = p.moveTo(x, y);
		myTurn = false;
	}
}
