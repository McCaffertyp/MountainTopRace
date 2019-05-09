import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
public class GamePlay {

    public static void main(String[] args) {
        GamePlay gamePlay = new GamePlay();
        gamePlay.run();
    } //main method end
    
    public static void run() {
        //Variables
        Carrot carrot1;
        Carrot carrot2;
        MountainTop mountainTop;
        boolean winner = false;
        String winnerName;
        Board gameboard = new Board();
        int[] pos = new int[2];
         
        //Intro
        System.out.println("One fine day Buggs, Tweety, and Tazz were in a great race!");
        System.out.println("Out of no where Marvin jumped into the race with his gun now everything has gone crazy!");
        System.out.println("Who will make it to the top of the mount with the flag?");
        
        //Create the toons
        Toon toon = new Toon();
        Toon bugs = new Toon("B", 4, 1);
        Toon taz = new Toon("D", 3, 3);
        Toon tweety = new Toon("T", 0, 1);
        Toon marvin = new Toon("M", 1, 3);
        
        //Create the carrots and the mountain top
        carrot1 = new Carrot(2, 3);
        carrot2 = new Carrot(4, 4);
        mountainTop = new MountainTop(1, 2);
        
        //Print what board looks like
        gameboard.toString();
        
        //Update the board and the character positions with carrots and mountain top
        gameboard.startBoard(bugs, taz, tweety, marvin, carrot1, carrot2, mountainTop);
        
        //While loop for geting a winner
        //Order of movement: bugs, taz, tweety, marvin
        while (winner == false) {
            int marvinTurns = 0;
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            //Bugs moves
            pos = toon.move(bugs, marvin);
            gameboard.clearSpace(bugs);
            toon.setPos(bugs, pos[0], pos[1]);
            gameboard.updateBoard(bugs);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            //Taz moves
            pos = toon.move(taz, marvin);
            gameboard.clearSpace(taz);
            toon.setPos(taz, pos[0], pos[1]);
            gameboard.updateBoard(taz);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            //Tweety moves
            pos = toon.move(tweety, marvin);
            gameboard.clearSpace(tweety);
            toon.setPos(tweety, pos[0], pos[1]);
            gameboard.updateBoard(tweety);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            //Marvin moves
            pos = toon.move(marvin, marvin);
            gameboard.clearSpace(marvin);
            toon.setPos(marvin, pos[0], pos[1]);
            gameboard.updateBoard(marvin);
            
        }//while loop end
        
    } //run method end
} //GamePlay class end
