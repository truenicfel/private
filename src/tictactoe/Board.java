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
     * 0   1   2
     * 3   4   5
     * 6   7   8
     * 
     */
    private final HashMap<Integer, Tokens> board;
    
    /**
     * 
     */
    private int lastField;
    
    //Constructors
    //==========================================================================
    
    /**
     * Board.
     *
     * Initializes a new board to play on.
     */
    public Board() {
        this.board = new HashMap<>() ;
    }

    //Methods (Public)
    //==========================================================================
    
    /**
     * 
     * @param toPlace The token which will be set.
     * @param field The field number. Field numbers are defined as follows.
     * 
     * Field numbers:
     * 
     * 0   1   2
     * 3   4   5
     * 6   7   8
     * 
     * @return  Returns true if the operations was successful. If it returns false
     *          there already was a token at 'field'.
     * 
     */
    public boolean placeToken(Tokens toPlace, int field) {
        final boolean result;
        result = getBoard().putIfAbsent(field, toPlace) != null;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                stringBuilder.append(getBoard().get(i+j)).append("   ");
            }
            stringBuilder.append(System.getProperty("line.separator"));
        }
        return stringBuilder.toString();
    }
    
    
    
    //Methods (Private)
    //==========================================================================
    
    //Getter and Setter
    //==========================================================================

    private HashMap<Integer, Tokens> getBoard() {
        return board;
    }
    
    
    
}
