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
     * 0 1 2
     * 3 4 5
     * 6 7 8
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
        this.board = new HashMap<>();
    }

    //Methods (Public)
    //==========================================================================
    /**
     * This method simply places a token on the board.
     *
     * @param toPlace The token which will be set.
     * @param field The field number. Field numbers are defined as follows.
     *
     * Field numbers:
     *
     * 0 1 2
     * 3 4 5
     * 6 7 8
     *
     * @return Returns true if the operations was successful. If it returns
     * false there already was a token at 'field'.
     *
     */
    public boolean placeToken(Tokens toPlace, int field) {
        final boolean result;
        //place token
        result = getBoard().putIfAbsent(field, toPlace) == null;
        if (result) {
            setLastField(field);
        }
        return result;
    }

    @Override
    public String toString() {
        return getBoard().toString();
    }

    /**
     * Checks if the game is over.
     *
     * Uses the 'lastField' Variable to check if the player that set that token
     * won the game.
     *
     * @return Returns true if the last player has won.
     */
    public boolean checkWin() {
        boolean result;

        //three directions to win:
        //check top down
        result = checkTopDown(getLastField());

        return result;
    }

    //Methods (Private)
    //==========================================================================
    /**
     *
     * @param field The field to test.
     * @return the token thats at the specified Position or null if there is no
     * token.
     */
    private Tokens returnToken(int field) {
        Tokens result = null;
        if (getBoard().containsKey(field)) {
            result = getBoard().get(field);
        }
        return result;
    }

    /**
     * Checks if there is a winner starting from the specified field.
     *
     * @param field The field from which this method will start searching.
     * @return True if we have a winner.
     */
    private boolean checkTopDown(int field) {
        boolean result = false;
        int counter = 1;
        int currentField;
        //first line
        if (field < 4) {
            //count the lines down if there are three same tokens in a row this
            //is a winner
            for (int i = 0; i < 2; i++) {
                currentField = field + 3;
                if (returnToken(currentField) == getBoard().get(getLastField())) {
                    counter++;
                }
            }
            result = counter == 3;
        }
        //second line
        if (field > 2 && field < 6) {
            //check above and below if there are three in a row this
            //is a winner
            currentField = field - 3;
            if (returnToken(currentField) == getBoard().get(getLastField())) {
                counter++;
            }
            currentField = field + 3;
            if (returnToken(currentField) == getBoard().get(getLastField())) {
                counter++;
            }
            result = counter == 3;
        }
        //third line
        if (field > 5) {
            //count the lines up if there are three same tokens in a row this
            //is a winner
            for (int i = 0; i < 2; i++) {
                currentField = field - 3;
                if (returnToken(currentField) == getBoard().get(getLastField())) {
                    counter++;
                }
            }
            result = counter == 3;
        }
        return result;
    }

    //Getter and Setter
    //==========================================================================
    private HashMap<Integer, Tokens> getBoard() {
        return board;
    }

    private int getLastField() {
        return lastField;
    }

    /**
     * Sets last field if input is between 0 - 8.
     *
     * @param lastField Must be 0 - 8.
     */
    private void setLastField(int lastField) {
        if (getLastField() >= 0 && getLastField() <= 8) {
            this.lastField = lastField;
        }
    }

}
