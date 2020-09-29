/**
 * Created by Maryam Askari
 * Date: 9/16/2020
 * Time: 12:05 PM
 * Project: IntelliJ IDEA
 * <br><br>
 * Player är en superklass som innehåller olika metoder för att skape spelet Tic Toc Toe
 */
public class Player {

    // Färger för visa utskriften roligare
    public final String ANSI_RESET = "\u001B[0m";
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_CYAN = "\u001B[36m";
    public final String ANSI_PURPLE = "\u001B[35m";
    public final String ANSI_BLUE = "\u001B[34m";
    public final String ANSI_YELLOW = "\u001B[33m";


    // Instansvariabler
    private final String playerX = ANSI_BLUE + "X"  + ANSI_CYAN;
    private final String playerO = ANSI_YELLOW + "O" + ANSI_CYAN;
    private String mark = playerX;
    private String[][] board = {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};

    /**
     * En metod för att visa spelmiljön med hjälp av arrayen board.
     */
    public void displayBoard() {
        System.out.println(ANSI_CYAN + "| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + "     | 1 | 2 | 3 |");
        System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + "     | 4 | 5 | 6 |");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + "     | 7 | 8 | 9 |" + ANSI_RESET);
    }

    /**
     * En metod som får ett positionnummer från användare och sätter ett märke i potionsnummret i fältet.
     * @param pos
     */
    public void setPosition(int pos) {
        // Kontrollera rad efter rad
        if ((0 < pos) & (pos <= 3)) {
            board[0][pos - 1] = mark;
        } else if ((3 < pos) & (pos <= 6)) {
            board[1][pos - 4] = mark;
        } else if ((6 < pos) & (pos <= 9)) {
            board[2][pos - 7] = mark;
        }
    }

    /**
     * En metod för att kontrollera om en plats är fylld.
     * Om platsen är fylld returnerar true annars returnerar false
     * @param pos platsen som fylls (positionsnummer)
     * @return true om platsen är fylls
     */
    public boolean isPositionFilled(int pos) {
        //Kontrollera rad efter rad
        if ((0 < pos) & (pos <= 3)) {
            if (board[0][pos - 1] == playerO || board[0][pos - 1] == playerX)
                return true;
        } else if ((3 < pos) & (pos <= 6)) {
            if (board[1][pos - 4] == playerO || board[1][pos - 4] == playerX)
                return true;
        } else if ((6 < pos) & (pos <= 9)) {
            if (board[2][pos - 7] == playerO || board[2][pos - 7] == playerX)
                return true;
        }
        return false;
    }

    /**
     * En metod som hoppar till nästa spelare.
     */
    public void nextPlayer() {
        if (mark == playerX)
            mark = playerO;
        else if (mark == playerO)
            mark = playerX;
    }

    /**
     * En metod som kontrollera om varje vertikal , horisontell eller diagonal rad har samma marke.
     * @return true om varje vertikal, horisontall eller diagonal rad är samma.
     */
    public boolean winner() {
        for (int i = 0; i < 3; i++) {
            // Vertikal vinn
            if ((board[i][0] == board[i][1]) & (board[i][1] == board[i][2]) & (board[i][2] == mark)) {
                return true;
                // Horisontell vinn
            } else if ((board[0][i] == board[1][i]) & (board[1][i] == board[2][i]) & (board[2][i] == mark)) {
                return true;
            }
        }

        // Diagonal vinn
        if ((board[0][0] == board[1][1]) & (board[1][1] == board[2][2]) & (board[2][2] == mark)) {
            return true;
        } else if ((board[0][2] == board[1][1]) & (board[1][1] == board[2][0]) & (board[2][0] == mark)) {
            return true;
        }

        return false;
    }

    /**
     * En metod för att kontrollera om hela boardet är fylls.
     * @return true om hela boardet är fylls.
     */
    public boolean isFull() {
        // En variabel som visar hur många platser har fyllts
        int filled = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!board[j][i].equals("_")) {
                    filled++;
                }
            }
        }
        // Om antal av fyllda platser är 9 då returnerar true.
        if (filled == 9)
            return true;

        return false;
    }

    /**
     * En metod som returnerar nuvarande marke.
     * @return mark
     */
    public String getMark() {
        return mark;
    }

}

