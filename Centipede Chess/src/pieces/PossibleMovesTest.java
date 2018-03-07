package pieces;

import gameloop.Board;
import org.junit.Assert;
import org.junit.Test;

public class PossibleMovesTest 
{

  public void BishopPossibleMoves()
  {
    Board board = new Board();
    Bishop bishop  = new Bishop(board, 3, 4, white);
    Pawn pawn1 = new Pawn(board, 0, 7, white);
    Pawn pawn2 = new Pawn(board, 6, 7, black);
    Pawn pawn3 = new Pawn(board, 0, 1, white);
    Pawn pawn4 = new Pawn(board, 7, 0, black);
  }
  
  public void KingPossibleMoves()
  {
    Board board = new Board();
    King king = new King(board, 3, 4, white);
    Pawn pawn1 = new Pawn(board, 4, 4, black);
    Pawn pawn2 = new Pawn(board, 2, 4, white);
    Pawn pawn3 = new Pawn(board, 5, 2, black);
    Pawn pawn4 = new Pawn(board, 5, 6, black);
    Pawn pawn5 = new Pawn(board, 1, 2, white);
    Pawn pawn6 = new Pawn(board, 1, 6, white);
    Pawn pawn7 = new Pawn(board, 4, 2, black);
    Pawn pawn8 = new Pawn(board, 2, 6 white);
  }
  
  public void KnightPossibleMoves()
  {
    Board board = new Board();
    Knight knight = new Knight(board, 3, 4, white);
    Pawn pawn1 = new Pawn(board, 5, 3 white);
    Pawn pawn2 = new Pawn(board, 5, 5, black);
    Pawn pawn3 = new Pawn(board, 1, 3, white);
    Pawn pawn4 = new Pawn(board, 1, 5, black);
    Pawn pawn5 = new Pawn(board, 2, 2, white);
    Pawn pawn6 = new Pawn(board, 4, 2, black);
    Pawn pawn7 = new Pawn(board, 2, 6, white);
    Pawn pawn8 = new Pawn(board, 4, 6, black);
  }
  
  public void PawnPossibleMoves()
  {
    Board board = new Board();
    Pawn pawn1 = new Pawn(board, 0, 4, white);
    Pawn pawn2 = new Pawn(board, 1, 3, white);
    Pawn pawn3 = new Pawn(board, 1, 5, black);
  }
  
  public void QueenPossibleMoves()
  {
    Board board = new Board();
    Queen queen = new Queen(board, 3, 4, white);
    Pawn pawn1 = new Pawn(board, 0, 7, white);
    Pawn pawn2 = new Pawn(board, 6, 7, black);
    Pawn pawn3 = new Pawn(board, 0, 1, white);
    Pawn pawn4 = new Pawn(board, 7, 0, black);
    Pawn pawn5 = new Pawn(board, 0, 4, white);
    Pawn pawn6 = new Pawn(board, 7, 4, black);
    Pawn pawn7 = new Pawn(board, 0, 0, white);
    Pawn pawn8 = new Pawn(board, 0, 7, black);
  }
  
  public void RookPossibleMoves()
  {
    Board board = new Board();
    Rook rook = new Rook(board, 3, 4, white);
    Pawn pawn1 = new Pawn(board, 0, 4, white);
    Pawn pawn2 = new Pawn(board, 7, 4, black);
    Pawn pawn3 = new Pawn(board, 0, 0, white);
    Pawn pawn4 = new Pawn(board, 0, 7, black);
  }
}
