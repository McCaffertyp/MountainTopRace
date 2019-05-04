import java.util.*;
/*
    The Anime-tors
    Jack Van Well
    Paul McCafferty
*/
//This class just uses random to get a random number in a certain area.
public class MRandom {
    private int randNum;
    Random r = new Random();
    
    public MRandom() {
    }
    
    public int getRandNum(int min, int max) {
        randNum = r.nextInt(max) + min;
        return randNum;
    }
} //MRandom class end
