import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class Toon {
    int row, col;
    String name;
    int num, r, c;
    MRandom random = new MRandom();
    boolean moved = false;
    
    public Toon() {
    }
    
    public Toon(String assignName, int assignRow, int assignCol) {
        name = assignName;
        row = assignRow;
        col = assignCol;
    }
    
    //Toon movement method. Also takes into weighted movement decision based on walls,
    //mountainTop, carrots, and Marvin.
    public void moveToon(Toon toonTemp, Toon marvTemp, Carrot carrotO, Carrot carrotT, Board boardTemp) {
        int tempRow = toonTemp.getRow(), tempCol = toonTemp.getCol();
        int tempRowM = marvTemp.getRow(), tempColM = marvTemp.getCol();
        
        if (toonTemp.equals(marvTemp)) { //If Marvin is the one moving.
            while (moved == false) {
                num = random.getRandNum(9, 0);
                switch(num) {
                    /*All these statements will probably have "ArrayIndexOutofBounds"
                    exception thrown due to not checking if the board is already
                    at the edge. For Marvin, there also needs to be a check for if
                    he tries to move onto a place with another person, which if he does,
                    he checks if they have a carrot, if they do, he takes the carrot and
                    shoots them, otherwise, he just shoots them, sending them back to
                    wherever they had spawned.
                    */
                    case 0: break;
                    case 1: if (boardTemp.getPlace(tempRow, tempCol+1).equals("     -")) {
                                toonTemp.setCol(toonTemp, tempCol+1);
                                moved = true;
                            } break;
                    case 2: if (boardTemp.getPlace(tempRow-1, tempCol+1).equals("     -")) {
                                toonTemp.setRow(toonTemp, tempRow-1);
                                toonTemp.setCol(toonTemp, tempCol+1);
                                moved = true;
                            } break;
                    case 3: if (boardTemp.getPlace(tempRow-1, tempCol).equals("     -")) {
                                toonTemp.setRow(toonTemp, tempRow-1);
                                moved = true;
                            } break;
                    case 4: if (boardTemp.getPlace(tempRow-1, tempCol-1).equals("     -")) {
                                toonTemp.setRow(toonTemp, tempRow-1);
                                toonTemp.setCol(toonTemp, tempCol-1);
                                moved = true;
                            } break;
                    case 5: if (boardTemp.getPlace(tempRow, tempCol-1).equals("     -")) {
                                toonTemp.setCol(toonTemp, tempCol-1);
                                moved = true;
                            } break;
                    case 6: if (boardTemp.getPlace(tempRow+1, tempCol-1).equals("     -")) {
                                toonTemp.setRow(toonTemp, tempRow+1);
                                toonTemp.setCol(toonTemp, tempCol-1);
                                moved = true;
                            } break;
                    case 7: if (boardTemp.getPlace(tempRow+1, tempCol).equals("     -")) {
                                toonTemp.setRow(toonTemp, tempRow+1);
                                moved = true;;
                            } break;
                    case 8: if (boardTemp.getPlace(tempRow+1, tempCol+1).equals("     -")) {
                                toonTemp.setRow(toonTemp, tempRow+1);
                                toonTemp.setCol(toonTemp, tempCol+1);
                                moved = true;
                            } break;
                }
            }
        }
    }
    //Setter methods
    public void setRow(Toon toonS, int newRow) {
        toonS.row = newRow;
    }
    
    public void setCol(Toon toonS, int newCol) {
        toonS.col = newCol;
    }
    
    public void setName(Toon toonN) {
        toonN.name = name + "(C)";
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
