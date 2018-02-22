/**
 * 
 */
package pieces;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import gameloop.Board;

public abstract class Piece
{
	int posX, posY;
	/**
	 * 0 if Black | 1 if White
	 */
	int pieceColor;
	BufferedImage pieceImage;
	
	boolean possibleMoves[][];
	Board board;

	/**
	 * Instantiate a new Piece on a specific board position
	 */
	public Piece(Board board, int x, int y)
	{
		possibleMoves = new boolean[8][8];
		this.board = board;
		
		posX = x;
		posY = y;
	}
	
	/**
	 * Moves piece on the board to x, y
	 * @param x
	 * @param y
	 * @return the new Board to update the PlayState Board
	 */
	public Board moveTo(int x, int y)
	{
		//TODO
		return board;
	}
	
	/**
	 * Checks to see if PlayState board has a piece on a specific
	 * spot. Used for Piece possibleMove updating.
	 * @param x xIndex of move possibility
	 * @param y yIndex of move possibility
	 * @return
	 */
	public boolean hasPieceOn(int x, int y)
	{
		return (board.returnPiece(x, y) != null);
	}
	
	/**
	 * Updates the possible moves 2D array by checking
	 * each different piece's specific move set.
	 */
	public abstract void updatePossibleMoves();
	
	/**
	 * Updates board based off of the PlayState Board
	 * @param board
	 */
	public void updateBoard(Board board)
	{
		this.board = board;
	}
	
	/**
	 * Draws Piece to the screen based off of its board location
	 * @param g
	 */
	public void render(Graphics2D g)
	{
		//TODO
	}

}
