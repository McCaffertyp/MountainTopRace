import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class MountainTop {
    private int row, col;
      
    public MountainTop() {
    }
     
    public MountainTop(int assignRow, int assignCol) {
        row = assignRow;
        col = assignCol;
    }
    
    public void mtRespawn(int[] place) {
        setMountTopPos(place[0], place[1]);
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
