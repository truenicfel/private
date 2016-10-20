package tictactoe;

import java.util.HashMap;
import java.util.Map;

/**
 * Board.
 *
 * Board class that represents the 3 by 3 field we play on. 1
 *
 * @author nico
 */
public class Board {

    //Object Variables
    //==========================================================================
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
    
    public void placeToken(Tokens toPlace) {
        
    }
    
    
    //Methods (Private)
    //==========================================================================
    
}
