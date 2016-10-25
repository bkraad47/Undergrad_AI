import java.io.IOException;

/**
 * Tic Tac Toe
 *
 * Start-class.
 * @author Markus Lanser
 * Date: 18.11.2003
 */
public class Start {

    public static void main(String[] args) throws IOException {
        int ki = 9;
        int size = 3;
        int anfaenger=1;

        TicTacToe Spiel = new TicTacToe(size, anfaenger, ki);
        Spiel.run();

    }

}
