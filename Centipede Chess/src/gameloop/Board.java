/**
 * 
 */
package gameloop;

import pieces.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import pieces.Piece;
import users.AI;
import users.Player;
import users.User;

public class Board
{
	Piece board[][];
	User player1, player2;
	boolean possibleMoves[][];
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
		possibleMoves = new boolean[8][8];
		initBoard();
	}

	public void moveTo(Piece piece, int x, int y, int fromX, int fromY)
	{
		board[x][y] = piece;
		board[fromX][fromY] = null;
		clearPossibleMoves();
	}
	
	public void setPossibleMoves(boolean possibleMoves[][])
	{
		this.possibleMoves = possibleMoves;
	}
	public void clearPossibleMoves()
	{
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
			{
				possibleMoves[i][j] = false;
			}
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
		
		
		if(gameType == 0)
		{
			player1 = new AI(true);
			player2 = new AI(false);
		}
		else if(gameType == 1)
		{
			player1 = new Player(this, true);
			player2 = new AI(false);
		}
		else
		{
			player1 = new Player(this, true);
			player2 = new Player(this, false);
		}
		currentPlayerTurn = 0;
	}
	
	/**
	 * Goes through the current users and updates pieces based
	 * off of their values
	 */
	public void updateBoard(int x, int y)
	{
		
		if(currentPlayerTurn == 0)
		{
			if(player1.getClass().toString().equals("class users.Player"))
			{
				((Player) player1).checkInput(x, y); 
			}
			else if(player1.getClass().equals("class users.AI"))
			{
				((AI) player1).calculateMove();
			}
			if(!player1.hasMoved())
			{
				currentPlayerTurn = 1;
				player2.setNextTurn(true);
			}
		}
		else
		{
			if(player2.getClass().toString().equals("class users.Player"))
			{
				((Player) player2).checkInput(x, y);
			}
			else if(player2.getClass().equals("class users.AI"))
			{
				((AI) player2).calculateMove();
			}
			if(!player2.hasMoved())
			{
				currentPlayerTurn = 0;
				player1.setNextTurn(true);
			}
		}
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
					if(possibleMoves[i][j])
						g.setColor(new Color(200, 200, 0));//dark yellow
					else
						g.setColor(new Color(102, 51, 0));//brown
				}
				else
				{
					if(possibleMoves[i][j])
						g.setColor(new Color(240, 240, 0));//yellow
					else
						g.setColor(new Color(255, 255, 204));//tan
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
		if(x < 0 || x >= 8 || y < 0 || y > 8)
			return null;
		return board[x][y];
	}
}
