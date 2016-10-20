package tictactoe;

import java.util.HashMap;
import java.util.Map;

/**
 * Board.
 *
 * Board class that represents the 3 by 3 field we play on.
 *
 * @author nico
 */
public class Board {

    //Object Variables
    //==========================================================================
    
    /**
     * The board has nine fields. Each field is one key in this map. From 0 - 8.
     * Top left is zero. Bottom Right is 8.
     * 
     * Like this:
     * 
     * 1   2   3
     * 4   5   6
     * 7   8   9
     * 
     */
    private final Map<Integer, Tokens> board;

    //Constructors
    //==========================================================================
    
    /**
     * Board.
     *
     * Initializes a new board to play on.
     */
    public Board() {
        this.board = new HashMap<>();
    }

    //Methods (Public)
    //==========================================================================
    
    /**
     * 
     * @param toPlace 
     * @param field 
     */
    public void placeToken(Tokens toPlace, int field) {
        
    }
    
    
    //Methods (Private)
    //==========================================================================
    
}
