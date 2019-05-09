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
            marvinTurns++;
            if (marvinTurns % 3 == 0) {
                while (match) {
                    rowCol[0][0] = bugs.getRow();
                    rowCol[0][1] = bugs.getCol();
                    rowCol[1][0] = taz.getRow();
                    rowCol[1][1] = taz.getCol();
                    rowCol[2][0] = tweety.getRow();
                    rowCol[2][1] = tweety.getCol();
                    rowCol[3][0] = marvin.getRow();
                    rowCol[3][1] = marvin.getCol();
                    rowCol[4][0] = carrot1.getRow();
                    rowCol[4][1] = carrot1.getCol();
                    rowCol[5][0] = carrot2.getRow();
                    rowCol[5][1] = carrot2.getCol();
                    for (int i = 0; i < 6; i++) {
                        if (pos[0] == rowCol[i][0] && pos[1] == rowCol[i][1]) {
                            match = true;
                        }
                    }
                    pos[0] = random.getRandNum(4, 0);
                    pos[1] = random.getRandNum(4, 0);
                    mountainTop.mtRespawn(pos[0], pos[1]);
                    match = false;
                }
            }
        }//while loop end
    } //run method end
} //GamePlay class end
