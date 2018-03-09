package pieces;

import gameloop.Board;
import org.junit.Assert;
import org.junit.Test;

public class PossibleMovesTest 
{
	boolean[][] blankBoard = new boolean[8][8];
	boolean[][] correctCase;
	
  @Test
  public void BishopPossibleMoves()
  {
    Board board = new Board(-1, 0, 0);
    Bishop bishop  = new Bishop(board, 3, 4, 1);
    board.addPiece(bishop, 3, 4);
    
    bishop.updatePossibleMoves();
    
    //Negative Test Case
    Assert.assertNotEquals(blankBoard, bishop.getPossibleMoves());
    
    boolean[][] correctCase =
    	{
    		{false, true, false, false, false, false, false, true},
    		{false, false, true, false, false, false, true, false},
    		{false, false, false, true, false, true, false, false},
    		{false, false, false, false, false, false, false, false},
    		{false, false, false, true, false, true, false, false},
    		{false, false, true, false, false, false, true, false},
    		{false, true, false, false, false, false, false, true},
    		{true, false, false, false, false, false, false, false},
    	};
    
    //Positive Test Case
    Assert.assertArrayEquals(correctCase, bishop.getPossibleMoves());
  }
  @Test
  public void KingPossibleMoves()
  {
	    Board board = new Board(-1, 0, 0);
	    King king  = new King(board, 3, 4, 1);
	    board.addPiece(king, 3, 4);
	    
	    king.updatePossibleMoves();
	    
	    //Negative Test Case
	    Assert.assertNotEquals(blankBoard, king.getPossibleMoves());
	    
	    boolean[][] correctCase =
	    	{
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, false, true, true, true, false, false},
	    		{false, false, false, true, false, true, false, false},
	    		{false, false, false, true, true, true, false, false},
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, false, false, false, false, false, false},
	    	};
	    
	    //Positive Test Case
	    Assert.assertArrayEquals(correctCase, king.getPossibleMoves());
  }
  @Test
  public void KnightPossibleMoves()
  {
	    Board board = new Board(-1, 0, 0);
	    Knight knight  = new Knight(board, 3, 4, 1);
	    board.addPiece(knight, 3, 4);
	    
	    knight.updatePossibleMoves();
	    
	    //Negative Test Case
	    Assert.assertNotEquals(blankBoard, knight.getPossibleMoves());
	    
	    boolean[][] correctCase =
	    	{
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, false, true, false, true, false, false},
	    		{false, false, true, false, false, false, true, false},
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, true, false, false, false, true, false},
	    		{false, false, false, true, false, true, false, false},
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, false, false, false, false, false, false},
	    	};
	    
	    //Positive Test Case
	    Assert.assertArrayEquals(correctCase, knight.getPossibleMoves());
  }
  @Test
  public void PawnPossibleMoves()
  {	
	    Board board = new Board(-1, 0, 0);
	    Pawn pawn  = new Pawn(board, 3, 4, 1);
	    board.addPiece(pawn, 3, 4);
	    
	    pawn.updatePossibleMoves();
	    
	    //Negative Test Case
	    Assert.assertNotEquals(blankBoard, pawn.getPossibleMoves());
	    
	    boolean[][] correctCase =
	    	{
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, false, false, false, false, false, false},
	    					//Has double jump because it has not moved yet
	    		{false, false, true, true, false, false, false, false},
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, false, false, false, false, false, false},
	    		{false, false, false, false, false, false, false, false},
	    	};
	    
	    //Positive Test Case
	    Assert.assertArrayEquals(correctCase, pawn.getPossibleMoves());
  }
  @Test
  public void QueenPossibleMoves()
  {	
	    Board board = new Board(-1, 0, 0);
	    Queen queen  = new Queen(board, 3, 4, 1);
	    board.addPiece(queen, 3, 4);
	    
	    queen.updatePossibleMoves();
	    
	    //Negative Test Case
	    Assert.assertNotEquals(blankBoard, queen.getPossibleMoves());
	    
	    boolean[][] correctCase =
	    	{
	    		{false, true, false, false, true, false, false, true},
	    		{false, false, true, false, true, false, true, false},
	    		{false, false, false, true, true, true, false, false},
	    		{true, true, true, true, false, true, true, true},
	    		{false, false, false, true, true, true, false, false},
	    		{false, false, true, false, true, false, true, false},
	    		{false, true, false, false, true, false, false, true},
	    		{true, false, false, false, true, false, false, false},
	    	};
	    
	    //Positive Test Case
	    Assert.assertArrayEquals(correctCase, queen.getPossibleMoves());
  }
  @Test
  public void RookPossibleMoves()
  {	
	    Board board = new Board(-1, 0, 0);
	    Rook rook  = new Rook(board, 3, 4, 1);
	    board.addPiece(rook, 3, 4);
	    
	    rook.updatePossibleMoves();
	    
	    //Negative Test Case
	    Assert.assertNotEquals(blankBoard, rook.getPossibleMoves());
	    
	    boolean[][] correctCase =
	    	{
	    		{false, false, false, false, true, false, false, false},
	    		{false, false, false, false, true, false, false, false},
	    		{false, false, false, false, true, false, false, false},
	    		{true, true, true, true, false, true, true, true},
	    		{false, false, false, false, true, false, false, false},
	    		{false, false, false, false, true, false, false, false},
	    		{false, false, false, false, true, false, false, false},
	    		{false, false, false, false, true, false, false, false},
	    	};
	    
	    //Positive Test Case
	    Assert.assertArrayEquals(correctCase, rook.getPossibleMoves());
  }
}
