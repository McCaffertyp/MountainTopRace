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
         
        //Intro
        System.out.println("One fine day Buggs, Tweety, and Tazz were in a great race!");
        System.out.println("Out of no where Marvin jumped into the race with his gun now everything has gone crazy!");
        System.out.println("Who will make it to the top of the mount with the flag?");
        
        //Create the carrots and the mountain top
        carrot1 = new Carrot(2, 3);
        carrot2 = new Carrot(4, 4);
        mountainTop = new MountainTop(1, 2);
        
        //Create the toons
        Toon toon = new Toon();
        Toon bugs = new Toon("B", 4, 1);
        Toon taz = new Toon("D", 3, 3);
        Toon tweety = new Toon("T", 0, 1);
        Toon marvin = new Toon("M", 1, 3);
        
        //Print what board looks like
        gameboard.toString();
        
        //Update the board and the character positions with carrots and mountain top
        
        
        //While loop for geting a winner
        while (winner == false) {
        
        }//while loop end
        
    } //run method end
} //GamePlay class end
