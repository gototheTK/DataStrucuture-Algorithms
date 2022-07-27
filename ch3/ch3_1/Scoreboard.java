package ch3.ch3_1;

/**
 * Scoreboard
 */
public class Scoreboard {

    private int numEntries = 0; // number of actual entries
    private GameEntry[] board;  // array of game entries(names & scores)

    /** Constructs an empty scoreboard with the given capacity for storing entries. */
    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    /** Attempt to add a new score to the collection (if it is high enough) */
    public void add(GameEntry e) {

        int newScore = e.getScore();
        // is the new entry e really a high score?
        if(numEntries < board.length || newScore > board[numEntries-1].getScore()) {
            if(numEntries < board.length)   // no score drops from the board
                numEntries++;   // so overall number increases
        
        int j = numEntries - 1;
        while(j > 0 && board[j-1].getScore() < newScore) {
            board[j]  = board[j-1]; // shift entry from j-1 to j
            j--;    // and decrement j
        }

            board[j] = e;   // when done, add new entry
        }
    }
    
}