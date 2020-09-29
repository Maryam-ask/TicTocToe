import java.util.Scanner;

/**
 * Created by Maryam Askari
 * Date: 9/16/2020
 * Time: 12:07 PM
 * Project: IntelliJ IDEA
 */
public class Main {
    /**
     * En metod som kör programmet och upprepas sin uppgift så länge som användaren vill
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String continue_;
        do {
            // Skapa en objekt av typen Game
            Game game = new Game();
            // Anrop av metoden startGame
            game.startGame();
            System.out.print("Do you want to continue ? (y / n)");
            continue_ = input.next();
        } while (continue_.equals("y"));
    }
}
