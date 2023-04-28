package Test;
import Logic.Piece;
import Logic.Queen;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenTest {
    @Test
    public void MovementTest() {
        Piece[][] board = new Piece[8][8];
        Queen queen = new Queen (true, "queen", 5, 1);
        //Test para que no se mueva como caballo
        assertEquals("ERROR [Movimiento invalido]",queen.movePiece(4,3,true,board));
    }
    @Test
    public void KillTest(){
        Piece[][] board = new Piece[8][8];
        Queen queenA = new Queen (true, "queenA", 5, 1);
        Queen queenB = new Queen (true, "queenB", 5, 2);
        board[5][2]=queenB;
        //Test para que no mate a su propio equipo
        assertEquals("ERROR [No te puedes comer a ti mismo]", queenA.movePiece(5, 2, true, board));
    }
    @Test
    public void OthersTest(){
        Piece[][] board = new Piece[8][8];
        Queen queenA = new Queen (true, "queenA", 5, 1);
        Queen queenB = new Queen (true, "queenB", 5, 2);
        Queen queenC = new Queen (true, "queenC", 4, 2);
        Queen queenD = new Queen (false, "queenD", 6, 2);
        board[5][2]=queenB;
        board[4][2]=queenC;
        board[6][2]=queenD;
        //Test para que no salte piezas verticalmente
        assertEquals("ERROR [Vertical, no puedes moverte, hay una pieza en tu camino que te obstruye]", queenA.movePiece(5, 3, true, board));
        //Test para que no salte piezas diagonalmente
        assertEquals("ERROR [No puedes mover, hay una pieza en tu camino que te obstruye]", queenA.movePiece(3, 3, true, board));
        //Test para que mate piezas de otro color
        assertEquals("true", queenA.movePiece(6, 2, true, board));
    }
}
