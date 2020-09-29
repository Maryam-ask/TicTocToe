import java.util.Scanner;

/**
 * Created by Maryam Askari
 * Date: 9/16/2020
 * Time: 12:06 PM
 * Project: IntelliJ IDEA
 * <br><br>
 * Game är en subklass som börjar spelet steg för steg.
 */
public class Game extends Player {


    //Instansvariabel av typen Scanner för att läsa in data från användare.
    private Scanner input = new Scanner(System.in);

    /**
     * En metod som börjar spelet.
     */
    public void startGame() {
        while (true) {

            displayBoard();

            int pos;
            do {
                // Fråga användare om positionsnummer
                System.out.printf(ANSI_PURPLE + "Player " + getMark() + ANSI_PURPLE +
                        " Enter your position : " + ANSI_RESET);
                // Få data från användare
                pos = input.nextInt();
            } while (isPositionFilled(pos));

            setPosition(pos);

            if (winner()) {
                displayBoard();
                System.out.println( getMark() + ANSI_RED + " Winner" + ANSI_RESET);
                break;
            } else if (isFull()) {
                displayBoard();
                System.out.println(ANSI_RED + "Draw!" + ANSI_RESET);
                break;
            }

            nextPlayer();

        }
    }

}

