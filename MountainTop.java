import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class MountainTop {
    private int row, col;
    private MRandom random = new MRandom();
      
    public MountainTop() {
    }
     
    public MountainTop(int assignRow, int assignCol) {
        row = assignRow;
        col = assignCol;
    }
    
    public void mtRespawn(int[] place) {
        setMountTopPos(place[0], place[1]);
    }
    
    //This method checks if a toon steps on the mountain top
    //before the toon should be allowed to. If a toon does,
    //then it just moves either to the right or left, or up and down.
    public int[] nextPos(int[] setPos, Toon toon) {
        int curRow = toon.getRow(), curCol = toon.getCol();
        int getRow = setPos[0], getCol = setPos[1];
        int justANum = random.getRandNum(2, 0);
        int[] retArr = new int[]{};
        
        if (curRow == getRow && curCol == getCol) { //MM -> mountain
            retArr = new int[]{curRow, curCol};
        } else if (curRow == getRow-1 && curCol == getCol-1) { //TL -> mountain
            switch (justANum) {
                case 0: retArr = new int[]{getRow-1, getCol}; break;
                case 1: retArr = new int[]{getRow, getCol-1}; break;
            }
        } else if (curRow == getRow-1 && curCol == getCol) { //TM -> mountain
            switch (justANum) {
                case 0: retArr = new int[]{getRow, getCol+1}; break;
                case 1: retArr = new int[]{getRow, getCol-1}; break;
            }
        } else if (curRow == getRow-1 && curCol == getCol+1) { //TR -> mountain
            switch (justANum) {
                case 0: retArr = new int[]{getRow, getCol+1}; break;
                case 1: retArr = new int[]{getRow-1, getCol}; break;
            }
        } else if (curRow == getRow && curCol == getCol+1) { //MR -> mountain
            switch (justANum) {
                case 0: retArr = new int[]{getRow+1, getCol}; break;
                case 1: retArr = new int[]{getRow-1, getCol}; break;
            }
        } else if (curRow == getRow+1 && curCol == getCol+1) { //BR -> mountain
            switch (justANum) {
                case 0: retArr = new int[]{getRow-1, getCol}; break;
                case 1: retArr = new int[]{getRow, getCol+1}; break;
            }
        } else if (curRow == getRow+1 && curCol == getCol) { //BM -> mountain
            switch (justANum) {
                case 0: retArr = new int[]{getRow, getCol-1}; break;
                case 1: retArr = new int[]{getRow, getCol+1}; break;
            }
        } else if (curRow == getRow+1 && curCol == getCol-1) { //BL -> mountain
            switch (justANum) {
                case 0: retArr = new int[]{getRow, getCol-1}; break;
                case 1: retArr = new int[]{getRow-1, getCol}; break;
            }
        } else if (curRow == getRow && curCol == getCol-1) { //ML -> mountain
            switch (justANum) {
                case 0: retArr = new int[]{getRow-1, getCol}; break;
                case 1: retArr = new int[]{getRow+1, getCol}; break;
            }
        }
        return retArr;
    }
    
    //Setter method
    public void setMountTopPos(int newRow, int newCol) {
        row = newRow;
        col = newCol;
    }
       
    //Getter methods
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
} //MountainTop class end
