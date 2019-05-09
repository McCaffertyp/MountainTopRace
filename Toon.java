import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class Toon {
    int row, col;
    String name = "";
    MRandom random = new MRandom();
    
    public Toon() {
    }
    
    public Toon(String assignName, int assignRow, int assignCol) {
        name += assignName;
        row = assignRow;
        col = assignCol;
    }
    
    //Toon movement method. Also takes into weighted movement decision based on walls,
    //mountainTop, carrots, and Marvin.
    public int[] move(Toon genericToon, Toon toonMar, Carrot cOne, Carrot cTwo, MountainTop mound) {
        //Get Marvin's location
        int rowM = toonMar.getRow();
        int colM = toonMar.getCol();
        
        //Get generic toons location
        int x = genericToon.getRow();
        int y = genericToon.getCol();
        
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
         
        if(!(genericToon.getName().substring(2,3).equals("C")) && !(genericToon.getName().equals("Marvin"))) { //is not marven and does not have flag
        
        //Chase after the flag
            if(( Math.abs(cOne.getRow()) - Math.abs(genericToon.getRow()) ) + ( Math.abs(cOne.getCol()) - Math.abs(genericToon.getCol()) ) > ( Math.abs(cTwo.getRow()) - Math.abs(genericToon.getRow()) )
                      + (Math.abs(cTwo.getCol()) - Math.abs(genericToon.getCol()) ))//carrot one is closer
                      
            {
            
                     //This is to calculate the character chasing the carrot
                  if(genericToon.getRow() > cOne.getRow() && genericToon.getCol() < cOne.getCol() ) { //1 in the bottom right corrner
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveML -= 6;
                     //Add 6 to
                     moveBR += 6;
                     moveMR += 6;
                     moveBM += 6;
                  } else if(genericToon.getRow() > cOne.getRow() && genericToon.getCol() > cOne.getCol() ) { //2 bottom left corrner
                     //Sub 6 from
                     moveTM -= 6;
                     moveTR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveML += 6;
                     moveBR += 6;
                     moveBM += 6;
                  
                  } else if(genericToon.getRow() < cOne.getRow() && genericToon.getCol() > cOne.getCol() ) { //3 is top left corner
                     //Sub 6 from
                     moveBM -= 6;
                     moveBR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveML += 6;
                  
                  } else if(genericToon.getRow() < cOne.getRow() && genericToon.getCol() < cOne.getCol() ) { //4 Top right conner
                     //Sub 6 from
                     moveML -= 6;
                     moveBL -= 6;
                     moveBM -= 6;
                     //Add 6 to
                     moveTM += 6;
                     moveTR += 6;
                     moveMR += 6;
                  
                  } else if(genericToon.getRow() < cOne.getRow() && genericToon.getCol() == cOne.getCol() ) {//5 Top Middle
                     //Sub 6 from
                     moveBL -= 6;
                     moveBM -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveTR += 6;
                  
                  } else if(genericToon.getRow() == cOne.getRow() && genericToon.getCol() > cOne.getCol() ) {//6 Middle Right
                     //Sub 6 from
                     moveTR -= 6;
                     moveMR -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveML += 6;
                     moveBL += 6;
                  
                  } else if(genericToon.getRow() > cOne.getRow() && genericToon.getCol() == cOne.getCol() ) {//7 Bottom Middle
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveTR -= 6;
                     //Add 6 to
                     moveBL += 6;
                     moveBM += 6;
                     moveBR += 6;
                  
                  } else if(genericToon.getRow() == cOne.getRow() && genericToon.getCol() < cOne.getCol() ) {//8 Middle Left
                     //Sub 6 from
                     moveTL -= 6;
                     moveML -= 6;
                     moveBL -= 6;
                     //Add 6 to
                     moveTR += 6;
                     moveMR += 6;
                     moveBR += 6; 
                  
                  }
            }
            else//carrot two is closer
            {
                  //This is to calculate the character chasing the carrot
                  if(genericToon.getRow() > cTwo.getRow() && genericToon.getCol() < cTwo.getCol() ) { //1 in the bottom right corrner
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveML -= 6;
                     //Add 6 to
                     moveBR += 6;
                     moveMR += 6;
                     moveBM += 6;
                  } else if(genericToon.getRow() > cTwo.getRow() && genericToon.getCol() > cTwo.getCol() ) { //2 bottom left corrner
                     //Sub 6 from
                     moveTM -= 6;
                     moveTR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveML += 6;
                     moveBR += 6;
                     moveBM += 6;
                  
                  } else if(genericToon.getRow() < cTwo.getRow() && genericToon.getCol() > cTwo.getCol() ) { //3 is top left corner
                     //Sub 6 from
                     moveBM -= 6;
                     moveBR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveML += 6;
                  
                  } else if(genericToon.getRow() < cTwo.getRow() && genericToon.getCol() < cTwo.getCol() ) { //4 Top right conner
                     //Sub 6 from
                     moveML -= 6;
                     moveBL -= 6;
                     moveBM -= 6;
                     //Add 6 to
                     moveTM += 6;
                     moveTR += 6;
                     moveMR += 6;
                  
                  } else if(genericToon.getRow() < cTwo.getRow() && genericToon.getCol() == cTwo.getCol() ) {//5 Top Middle
                     //Sub 6 from
                     moveBL -= 6;
                     moveBM -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveTR += 6;
                  
                  } else if(genericToon.getRow() == cTwo.getRow() && genericToon.getCol() > cTwo.getCol() ) {//6 Middle Right
                     //Sub 6 from
                     moveTR -= 6;
                     moveMR -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveML += 6;
                     moveBL += 6;
                  
                  } else if(genericToon.getRow() > cTwo.getRow() && genericToon.getCol() == cTwo.getCol() ) {//7 Bottom Middle
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveTR -= 6;
                     //Add 6 to
                     moveBL += 6;
                     moveBM += 6;
                     moveBR += 6;
                  
                  } else if(genericToon.getRow() == cTwo.getRow() && genericToon.getCol() < cTwo.getCol() ) {//8 Middle Left
                     //Sub 6 from
                     moveTL -= 6;
                     moveML -= 6;
                     moveBL -= 6;
                     //Add 6 to
                     moveTR += 6;
                     moveMR += 6;
                     moveBR += 6; 
                  
                  }
            }
        
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
               //Add 4 to
               moveTM += 4;
               moveTR += 4;
               moveMR += 4;
               //Sub 4 from
               moveML -= 4;
               moveBR -= 4;
               moveBM -= 4;
            
            } else if(genericToon.getRow() < toonMar.getRow() && genericToon.getCol() > toonMar.getCol() ) { //3 Marvin is top left corner
               //Add 4 to
               moveBM += 4;
               moveBR += 4;
               moveMR += 4;
               //Sub 4 from
               moveTL -= 4;
               moveTM -= 4;
               moveML -= 4;
            
            } else if(genericToon.getRow() < toonMar.getRow() && genericToon.getCol() < toonMar.getCol() ) { //4 Top right conner
               //Add 4 to
               moveML += 4;
               moveBL += 4;
               moveBM += 4;
               //Sub 44 from
               moveTM -= 4;
               moveTR -= 4;
               moveMR -= 4;
            
            } else if(genericToon.getRow() < toonMar.getRow() && genericToon.getCol() == toonMar.getCol() ) {//5 Top Middle
               //Add 4 to
               moveBL += 4;
               moveBM += 4;
               moveBR += 4;
               //Sub 4 from
               moveTL -= 4;
               moveTM -= 4;
               moveTR -= 4;
            
            } else if(genericToon.getRow() == toonMar.getRow() && genericToon.getCol() > toonMar.getCol() ) {//6 Middle Right
               //Add 4 to
               moveTR += 4;
               moveMR += 4;
               moveBR += 4;
               //Sub 4 from
               moveTL -= 4;
               moveML -= 4;
               moveBL -= 4;
            
            } else if(genericToon.getRow() > toonMar.getRow() && genericToon.getCol() == toonMar.getCol() ) {//7 Bottom Middle
               //Add 4 to
               moveTL += 4;
               moveTM += 4;
               moveTR += 4;
               //Sub 4 from
               moveBL -= 4;
               moveBM -= 4;
               moveBR -= 4;
            
            } else if(genericToon.getRow() == toonMar.getRow() && genericToon.getCol() < toonMar.getCol() ) {//8 Middle Left
               //Add 4 to
               moveTL += 4;
               moveML += 4;
               moveBL += 4;
               //Sub 4 from
               moveTR -= 4;
               moveMR -= 4;
               moveBR -= 4; 
            
            }
         } else if(genericToon.getName().substring(2,3).equals("C") && !(genericToon.getName().equals("Marvin"))) { //is not marven and does have flag
         
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
               //Add 4 to
               moveTM += 4;
               moveTR += 4;
               moveMR += 4;
               //Sub 4 from
               moveML -= 4;
               moveBR -= 4;
               moveBM -= 4;
            
            } else if(genericToon.getRow() < toonMar.getRow() && genericToon.getCol() > toonMar.getCol() ) { //3 Marvin is top left corner
               //Add 4 to
               moveBM += 4;
               moveBR += 4;
               moveMR += 4;
               //Sub 4 from
               moveTL -= 4;
               moveTM -= 4;
               moveML -= 4;
            
            } else if(genericToon.getRow() < toonMar.getRow() && genericToon.getCol() < toonMar.getCol() ) { //4 Top right conner
               //Add 4 to
               moveML += 4;
               moveBL += 4;
               moveBM += 4;
               //Sub 44 from
               moveTM -= 4;
               moveTR -= 4;
               moveMR -= 4;
            
            } else if(genericToon.getRow() < toonMar.getRow() && genericToon.getCol() == toonMar.getCol() ) {//5 Top Middle
               //Add 4 to
               moveBL += 4;
               moveBM += 4;
               moveBR += 4;
               //Sub 4 from
               moveTL -= 4;
               moveTM -= 4;
               moveTR -= 4;
            
            } else if(genericToon.getRow() == toonMar.getRow() && genericToon.getCol() > toonMar.getCol() ) {//6 Middle Right
               //Add 4 to
               moveTR += 4;
               moveMR += 4;
               moveBR += 4;
               //Sub 4 from
               moveTL -= 4;
               moveML -= 4;
               moveBL -= 4;
            
            } else if(genericToon.getRow() > toonMar.getRow() && genericToon.getCol() == toonMar.getCol() ) {//7 Bottom Middle
               //Add 4 to
               moveTL += 4;
               moveTM += 4;
               moveTR += 4;
               //Sub 4 from
               moveBL -= 4;
               moveBM -= 4;
               moveBR -= 4;
            
            } else if(genericToon.getRow() == toonMar.getRow() && genericToon.getCol() < toonMar.getCol() ) {//8 Middle Left
               //Add 4 to
               moveTL += 4;
               moveML += 4;
               moveBL += 4;
               //Sub 4 from
               moveTR -= 4;
               moveMR -= 4;
               moveBR -= 4; 
            
            }
            
            
            
            
            
            
             //This is to calculate the character going to the mountain
                  if(genericToon.getRow() > mound.getRow() && genericToon.getCol() < mound.getCol() ) { //1 in the bottom right corrner
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveML -= 6;
                     //Add 6 to
                     moveBR += 6;
                     moveMR += 6;
                     moveBM += 6;
                  } else if(genericToon.getRow() > mound.getRow() && genericToon.getCol() > mound.getCol() ) { //2 bottom left corrner
                     //Sub 6 from
                     moveTM -= 6;
                     moveTR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveML += 6;
                     moveBR += 6;
                     moveBM += 6;
                  
                  } else if(genericToon.getRow() < mound.getRow() && genericToon.getCol() > mound.getCol() ) { //3 is top left corner
                     //Sub 6 from
                     moveBM -= 6;
                     moveBR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveML += 6;
                  
                  } else if(genericToon.getRow() < mound.getRow() && genericToon.getCol() < mound.getCol() ) { //4 Top right conner
                     //Sub 6 from
                     moveML -= 6;
                     moveBL -= 6;
                     moveBM -= 6;
                     //Add 6 to
                     moveTM += 6;
                     moveTR += 6;
                     moveMR += 6;
                  
                  } else if(genericToon.getRow() < mound.getRow() && genericToon.getCol() == mound.getCol() ) {//5 Top Middle
                     //Sub 6 from
                     moveBL -= 6;
                     moveBM -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveTR += 6;
                  
                  } else if(genericToon.getRow() == mound.getRow() && genericToon.getCol() > mound.getCol() ) {//6 Middle Right
                     //Sub 6 from
                     moveTR -= 6;
                     moveMR -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveML += 6;
                     moveBL += 6;
                  
                  } else if(genericToon.getRow() > mound.getRow() && genericToon.getCol() == mound.getCol() ) {//7 Bottom Middle
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveTR -= 6;
                     //Add 6 to
                     moveBL += 6;
                     moveBM += 6;
                     moveBR += 6;
                  
                  } else if(genericToon.getRow() == mound.getRow() && genericToon.getCol() < mound.getCol() ) {//8 Middle Left
                     //Sub 6 from
                     moveTL -= 6;
                     moveML -= 6;
                     moveBL -= 6;
                     //Add 6 to
                     moveTR += 6;
                     moveMR += 6;
                     moveBR += 6; 
                  
                  }
                  
                  
                  
         
         } 
         else if(!(toonMar.getName().substring(2,3).equals("C")) && genericToon.getName().equals("Marvin")) 
         { // is marven and does not have flag
         
            //Chase after the flag
            if(( Math.abs(cOne.getRow()) - Math.abs(genericToon.getRow()) ) + ( Math.abs(cOne.getCol()) - Math.abs(genericToon.getCol()) ) > ( Math.abs(cTwo.getRow()) - Math.abs(genericToon.getRow()) )
                      + (Math.abs(cTwo.getCol()) - Math.abs(genericToon.getCol()) ))//carrot one is closer
                      
            {
            
                     //This is to calculate the character chasing the carrot
                  if(genericToon.getRow() > cOne.getRow() && genericToon.getCol() < cOne.getCol() ) { //1 in the bottom right corrner
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveML -= 6;
                     //Add 6 to
                     moveBR += 6;
                     moveMR += 6;
                     moveBM += 6;
                  } else if(genericToon.getRow() > cOne.getRow() && genericToon.getCol() > cOne.getCol() ) { //2 bottom left corrner
                     //Sub 6 from
                     moveTM -= 6;
                     moveTR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveML += 6;
                     moveBR += 6;
                     moveBM += 6;
                  
                  } else if(genericToon.getRow() < cOne.getRow() && genericToon.getCol() > cOne.getCol() ) { //3 is top left corner
                     //Sub 6 from
                     moveBM -= 6;
                     moveBR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveML += 6;
                  
                  } else if(genericToon.getRow() < cOne.getRow() && genericToon.getCol() < cOne.getCol() ) { //4 Top right conner
                     //Sub 6 from
                     moveML -= 6;
                     moveBL -= 6;
                     moveBM -= 6;
                     //Add 6 to
                     moveTM += 6;
                     moveTR += 6;
                     moveMR += 6;
                  
                  } else if(genericToon.getRow() < cOne.getRow() && genericToon.getCol() == cOne.getCol() ) {//5 Top Middle
                     //Sub 6 from
                     moveBL -= 6;
                     moveBM -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveTR += 6;
                  
                  } else if(genericToon.getRow() == cOne.getRow() && genericToon.getCol() > cOne.getCol() ) {//6 Middle Right
                     //Sub 6 from
                     moveTR -= 6;
                     moveMR -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveML += 6;
                     moveBL += 6;
                  
                  } else if(genericToon.getRow() > cOne.getRow() && genericToon.getCol() == cOne.getCol() ) {//7 Bottom Middle
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveTR -= 6;
                     //Add 6 to
                     moveBL += 6;
                     moveBM += 6;
                     moveBR += 6;
                  
                  } else if(genericToon.getRow() == cOne.getRow() && genericToon.getCol() < cOne.getCol() ) {//8 Middle Left
                     //Sub 6 from
                     moveTL -= 6;
                     moveML -= 6;
                     moveBL -= 6;
                     //Add 6 to
                     moveTR += 6;
                     moveMR += 6;
                     moveBR += 6; 
                  
                  }
            }
            else//carrot two is closer
            {
                  //This is to calculate the character chasing the carrot
                  if(genericToon.getRow() > cTwo.getRow() && genericToon.getCol() < cTwo.getCol() ) { //1 in the bottom right corrner
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveML -= 6;
                     //Add 6 to
                     moveBR += 6;
                     moveMR += 6;
                     moveBM += 6;
                  } else if(genericToon.getRow() > cTwo.getRow() && genericToon.getCol() > cTwo.getCol() ) { //2 bottom left corrner
                     //Sub 6 from
                     moveTM -= 6;
                     moveTR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveML += 6;
                     moveBR += 6;
                     moveBM += 6;
                  
                  } else if(genericToon.getRow() < cTwo.getRow() && genericToon.getCol() > cTwo.getCol() ) { //3 is top left corner
                     //Sub 6 from
                     moveBM -= 6;
                     moveBR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveML += 6;
                  
                  } else if(genericToon.getRow() < cTwo.getRow() && genericToon.getCol() < cTwo.getCol() ) { //4 Top right conner
                     //Sub 6 from
                     moveML -= 6;
                     moveBL -= 6;
                     moveBM -= 6;
                     //Add 6 to
                     moveTM += 6;
                     moveTR += 6;
                     moveMR += 6;
                  
                  } else if(genericToon.getRow() < cTwo.getRow() && genericToon.getCol() == cTwo.getCol() ) {//5 Top Middle
                     //Sub 6 from
                     moveBL -= 6;
                     moveBM -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveTR += 6;
                  
                  } else if(genericToon.getRow() == cTwo.getRow() && genericToon.getCol() > cTwo.getCol() ) {//6 Middle Right
                     //Sub 6 from
                     moveTR -= 6;
                     moveMR -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveML += 6;
                     moveBL += 6;
                  
                  } else if(genericToon.getRow() > cTwo.getRow() && genericToon.getCol() == cTwo.getCol() ) {//7 Bottom Middle
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveTR -= 6;
                     //Add 6 to
                     moveBL += 6;
                     moveBM += 6;
                     moveBR += 6;
                  
                  } else if(genericToon.getRow() == cTwo.getRow() && genericToon.getCol() < cTwo.getCol() ) {//8 Middle Left
                     //Sub 6 from
                     moveTL -= 6;
                     moveML -= 6;
                     moveBL -= 6;
                     //Add 6 to
                     moveTR += 6;
                     moveMR += 6;
                     moveBR += 6; 
                  
                  }
            }
            
         
         }
         else if(toonMar.getName().substring(2,3).equals("C") && genericToon.getName().equals("Marvin")) { // is marven and does have flag
         
                  //This is to calculate the character going to the mountain
                  if(genericToon.getRow() > mound.getRow() && genericToon.getCol() < mound.getCol() ) { //1 in the bottom right corrner
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveML -= 6;
                     //Add 6 to
                     moveBR += 6;
                     moveMR += 6;
                     moveBM += 6;
                  } else if(genericToon.getRow() > mound.getRow() && genericToon.getCol() > mound.getCol() ) { //2 bottom left corrner
                     //Sub 6 from
                     moveTM -= 6;
                     moveTR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveML += 6;
                     moveBR += 6;
                     moveBM += 6;
                  
                  } else if(genericToon.getRow() < mound.getRow() && genericToon.getCol() > mound.getCol() ) { //3 is top left corner
                     //Sub 6 from
                     moveBM -= 6;
                     moveBR -= 6;
                     moveMR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveML += 6;
                  
                  } else if(genericToon.getRow() < mound.getRow() && genericToon.getCol() < mound.getCol() ) { //4 Top right conner
                     //Sub 6 from
                     moveML -= 6;
                     moveBL -= 6;
                     moveBM -= 6;
                     //Add 6 to
                     moveTM += 6;
                     moveTR += 6;
                     moveMR += 6;
                  
                  } else if(genericToon.getRow() < mound.getRow() && genericToon.getCol() == mound.getCol() ) {//5 Top Middle
                     //Sub 6 from
                     moveBL -= 6;
                     moveBM -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveTM += 6;
                     moveTR += 6;
                  
                  } else if(genericToon.getRow() == mound.getRow() && genericToon.getCol() > mound.getCol() ) {//6 Middle Right
                     //Sub 6 from
                     moveTR -= 6;
                     moveMR -= 6;
                     moveBR -= 6;
                     //Add 6 to
                     moveTL += 6;
                     moveML += 6;
                     moveBL += 6;
                  
                  } else if(genericToon.getRow() > mound.getRow() && genericToon.getCol() == mound.getCol() ) {//7 Bottom Middle
                     //Sub 6 from
                     moveTL -= 6;
                     moveTM -= 6;
                     moveTR -= 6;
                     //Add 6 to
                     moveBL += 6;
                     moveBM += 6;
                     moveBR += 6;
                  
                  } else if(genericToon.getRow() == mound.getRow() && genericToon.getCol() < mound.getCol() ) {//8 Middle Left
                     //Sub 6 from
                     moveTL -= 6;
                     moveML -= 6;
                     moveBL -= 6;
                     //Add 6 to
                     moveTR += 6;
                     moveMR += 6;
                     moveBR += 6; 
                  
                  }
         
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
    
    public void respawn(Toon respToon) {
        String name = respToon.getName().substring(0, 1);
        switch(name) {
            case "B": respToon.setPos(respToon, 4, 1); break;
            case "D": respToon.setPos(respToon, 3, 3); break;
            case "T": respToon.setPos(respToon, 0, 1); break;
        }
    }
    
    //Setter methods
    public void setPos(Toon toonS, int newRow, int newCol) {
        toonS.row = newRow;
        toonS.col = newCol;
    }
    
    public void setNameC(Toon toonN) {
        toonN.name = toonN.name.substring(0, 1) + "(C)";
    }
    
    public void setNameN(Toon toonN) {
        toonN.name = toonN.name.substring(0, 1) + "   ";
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
