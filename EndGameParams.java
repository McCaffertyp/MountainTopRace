import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class EndGameParams {
    private Carrot carrot;
    private MountainTop mountainTop;
    
    public EndGameParams() {
    }
    
    public EndGameParams(Carrot carrotTemp, MountainTop mountTopTemp) {
        carrot = carrotTemp;
        mountainTop = mountTopTemp;
    }
    
    public void setMountTopPos(int newRow, int newCol) {
        mountainTop.row = newRow;
        mountainTop.col = newCol;
    }
    
    //Protected child classes;
    protected class Carrot {
        int row, col;
        
        Carrot() {
        }
        
        Carrot(int assignRow, int assignCol) {
            row = assignRow;
            col = assignCol;
        }
        
        public int getRow() {
            return row;
        }
    
        public int getCol() {
            return col;
        }
    } //Carrot class end
    
    protected class MountainTop {
        private int row, col;
        
        public MountainTop() {
        }
        
        public MountainTop(int assignRow, int assignCol) {
            row = assignRow;
            col = assignCol;
        }
        
        public int getRow() {
            return row;
        }
    
        public int getCol() {
            return col;
        }
    } //MountainTop class end
} //EndGameParams class end
