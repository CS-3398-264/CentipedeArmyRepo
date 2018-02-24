/**
 * 
 */
package gameloop;

import pieces.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

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
		board = new Piece[8][8];
		initBoard();
	}
	
	/**
	 * Sets up initial board based off of gameType
	 * Sets up Users based off of gameType
	 */
	public void initBoard()
	{
		board[0][0] = new Rook(this, 0, 0, 0);
		board[7][0] = new Rook(this, 7, 0, 0);
		board[1][0] = new Knight(this, 1, 0, 0);
		board[6][0] = new Knight(this, 6, 0, 0);
		board[2][0] = new Bishop(this, 2, 0, 0);
		board[5][0] = new Bishop(this, 5, 0, 0);
		board[3][0] = new Queen(this, 3, 0, 0);
		board[4][0] = new King(this, 4, 0, 0);
		for(int i = 0; i < 8; i++)
		{
			board[i][1] = new Pawn(this, i, 1, 0);
		}
		
		board[0][7] = new Rook(this, 0, 7, 1);
		board[7][7] = new Rook(this, 7, 7, 1);
		board[1][7] = new Knight(this, 1, 7, 1);
		board[6][7] = new Knight(this, 6, 7, 1);
		board[2][7] = new Bishop(this, 2, 7, 1);
		board[5][7] = new Bishop(this, 5, 7, 1);
		board[3][7] = new Queen(this, 3, 7, 1);
		board[4][7] = new King(this, 4, 7, 1);
		for(int i = 0; i < 8; i++)
		{
			board[i][6] = new Pawn(this, i, 6, 1);
		}
		
		
		if(gameType == 1)
		{
			
		}
		else if(gameType == 2)
		{
			
		}
		else
		{
			
		}
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
	 * @throws IOException 
	 */
	public void render(Graphics2D g) throws IOException
	{
		int square=60;
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
			{
				if((i + j)%2 == 1)
				{
					g.setColor(new Color(102, 51, 0));
				}
				else
				{
					g.setColor(new Color(255, 255, 204));
				}
				g.fillRect(i * square, j * square, square, square);
				if(this.returnPiece(i, j) != null)
				{
					board[i][j].render(g);
				}
			}
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
