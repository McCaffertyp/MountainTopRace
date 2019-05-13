import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class Carrot {
    int row, col;
    String owner = "";
    String cName = "";
        
    Carrot() {
    }
        
    Carrot(int assignRow, int assignCol, String name) {
        row = assignRow;
        col = assignCol;
        cName = name;
    }
    
    public void changeCPos(Toon ownerToon, Carrot carrotToRem) {
        carrotToRem.row = ownerToon.getRow();
        carrotToRem.col = ownerToon.getCol();
        owner = ownerToon.getName().substring(0, 1);
    }
    
    public void respawn(Board board, Carrot carrot) {
        if (carrot.cName.equals("c1")) {
            carrot.row = 2;
            carrot.col = 3;
        } else if (carrot.cName.equals("c2")) {
            carrot.row = 4;
            carrot.col = 4;
        }
        board.respawnCarrot(carrot);
    }
    
    //Getter methods
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public String getOwner() {
        return owner;
    }
} //Carrot class end
