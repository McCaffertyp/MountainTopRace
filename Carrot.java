import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class Carrot {
    int row, col;
    boolean owned;
    String ownerName;
        
    Carrot() {
    }
        
    Carrot(int assignRow, int assignCol) {
        row = assignRow;
        col = assignCol;
        owned = false;
    }
    
    //Setter method
    public void setOwnership(Toon toonTemp, Carrot carrotTemp) {
        carrotTemp.ownerName = toonTemp.getName();
        carrotTemp.owned = true;
    }
        
    //Getter methods
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
} //Carrot class end
