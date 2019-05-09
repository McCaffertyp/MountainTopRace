import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class Toon {
    int row, col;
    String name;
    MRandom random = new MRandom();
    
    public Toon() {
    }
    
    public Toon(String assignName, int assignRow, int assignCol) {
        name = assignName;
        row = assignRow;
        col = assignCol;
    }
    
    //Toon movement method. Also takes into weighted movement decision based on walls,
    //mountainTop, carrots, and Marvin.
    public int[] move(int x, int y, Toon genericToon, Toon toonMar) {
        //Get Marvin's exact location
        int rowM = toonMar.getRow();
        int colM = toonMar.getCol();
        
        //Get a number between 1 and 90
        int percent = random.getRandNum(90, 1);
         
        //Each of these ints changes the chance a character will move to that spot!
        //Cheat sheet integer name
        //L = left
        //M = middle
        //R = right
        //T = top
        //B = bottom
        int moveTL = 10;
        int moveTM = 10;
        int moveTR = 10;
        int moveML = 10;
        int moveMM = 10;
        int moveMR = 10;
        int moveBL = 10;
        int moveBM = 10;
        int moveBR = 10;
         
        //This is where the movement manipulation should take place
        //Use the other method, movementMod, for this section
         
        if(genericToon.hasFlag() == false && !(genericToon.getNameToon().equals("Marvin"))) { //is not marven and does not have flag
        
        
            //This is to calculate where marvin is around the player
            if(genericToon.getRow() > toonMar.getRow() && genericToon.getCol() < toonMar.getCol() ) { //1 Marvin is in the bottom right corrner
               //Add 4 to
               moveTL += 4;
               moveTM += 4;
               moveML += 4;
               //Sub 4 from
               moveBR -= 4;
               moveMR -= 4;
               moveBM -= 4;
            } else if(genericToon.getRow() > toonMar.getRow() && genericToon.getCol() > toonMar.getCol() ) { //2 Marvin is bottom left corrner
            
            } else if(genericToon.getRow() < toonMar.getRow() && genericToon.getCol() > toonMar.getCol() ) { //3 Marvin is top left corner
            
            } else if(genericToon.getRow() < toonMar.getRow() && genericToon.getCol() < toonMar.getCol() ) { //4 Top right conner
            
            } else if(genericToon.getRow() < toonMar.getRow() && genericToon.getCol() == toonMar.getCol() ) {//5 Top Middle
            
            } else if(genericToon.getRow() == toonMar.getRow() && genericToon.getCol() > toonMar.getCol() ) {//6 Middle Right
            
            } else if(genericToon.getRow() > toonMar.getRow() && genericToon.getCol() == toonMar.getCol() ) {//7 Bottom Middle
            
            } else if(genericToon.getRow() == toonMar.getRow() && genericToon.getCol() < toonMar.getCol() ) {//8 Middle Left
            
            }
         } else if(genericToon.hasFlag() == true && !(genericToon.getNameToon().equals("Marvin"))) { //is not marven and does have flag
         
         } else if(genericToon.hasFlag() == false && genericToon.getNameToon().equals("Marvin")) { // is marven and does not have flag
         
         } else if(genericToon.hasFlag() == false && genericToon.getNameToon().equals("Marvin")) { // is marven and does have flag
         
         }
        
        //This top level of if statments decides which path a toon will take 
        
        int xToReturn = -1;
        int yToReturn = -1;
         
        if(percent <= moveTL) { //top left
            xToReturn = x-1;
            yToReturn = y+1;
        } else if(percent <= moveTL + moveTM) { //top middle
            xToReturn = x+0;
            yToReturn = y+1;
        } else if(percent <= moveTL + moveTM + moveTR) { //top right
            xToReturn = x+1;
            yToReturn = y+1;
        } else if(percent <= moveTL + moveTM + moveTR + moveML) { //middle left
            xToReturn = x-1;
            yToReturn = y+0;
        }  else if(percent <= moveTL + moveTM + moveTR + moveML + moveMM) { //middle middle
            xToReturn = x+0;
            yToReturn = y+0;
        } else if(percent <= moveTL + moveTM + moveTR + moveML + moveMM + moveMR) { //middle right
            xToReturn = x+1;
            yToReturn = y+0;
        } else if(percent <= moveTL + moveTM + moveTR + moveML + moveMM + moveMR + moveBL) { //bottom left
            xToReturn = x-1;
            yToReturn = y-1;
        } else if(percent <= moveTL + moveTM + moveTR + moveML + moveMM + moveMR + moveBM) { //bottom middle
            xToReturn = x+0;
            yToReturn = y-1;
        } else if(percent <= moveTL + moveTM + moveTR + moveML + moveMM + moveMR + moveBM + moveBR) { //bottom right
            xToReturn = x+1;
            yToReturn = y-1;
        }
        int[] updatedQuards = {xToReturn,yToReturn};
        return updatedQuards;
    }

    //Setter methods
    public void setRow(Toon toonS, int newRow) {
        toonS.row = newRow;
    }
    
    public void setCol(Toon toonS, int newCol) {
        toonS.col = newCol;
    }
    
    public void setNameC(Toon toonN) {
        toonN.name = name + "(C)";
    }
    
    public void setNameN(Toon toonN) {
        toonN.name = toonN.name.substring(0, 1);
    }
    
    //Getter methods
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public String getName() {
        return name;
    }
    
} //Toons class end
