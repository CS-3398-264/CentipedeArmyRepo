package pieces;

import gameloop.Board;
import org.junit.Assert;
import org.junit.Test;

public class PossibleMovesTest 
{

	@Test
  public void BishopPossibleMoves()
  {
    Board board = new Board(0, 0, 0);
    Bishop bishop  = new Bishop(board, 3, 4, 1);
    Pawn pawn1 = new Pawn(board, 0, 7, 1);
    Pawn pawn2 = new Pawn(board, 6, 7, 0);
    Pawn pawn3 = new Pawn(board, 0, 1, 1);
    Pawn pawn4 = new Pawn(board, 7, 0, 0);
    Assert.assertNotEquals(pawn1, bishop);
  }
  @Test
  public void KingPossibleMoves()
  {
    Board board = new Board(0, 0, 0);
    King king = new King(board, 3, 4, 1);
    Pawn pawn1 = new Pawn(board, 4, 4, 0);
    Pawn pawn2 = new Pawn(board, 2, 4, 1);
    Pawn pawn3 = new Pawn(board, 5, 2, 0);
    Pawn pawn4 = new Pawn(board, 5, 6, 0);
    Pawn pawn5 = new Pawn(board, 1, 2, 1);
    Pawn pawn6 = new Pawn(board, 1, 6, 1);
    Pawn pawn7 = new Pawn(board, 4, 2, 0);
    Pawn pawn8 = new Pawn(board, 2, 6, 1);
    Assert.assertNotEquals(pawn1,king);
  }
  @Test
  public void KnightPossibleMoves()
  {
    Board board = new Board(0, 0, 0);
    Knight knight = new Knight(board, 3, 4, 1);
    Pawn pawn1 = new Pawn(board, 5, 3, 1);
    Pawn pawn2 = new Pawn(board, 5, 5, 0);
    Pawn pawn3 = new Pawn(board, 1, 3, 1);
    Pawn pawn4 = new Pawn(board, 1, 5, 0);
    Pawn pawn5 = new Pawn(board, 2, 2, 1);
    Pawn pawn6 = new Pawn(board, 4, 2, 0);
    Pawn pawn7 = new Pawn(board, 2, 6, 1);
    Pawn pawn8 = new Pawn(board, 4, 6, 0);
    Assert.assertNotEquals(pawn1, knight);
  }
  @Test
  public void PawnPossibleMoves()
  {
    Board board = new Board(0, 0, 0);
    Pawn pawn1 = new Pawn(board, 0, 4, 1);
    Pawn pawn2 = new Pawn(board, 1, 3, 1);
    Pawn pawn3 = new Pawn(board, 1, 5, 0);
    Assert.assertNotEquals(pawn1, pawn2);
  }
  @Test
  public void QueenPossibleMoves()
  {
    Board board = new Board(0, 0, 0);
    Queen queen = new Queen(board, 3, 4, 1);
    Pawn pawn1 = new Pawn(board, 0, 7, 1);
    Pawn pawn2 = new Pawn(board, 6, 7, 0);
    Pawn pawn3 = new Pawn(board, 0, 1, 1);
    Pawn pawn4 = new Pawn(board, 7, 0, 0);
    Pawn pawn5 = new Pawn(board, 0, 4, 1);
    Pawn pawn6 = new Pawn(board, 7, 4, 0);
    Pawn pawn7 = new Pawn(board, 0, 0, 1);
    Pawn pawn8 = new Pawn(board, 0, 7, 0);
    Assert.assertNotEquals(pawn1, queen);
  }
  @Test
  public void RookPossibleMoves()
  {
    Board board = new Board(0, 0, 0);
    Rook rook = new Rook(board, 3, 4, 1);
    Pawn pawn1 = new Pawn(board, 0, 4, 1);
    Pawn pawn2 = new Pawn(board, 7, 4, 0);
    Pawn pawn3 = new Pawn(board, 0, 0, 1);
    Pawn pawn4 = new Pawn(board, 0, 7, 0);
    Assert.assertNotEquals(pawn1, rook);
  }
}
