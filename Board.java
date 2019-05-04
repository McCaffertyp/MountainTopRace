import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class Board {
    private String[][] board;
    
    public Board() {
        board = new String[5][5];
        for (int i = 0; i < board.length; i++) {
            board[i][0] = "-";
            for (int j = 1; j < board[i].length; j++) {
                board[i][j] = "     -";
            }
        }
    }
    
    public void updateBoard(Toon toonMoved) {
        
    }
    
    @Override
    public String toString() {
        String retStr = "";
        retStr += "---------------------------------\n";
        for (int i = 0; i < board.length; i++) {
            retStr += Arrays.toString(board[i]);
        }
        retStr += "\n---------------------------------";
        return retStr;
    }
    
    public String getPlace(int gotRow, int gotCol) {
        return board[gotRow][gotCol];
    }
} //Board class end
