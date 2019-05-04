import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class Toons {
    private Buggs buggs;
    private Tazz tazz;
    private Tweety tweety;
    private Marvin marvin;
    
    public Toons() {
    }
    
    public Toons(Buggs buggsTemp, Tazz tazzTemp, Tweety tweetyTemp, Marvin marvinTemp) {
        buggs = buggsTemp;
        tazz = tazzTemp;
        tweety = tweetyTemp;
        marvin = marvinTemp;
    }
    
    //Toon movement method. Also takes into weighted movement decision based on walls,
    //mountainTop, carrots, and Marvin.
    public void moveToon(int rowGot, int colGot, int marvRow, int marvCol) {
        int row = rowGot, col = colGot;
        int rowM = marvRow, colM = marvCol;
        
        
    }
    
    //Protected child classes;
    protected class Buggs {
        int row, col;
        
        Buggs() {
        }
        
        Buggs(int assignRow, int assignCol) {
            row = assignRow;
            col = assignCol;
        }
        
        public int getRow() {
            return row;
        }
    
        public int getCol() {
            return col;
        }
    } //Buggs class end
    
    protected class Tazz {
        int row, col;
        
        Tazz() {
        }
        
        Tazz(int assignRow, int assignCol) {
            row = assignRow;
            col = assignCol;
        }
        
        public int getRow() {
            return row;
        }
    
        public int getCol() {
            return col;
        }
    } //Tazz class end
    
    protected class Tweety {
        int row, col;
        
        Tweety() {
        }
        
        Tweety(int assignRow, int assignCol) {
            row = assignRow;
            col = assignCol;
        }
        
        public int getRow() {
            return row;
        }
    
        public int getCol() {
            return col;
        }
    } //Tweety class end
    
    protected class Marvin {
        int row, col;
        
        Marvin() {
        }
        
        Marvin(int assignRow, int assignCol) {
            row = assignRow;
            col = assignCol;
        }
        
        public int getRow() {
            return row;
        }
    
        public int getCol() {
            return col;
        }
    } //Marvin class end
} //Toons class end
