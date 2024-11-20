public class TicTacToe {
    public static void main(String[] args) {
        Player playerX = new Player('X', "Player X");
        Player playerO = new Player('O', "Player O");

        TicTacToeGame game = new TicTacToeGame(playerX, playerO);
        game.startGame();
    }
}