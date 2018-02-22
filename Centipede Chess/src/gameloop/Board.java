/**
 * 
 */
package gameloop;

import java.awt.Graphics2D;

import pieces.Piece;
import users.User;

public class Board
{
	Piece board[][];
	User player1, player2;
	
	/**
	 * 0 = Black | 1 = White
	 */
	int currentPlayerTurn;
	int gameType;
	
	/**
	 * Instantiates a new Board to start a new Game
	 * Changes instantiation based off of AIvsAI, AIvsPerson, PersonvsPerson
	 */
	public Board(int gameType)
	{
		this.gameType = gameType;
		initBoard();
	}
	
	/**
	 * Sets up initial board based off of gametype
	 * Sets up Users based off of gametype
	 */
	public void initBoard()
	{
		
	}
	
	/**
	 * Goes through the current users and updates pieces based
	 * off of their values
	 */
	public void updateBoard()
	{
		
	}
	
	/**
	 * Renders chess board, and then
	 * Goes through piece board and renders each specific piece.
	 */
	public void render(Graphics2D g)
	{
		
	}

	/**
	 * Returns the current piece on index x,y
	 * @param x
	 * @param y
	 * @return null if no Piece exists on that spot
	 */
	public Piece returnPiece(int x, int y)
	{
		return board[x][y];
	}

}
