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
        carrot1 = new Carrot(2, 3, "c1");
        carrot2 = new Carrot(4, 4, "c2");
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
            boolean match = false;
            int[][] rowCol = new int[6][2];
            
            //Sleep
            System.out.println("Bugs turn:");
            try {
                Thread.sleep(2250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            //Bugs moves
            pos = toon.move(bugs, marvin, carrot1, carrot2, mountainTop);
            if (pos[0] > 4) { pos[0] = 4;}
            if (pos[0] < 0) { pos[0] = 0;}
            if (pos[1] > 4) { pos[1] = 4;}
            if (pos[1] < 0) { pos[1] = 0;}
            //while loop checks to make sure they don't land on another toon or on the mountain without a carrot
            if (!bugs.getName().substring(2,3).equals("C")) {
                while (pos[0] == taz.getRow() && pos[1] == taz.getCol() || pos[0] == tweety.getRow() && pos[1] == tweety.getCol() 
                       || pos[0] == marvin.getRow() && pos[1] == marvin.getCol() || pos[0] == mountainTop.getRow() && pos[1] == mountainTop.getCol()) {
                    pos = toon.move(bugs, marvin, carrot1, carrot2, mountainTop);
                    if (pos[0] > 4) { pos[0] = 4;}
                    if (pos[0] < 0) { pos[0] = 0;}
                    if (pos[1] > 4) { pos[1] = 4;}
                    if (pos[1] < 0) { pos[1] = 0;}
                }
            } else {
                while (pos[0] == taz.getRow() && pos[1] == taz.getCol() || pos[0] == tweety.getRow() && pos[1] == tweety.getCol() 
                       || pos[0] == marvin.getRow() && pos[1] == marvin.getCol()) {
                    pos = toon.move(bugs, marvin, carrot1, carrot2, mountainTop);
                    if (pos[0] > 4) { pos[0] = 4;}
                    if (pos[0] < 0) { pos[0] = 0;}
                    if (pos[1] > 4) { pos[1] = 4;}
                    if (pos[1] < 0) { pos[1] = 0;}
                }
            }
            gameboard.clearSpace(bugs);
            toon.setPos(bugs, pos[0], pos[1]);
            //Checking if they land on a carrot
            if(bugs.getRow() == carrot1.getRow() && bugs.getCol() == carrot1.getCol() && !(bugs.getName().substring(2,3).equals("C"))) {
                toon.setNameC(bugs);
                carrot1.changeCPos(bugs, carrot1);
            } else if(bugs.getRow() == carrot2.getRow() && bugs.getCol() == carrot2.getCol() && !(bugs.getName().substring(2,3).equals("C"))) {
                toon.setNameC(bugs);
                carrot2.changeCPos(bugs, carrot2);
            }
            //Winner check
            if(bugs.getName().substring(2,3).equals("C") && bugs.getRow() == mountainTop.getRow() && bugs.getCol() == mountainTop.getCol()) {
                toon.setNameF(bugs);
                gameboard.finishBoard(bugs);
                System.out.println();
                System.out.println(gameboard.toString());
                System.out.println();
                winnerName = "Bugs";
                break;
            }
            //Board and character updates
            if (carrot1.getOwner().equals("B")) {
                carrot1.changeCPos(bugs, carrot1);
            } else if (carrot2.getOwner().equals("B")) {
                carrot2.changeCPos(bugs, carrot2);
            }
            gameboard.updateBoard(bugs);
            System.out.println();
            System.out.println(gameboard.toString());
            System.out.println();
            
            //Sleep
            System.out.println("Taz's turn:");
            try {
                Thread.sleep(2250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            //Taz moves
            pos = toon.move(taz, marvin, carrot1, carrot2, mountainTop);
            if (pos[0] > 4) { pos[0] = 4;}
            if (pos[0] < 0) { pos[0] = 0;}
            if (pos[1] > 4) { pos[1] = 4;}
            if (pos[1] < 0) { pos[1] = 0;}
            //while loop checks to make sure they don't land on another toon or on the mountain top without a carrot
            if (!taz.getName().substring(2,3).equals("C")) {
                while (pos[0] == bugs.getRow() && pos[1] == bugs.getCol() || pos[0] == tweety.getRow() && pos[1] == tweety.getCol() 
                       || pos[0] == marvin.getRow() && pos[1] == marvin.getCol() || pos[0] == mountainTop.getRow() && pos[1] == mountainTop.getCol()) {
                    pos = toon.move(taz, marvin, carrot1, carrot2, mountainTop);
                    if (pos[0] > 4) { pos[0] = 4;}
                    if (pos[0] < 0) { pos[0] = 0;}
                    if (pos[1] > 4) { pos[1] = 4;}
                    if (pos[1] < 0) { pos[1] = 0;}
                }
            } else {
                while (pos[0] == bugs.getRow() && pos[1] == bugs.getCol() || pos[0] == tweety.getRow() && pos[1] == tweety.getCol() 
                       || pos[0] == marvin.getRow() && pos[1] == marvin.getCol()) {
                    pos = toon.move(taz, marvin, carrot1, carrot2, mountainTop);
                    if (pos[0] > 4) { pos[0] = 4;}
                    if (pos[0] < 0) { pos[0] = 0;}
                    if (pos[1] > 4) { pos[1] = 4;}
                    if (pos[1] < 0) { pos[1] = 0;}
                }
            }
            gameboard.clearSpace(taz);
            toon.setPos(taz, pos[0], pos[1]);
            //Checking if they land on a carrot
            if(taz.getRow() == carrot1.getRow() && taz.getCol() == carrot1.getCol() && !(taz.getName().substring(2,3).equals("C"))) {
                toon.setNameC(taz);
                carrot1.changeCPos(taz, carrot1);
            } else if(taz.getRow() == carrot2.getRow() && taz.getCol() == carrot2.getCol() && !(taz.getName().substring(2,3).equals("C"))) {
                toon.setNameC(taz);
                carrot2.changeCPos(taz, carrot2);
            }
            //Winner check
            if(taz.getName().substring(2,3).equals("C") && taz.getRow() == mountainTop.getRow() && taz.getCol() == mountainTop.getCol()) {
                toon.setNameF(taz);
                gameboard.finishBoard(taz);
                System.out.println();
                System.out.println(gameboard.toString());
                System.out.println();
                winnerName = "Taz"; 
                break;
            }
            //Board and character updates
            if (carrot1.getOwner().equals("D")) {
                carrot1.changeCPos(taz, carrot1);
            } else if (carrot2.getOwner().equals("D")) {
                carrot2.changeCPos(taz, carrot2);
            }
            gameboard.updateBoard(taz);
            System.out.println();
            System.out.println(gameboard.toString());
            System.out.println();
            
            //Sleep
            System.out.println("Tweety's turn:");
            try {
                Thread.sleep(2250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            //Tweety moves
            pos = toon.move(tweety, marvin, carrot1, carrot2, mountainTop);
            if (pos[0] > 4) { pos[0] = 4;}
            if (pos[0] < 0) { pos[0] = 0;}
            if (pos[1] > 4) { pos[1] = 4;}
            if (pos[1] < 0) { pos[1] = 0;}
            //while loop checks to make sure they don't land on another toon
            if (!tweety.getName().substring(2,3).equals("C")) {
                while (pos[0] == bugs.getRow() && pos[1] == bugs.getCol() || pos[0] == taz.getRow() && pos[1] == taz.getCol() 
                       || pos[0] == marvin.getRow() && pos[1] == marvin.getCol() || pos[0] == mountainTop.getRow() && pos[1] == mountainTop.getCol()) {
                    pos = toon.move(tweety, marvin, carrot1, carrot2, mountainTop);
                    if (pos[0] > 4) { pos[0] = 4;}
                    if (pos[0] < 0) { pos[0] = 0;}
                    if (pos[1] > 4) { pos[1] = 4;}
                    if (pos[1] < 0) { pos[1] = 0;}
                }
            } else {
                while (pos[0] == bugs.getRow() && pos[1] == bugs.getCol() || pos[0] == taz.getRow() && pos[1] == taz.getCol() 
                       || pos[0] == marvin.getRow() && pos[1] == marvin.getCol()) {
                    pos = toon.move(tweety, marvin, carrot1, carrot2, mountainTop);
                    if (pos[0] > 4) { pos[0] = 4;}
                    if (pos[0] < 0) { pos[0] = 0;}
                    if (pos[1] > 4) { pos[1] = 4;}
                    if (pos[1] < 0) { pos[1] = 0;}
                }
            }
            gameboard.clearSpace(tweety);
            toon.setPos(tweety, pos[0], pos[1]);
            //Checking if they land on a carrot
            if(tweety.getRow() == carrot1.getRow() && tweety.getCol() == carrot1.getCol() && !(tweety.getName().substring(2,3).equals("C"))) {
                toon.setNameC(tweety);
                carrot1.changeCPos(tweety, carrot1);
            } else if(tweety.getRow() == carrot2.getRow() && tweety.getCol() == carrot2.getCol() && !(tweety.getName().substring(2,3).equals("C"))) {
                toon.setNameC(tweety);
                carrot2.changeCPos(tweety, carrot2);
            }
            //Winner check
            if(tweety.getName().substring(2,3).equals("C") && tweety.getRow() == mountainTop.getRow() && tweety.getCol() == mountainTop.getCol()) {
                toon.setNameF(tweety);
                gameboard.finishBoard(tweety);
                System.out.println();
                System.out.println(gameboard.toString());
                System.out.println();
                winnerName = "Tweety"; 
                break;
            }
            //Board and character updates
            if (carrot1.getOwner().equals("T")) {
                carrot1.changeCPos(tweety, carrot1);
            } else if (carrot2.getOwner().equals("T")) {
                carrot2.changeCPos(tweety, carrot2);
            }
            gameboard.updateBoard(tweety);
            System.out.println();
            System.out.println(gameboard.toString());
            System.out.println();
            
            //Sleep
            System.out.println("Marvin's turn:");
            try {
                Thread.sleep(2250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            //Marvin moves
            pos = toon.move(marvin, marvin, carrot1, carrot2, mountainTop);
            if (pos[0] > 4) { pos[0] = 4;}
            if (pos[0] < 0) { pos[0] = 0;}
            if (pos[1] > 4) { pos[1] = 4;}
            if (pos[1] < 0) { pos[1] = 0;}
            //Checking mountain position and making sure they don't finish without carrot
            if (!(marvin.getName().substring(2, 3).equals("C")) && pos[0] == mountainTop.getRow() && pos[1] == mountainTop.getCol()) {
                pos = mountainTop.nextPos(pos, marvin);
                if (pos[0] > 4) { pos[0] = 4;}
                if (pos[0] < 0) { pos[0] = 0;}
                if (pos[1] > 4) { pos[1] = 4;}
                if (pos[1] < 0) { pos[1] = 0;}
            }
            gameboard.clearSpace(marvin);
            toon.setPos(marvin, pos[0], pos[1]);
            //Checking if marvin lands on another space as another character
            rowCol[0][0] = bugs.getRow();
            rowCol[0][1] = bugs.getCol();
            rowCol[1][0] = taz.getRow();
            rowCol[1][1] = taz.getCol();
            rowCol[2][0] = tweety.getRow();
            rowCol[2][1] = tweety.getCol();
            for (int i = 0; i < 3; i++) {
                if (!(marvin.getName().substring(2,3).equals("C")) && marvin.getRow() == rowCol[i][0] && marvin.getCol() == rowCol[i][1]) {
                    switch (i) {
                        case 0: if (bugs.getName().substring(2, 3).equals("C")) {
                                    toon.setNameN(bugs);
                                    toon.setNameC(marvin);
                                    if (carrot1.getOwner().equals("B")) {
                                        carrot1.changeCPos(marvin, carrot1);
                                        carrot1.respawn(gameboard, carrot1);
                                    } else {
                                        carrot2.changeCPos(marvin, carrot2);
                                        carrot2.respawn(gameboard, carrot2);
                                    }
                                }
                                toon.respawn(bugs);
                                gameboard.updateBoard(bugs); break;
                        case 1: if (taz.getName().substring(2, 3).equals("C")) {
                                    toon.setNameN(taz);
                                    toon.setNameC(marvin);
                                    if (carrot1.getOwner().equals("D")) {
                                        carrot1.changeCPos(marvin, carrot1);
                                        carrot1.respawn(gameboard, carrot1);
                                    } else {
                                        carrot2.changeCPos(marvin, carrot2);
                                        carrot2.respawn(gameboard, carrot2);
                                    }
                                }
                                toon.respawn(taz); 
                                gameboard.updateBoard(taz); break;
                        case 2: if (tweety.getName().substring(2, 3).equals("C")) {
                                    toon.setNameN(tweety);
                                    toon.setNameC(marvin);
                                    if (carrot1.getOwner().equals("T")) {
                                        carrot1.changeCPos(marvin, carrot1);
                                        carrot1.respawn(gameboard, carrot1);
                                    } else {
                                        carrot2.changeCPos(marvin, carrot2);
                                        carrot2.respawn(gameboard, carrot2);
                                    }
                                }
                                toon.respawn(tweety); 
                                gameboard.updateBoard(tweety); break;
                    }
                } else if (marvin.getName().substring(2,3).equals("C") && marvin.getRow() == rowCol[i][0] && marvin.getCol() == rowCol[i][1]) {
                    switch (i) {
                        case 0: if (bugs.getName().substring(2, 3).equals("C")) {
                                    toon.setNameN(bugs);
                                    toon.setNameC(marvin);
                                    if (carrot1.getOwner().equals("B")) {
                                        carrot1.changeCPos(marvin, carrot1);
                                    } else {
                                        carrot2.changeCPos(marvin, carrot2);
                                    }
                                }
                                toon.respawn(bugs);
                                gameboard.updateBoard(bugs); break;
                        case 1: if (taz.getName().substring(2, 3).equals("C")) {
                                    toon.setNameN(taz);
                                    toon.setNameC(marvin);
                                    if (carrot1.getOwner().equals("D")) {
                                        carrot1.changeCPos(marvin, carrot1);
                                    } else {
                                        carrot2.changeCPos(marvin, carrot2);
                                    }
                                }
                                toon.respawn(taz); 
                                gameboard.updateBoard(taz); break;
                        case 2: if (tweety.getName().substring(2, 3).equals("C")) {
                                    toon.setNameN(tweety);
                                    toon.setNameC(marvin);
                                    if (carrot1.getOwner().equals("T")) {
                                        carrot1.changeCPos(marvin, carrot1);
                                    } else {
                                        carrot2.changeCPos(marvin, carrot2);
                                    }
                                }
                                toon.respawn(tweety); 
                                gameboard.updateBoard(tweety); break;
                    }
                }
            }
            //Checking if they land on a carrot
            if(marvin.getRow() == carrot1.getRow() && marvin.getCol() == carrot1.getCol() && !(marvin.getName().substring(2,3).equals("C"))) {
                toon.setNameC(marvin);
                carrot1.changeCPos(marvin, carrot1);
            } else if(marvin.getRow() == carrot2.getRow() && marvin.getCol() == carrot2.getCol() && !(marvin.getName().substring(2,3).equals("C"))) {
                toon.setNameC(marvin);
                carrot2.changeCPos(marvin, carrot2);
            }
            //Winner check
            if(marvin.getName().substring(2,3).equals("C") && marvin.getRow() == mountainTop.getRow() && marvin.getCol() == mountainTop.getCol()) {
                toon.setNameF(marvin);
                gameboard.finishBoard(marvin);
                System.out.println();
                System.out.println(gameboard.toString());
                System.out.println();
                winnerName = "Marvin";
                break;
            }
            marvinTurns++;
            if (marvinTurns % 3 == 0) { //Mountain respawn by marvins gadget
                gameboard.clearSpaceMT(mountainTop);
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
                while (match) {
                    match = false;
                    pos[0] = random.getRandNum(4, 0);
                    pos[1] = random.getRandNum(4, 0);
                    for (int i = 0; i < 6; i++) {
                        if (pos[0] == rowCol[i][0] && pos[1] == rowCol[i][1]) {
                            match = true;
                        }
                    }
                }
                mountainTop.mtRespawn(pos);
                gameboard.mountainMove(mountainTop);
            }
            //Board and character updates
            if (carrot1.getOwner().equals("M")) {
                carrot1.changeCPos(marvin, carrot1);
            } else if (carrot2.getOwner().equals("M")) {
                carrot2.changeCPos(marvin, carrot2);
            }
            gameboard.updateBoard(marvin);
            System.out.println();
            System.out.println(gameboard.toString());
            System.out.println();
        }//while loop end
        System.out.println("Well, there you have it folks; " + winnerName + " is the winner!");
    } //run method end
} //GamePlay class end
