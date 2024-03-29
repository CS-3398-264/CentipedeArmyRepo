/**
 * 
 */
package pieces;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameloop.Board;

public abstract class Piece
{
	int posX, posY;
	/**
	 * 0 if Black | 1 if White
	 */
	int pieceColor;
	BufferedImage pieceImage;
	boolean hasMovedYet = false;
	boolean possibleMoves[][];
	Board board;

	/**
	 * Instantiate a new Piece on a specific board position
	 */
	public Piece(Board board, int x, int y, int color)
	{
		possibleMoves = new boolean[8][8];
		this.board = board;
		
		posX = x;
		posY = y;
		
		pieceColor = color;
	}
	
	public int getColor()
	{
		return pieceColor;
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
	 * Returns possible moves
	 * @return boolean matrix
	 */
	public boolean[][] getPossibleMoves()
	{
		return possibleMoves;
	}
	
	/**
	 * Moves piece on the board to x, y
	 * @param x
	 * @param y
	 * @return the new Board to update the PlayState Board
	 */
	public Board moveTo(int x, int y)
	{
		int tempx = posX,
			tempy = posY;
		posX = x;
		posY = y;
		board.moveTo(this, x, y, tempx, tempy); 
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
		if(x < 0 || x > 7)
			return true;
		if(y < 0 || y > 7)
			return true;
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
	 * @throws IOException 
	 */
	public void render(Graphics2D g) throws IOException
	{
	
		BufferedImage img;
		switch(this.getClass().getName())
		{
		case ("pieces.Bishop"):
			if(pieceColor == 0)
			{
				img = ImageIO.read(new File("src\\pieces\\BB.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
			else
			{
				img = ImageIO.read(new File("src\\pieces\\WB.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
			break;
		case ("pieces.King"):
			if(pieceColor == 0)
			{
				img = ImageIO.read(new File("src\\pieces\\BK.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
			else
			{
				img = ImageIO.read(new File("src\\pieces\\WK.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
			break;
		case ("pieces.Knight"):
			if(pieceColor == 0)
			{
				img = ImageIO.read(new File("src\\pieces\\BN.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
			else
			{
				img = ImageIO.read(new File("src\\pieces\\WN.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
			break;
		case ("pieces.Pawn"):
			if(pieceColor == 0)
			{
				img = ImageIO.read(new File("src\\pieces\\BP.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
			else
			{
				img = ImageIO.read(new File("src\\pieces\\WP.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
			break;
		case ("pieces.Queen"):
			if(pieceColor == 0)
			{ 
				img = ImageIO.read(new File("src\\pieces\\BQ.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
			else
			{
				img = ImageIO.read(new File("src\\pieces\\WQ.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
			break;
		case ("pieces.Rook"):
			if(pieceColor == 0)
			{
				img = ImageIO.read(new File("src\\pieces\\BR.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
			else
			{
				img = ImageIO.read(new File("src\\pieces\\WR.png"));
				g.drawImage(img, posX*60, posY*60, null);
			}
		    
			break;

		}
	}
	public void setMoved() {hasMovedYet = true;}
	public boolean hasMovedYet() {return hasMovedYet;}
	public void setPosition(int x, int y) { this.posX = x; this.posY = y;}
}
