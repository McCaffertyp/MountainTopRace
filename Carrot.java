import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class Carrot {
    int row, col;
        
    Carrot() {
    }
        
    Carrot(int assignRow, int assignCol) {
        row = assignRow;
        col = assignCol;
    }
    
    public void changeCPos(Toon ownerToon, Carrot carrotToRem) {
        setC(carrotToRem, ownerToon.getRow(), ownerToon.getCol());
    }
    
    public void setC(Carrot carrot, int newR, int newC) {
        carrot.row = newR;
        carrot.col = newC;
    }
    
    //Getter methods
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
} //Carrot class end
