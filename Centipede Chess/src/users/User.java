/**
 * 
 */
package users;

import pieces.Piece;

public interface User
{
	void setNextTurn(boolean turn);
	boolean hasMoved();
	void makeMove(Piece p, int x, int y);
}
