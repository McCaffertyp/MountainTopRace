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
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "  -   ";
            }
        }
    }
    
    //This method creates a starting board with all initial positions
    public void startBoard(Toon b, Toon d, Toon t, Toon m, Carrot c1, Carrot c2, MountainTop f) {
        board[b.getRow()][b.getCol()] = "  B   ";
        board[d.getRow()][d.getCol()] = "  D   ";
        board[t.getRow()][t.getCol()] = "  T   ";
        board[m.getRow()][m.getCol()] = "  M   ";
        board[c1.getRow()][c1.getCol()] = "  C   ";
        board[c2.getRow()][c2.getCol()] = "  C   ";
        board[f.getRow()][f.getCol()] = "  F   ";
    }
    
    //This method clears a space that was taken
    public void clearSpace(Toon toonToMove) {
        board[toonToMove.getRow()][toonToMove.getCol()] = "  -   ";
    }
    
    public void clearSpaceMT(MountainTop mt) {
        board[mt.getRow()][mt.getCol()] = "  -   ";
    }
    
    public void respawnCarrot(Carrot carrot) {
       board[carrot.getRow()][carrot.getCol()] = "  C   ";
    }
    
    //This method updates the movement of a toon
    public void updateBoard(Toon toonMoved) {
        int updateRow = toonMoved.getRow();
        int updateCol = toonMoved.getCol();
        String nameTemp = toonMoved.getName();
        board[updateRow][updateCol] = "  " + nameTemp;
    }
    
    //Adjusts board for winner name
    public void finishBoard(Toon toonWon) {
        int finRow = toonWon.getRow();
        int finCol = toonWon.getCol();
        String finName = toonWon.getName();
        board[finRow][finCol] = "  " + finName;
        board[finRow][finCol+1] = board[finRow][finCol+1].substring(2,5);
    }
    
    //Mountain moves
    public void mountainMove(MountainTop mt) {
        int updateRow = mt.getRow();
        int updateCol = mt.getCol();
        board[updateRow][updateCol] = "  F   ";
    }
    
    @Override
    public String toString() {
        String retStr = "";
        retStr += "  -------------------------\n"; //25 -'s long
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                retStr += board[i][j];
            }
            retStr += "\n";
        }
        retStr += "  -------------------------";
        return retStr;
    }
    
    //Getter methods
    public String getPlace(int getRow, int getCol) {
        return board[getRow][getCol];
    }
} //Board class end
