import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class Board {
    public static void main(String[] args) {
        //Create the carrots and the mountain top
        Carrot carrot1 = new Carrot(2, 3);
        Carrot carrot2 = new Carrot(4, 4);
        MountainTop mountainTop = new MountainTop(1, 2);
        
        //Create the toons
        Toon toon = new Toon();
        Toon bugs = new Toon("B", 4, 1);
        Toon taz = new Toon("D", 3, 3);
        Toon tweety = new Toon("T", 0, 1);
        Toon marvin = new Toon("M", 1, 3);
        
        //Board creation and testing
        Board bo = new Board();
        bo.startBoard(bugs, taz, tweety, marvin, carrot1, carrot2, mountainTop);
        System.out.println();
        System.out.println(bo.toString());
        System.out.println();
    }

    private String[][] board;
    
    public Board() {
        board = new String[5][5];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "     -";
            }
        }
    }
    
    //This method creates a starting board with all initial positions
    public void startBoard(Toon b, Toon d, Toon t, Toon m, Carrot c1, Carrot c2, MountainTop f) {
        board[b.getRow()][b.getCol()] = "     B";
        board[d.getRow()][d.getCol()] = "     D";
        board[t.getRow()][t.getCol()] = "     T";
        board[m.getRow()][m.getCol()] = "     M";
        board[c1.getRow()][c1.getCol()] = "     C";
        board[c2.getRow()][c2.getCol()] = "     C";
        board[f.getRow()][f.getCol()] = "     F";
    }
    
    //This method clears a space that was taken
    public void clearSpace(Toon toonToMove) {
        int curRow = toonToMove.getRow();
        int curCol = toonToMove.getCol();
        board[curRow][curCol] = "     -";
    }
    
    //This method updates the movement of a toon
    public void updateBoard(Toon toonMoved) {
        int updateRow = toonMoved.getRow();
        int updateCol = toonMoved.getCol();
        board[updateRow][updateCol] = "     " + toonMoved.getName();
    }
    
    @Override
    public String toString() {
        String retStr = "";
        retStr += "     -------------------------\n"; //25 -'s long
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                retStr += board[i][j];
            }
            retStr += "\n";
        }
        retStr += "\n     -------------------------";
        return retStr;
    }
    
    public String getPlace(int getRow, int getCol) {
        return board[getRow][getCol];
    }
} //Board class end
