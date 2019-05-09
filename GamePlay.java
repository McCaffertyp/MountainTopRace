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
        String winnerName;
        Board gameboard = new Board();
        int[] pos = new int[2];
        MRandom random = new MRandom();
         
        //Intro
        System.out.println("One fine day Buggs, Tweety, and Tazz were in a great race!");
        System.out.println("Out of no where Marvin jumped into the race with his gun now everything has gone crazy!");
        System.out.println("Who will make it to the top of the mount with the flag?");
        
        //Create the toons
        Toon toon = new Toon();
        Toon bugs = new Toon("B   ", 4, 1);
        Toon taz = new Toon("D   ", 3, 3);
        Toon tweety = new Toon("T   ", 0, 1);
        Toon marvin = new Toon("M   ", 1, 3);
        
        //Create the carrots and the mountain top
        carrot1 = new Carrot(2, 3);
        carrot2 = new Carrot(4, 4);
        mountainTop = new MountainTop(1, 2);
        
        //Print what board looks like
        System.out.println("***STARTING BOARD***");
        System.out.println(gameboard.toString());
        System.out.println();
        
        //Update the board and the character positions with carrots and mountain top
        System.out.println("***BOARD WITH PLAYERS***");
        gameboard.startBoard(bugs, taz, tweety, marvin, carrot1, carrot2, mountainTop);
        System.out.println(gameboard.toString());
        System.out.println();
        
        //While loop for geting a winner
        //Order of movement: bugs, taz, tweety, marvin
        System.out.println("--> Game Start <---");
        int marvinTurns = 0;
        while (true) {
            boolean match = true;
            int[][] rowCol = new int[6][2];
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            //Bugs moves
            pos = toon.move(bugs, marvin, carrot1, carrot2, mountainTop);
            if (pos[0] > 4) { pos[0] = 4;}
            else if (pos[0] < 0) { pos[0] = 0;}
            else if (pos[1] > 4) { pos[1] = 4;}
            else if (pos[1] < 0) { pos[1] = 0;}
            gameboard.clearSpace(bugs);
            toon.setPos(bugs, pos[0], pos[1]);
            gameboard.updateBoard(bugs);
            System.out.println();
            System.out.println(gameboard.toString());
            System.out.println();
            if(bugs.getRow() == carrot1.getRow() && bugs.getCol() == carrot1.getCol())
            {
                bugs.setNameC();
            }
        else if(bugs.getRow() == carrot2.getRow() && bugs.getCol() == carrot2.getCol())
        {
            bugs.setNameC();
        }
            if(bugs.getName().substring(2,3).equals("C") && bugs.getRow() == mountainTop.getRow() && bugs.getCol() == mountainTop.getCol()) {
                winnerName = bugs.getName(); break;
            }
            
            //Sleep
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            //Taz moves
            pos = toon.move(taz, marvin, carrot1, carrot2, mountainTop);
            if (pos[0] > 4) { pos[0] = 4;}
            else if (pos[0] < 0) { pos[0] = 0;}
            else if (pos[1] > 4) { pos[1] = 4;}
            else if (pos[1] < 0) { pos[1] = 0;}
            gameboard.clearSpace(taz);
            toon.setPos(taz, pos[0], pos[1]);
            gameboard.updateBoard(taz);
            System.out.println();
            System.out.println(gameboard.toString());
            System.out.println();
            if(taz.getRow() == carrot1.getRow() && taz.getCol() == carrot1.getCol())
            {
                taz.setNameC();
            }
        else if(bugs.getRow() == carrot2.getRow() && bugs.getCol() == carrot2.getCol())
        {
            bugs.setNameC();
        }
            if(taz.getName().substring(2,3).equals("C") && taz.getRow() == mountainTop.getRow() && taz.getCol() == mountainTop.getCol()) {
                winnerName = taz.getName(); break;
            }
            
            //Sleep
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            //Tweety moves
            pos = toon.move(tweety, marvin, carrot1, carrot2, mountainTop);
            if (pos[0] > 4) { pos[0] = 4;}
            else if (pos[0] < 0) { pos[0] = 0;}
            else if (pos[1] > 4) { pos[1] = 4;}
            else if (pos[1] < 0) { pos[1] = 0;}
            gameboard.clearSpace(tweety);
            toon.setPos(tweety, pos[0], pos[1]);
            gameboard.updateBoard(tweety);
            System.out.println();
            System.out.println(gameboard.toString());
            System.out.println();
            if(tweety.getRow() == carrot1.getRow() && tweety.getCol() == carrot1.getCol())
            {
                tweety.setNameC();
            }
        else if(bugs.getRow() == carrot2.getRow() && bugs.getCol() == carrot2.getCol())
        {
            bugs.setNameC();
        }
            if(tweety.getName().substring(2,3).equals("C") && tweety.getRow() == mountainTop.getRow() && tweety.getCol() == mountainTop.getCol()) {
                winnerName = tweety.getName(); break;
            }
            
            //Sleep
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            //Marvin moves
            pos = toon.move(marvin, marvin, carrot1, carrot2, mountainTop);
            if (pos[0] > 4) { pos[0] = 4;}
            else if (pos[0] < 0) { pos[0] = 0;}
            else if (pos[1] > 4) { pos[1] = 4;}
            else if (pos[1] < 0) { pos[1] = 0;}
            gameboard.clearSpace(marvin);
            System.out.println();
            System.out.println(gameboard.toString());
            System.out.println();
            toon.setPos(marvin, pos[0], pos[1]);
            rowCol[0][0] = bugs.getRow();
            rowCol[0][1] = bugs.getCol();
            rowCol[1][0] = taz.getRow();
            rowCol[1][1] = taz.getCol();
            rowCol[2][0] = tweety.getRow();
            rowCol[2][1] = tweety.getCol();
            for (int i = 0; i < 3; i++) {
                if (marvin.getRow() == rowCol[i][0] && marvin.getCol() == rowCol[i][1]) {
                    switch (i) {
                        case 0: toon.respawn(bugs); break;
                        case 1: toon.respawn(taz); break;
                        case 2: toon.respawn(tweety); break;
                    }
                }
            }
            gameboard.updateBoard(marvin);
            if(marvin.getRow() == carrot1.getRow() && marvin.getCol() == carrot1.getCol())
            {
                marvin.setNameC();
            }
        else if(bugs.getRow() == carrot2.getRow() && bugs.getCol() == carrot2.getCol())
        {
            bugs.setNameC();
        }
            if(marvin.getName().substring(2,3).equals("C") && marvin.getRow() == mountainTop.getRow() && marvin.getCol() == mountainTop.getCol()) {
                winnerName = marvin.getName();
                break;
            }
            marvinTurns++;
            if (marvinTurns % 3 == 0) {
                rowCol[3][0] = marvin.getRow();
                rowCol[3][1] = marvin.getCol();
                rowCol[4][0] = carrot1.getRow();
                rowCol[4][1] = carrot1.getCol();
                rowCol[5][0] = carrot2.getRow();
                rowCol[5][1] = carrot2.getCol();
                while (match) {
                    for (int i = 0; i < 6; i++) {
                        if (pos[0] == rowCol[i][0] && pos[1] == rowCol[i][1]) {
                            match = true;
                        }
                    }
                    pos[0] = random.getRandNum(4, 0);
                    pos[1] = random.getRandNum(4, 0);
                    mountainTop.mtRespawn(pos);
                    match = false;
                }
            }
        }//while loop end
        System.out.println("Well, there you have it folks " + winnerName + "is the winner!");
    } //run method end
} //GamePlay class end
