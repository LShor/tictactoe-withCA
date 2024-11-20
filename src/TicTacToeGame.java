// TicTacToeGame class to manage the game logic
class TicTacToeGame {
    private GameBoard board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private boolean gameOver;
    private boolean isDraw;

    public TicTacToeGame(Player playerX, Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
        board = new GameBoard(3);
        currentPlayer = playerX;
        gameOver = false;
        isDraw = false;
    }

    public void startGame() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Players:");
        System.out.println("Player X: " + playerX.getName());
        System.out.println("Player O: " + playerO.getName());
        playGame();
    }

    private void playGame() {
        while (!gameOver) {
            displayBoard();
            int row = getPlayerInput("Row (0-" + (board.getSize() - 1) + "): ", 0, board.getSize() - 1);
            int col = getPlayerInput("Column (0-" + (board.getSize() - 1) + "): ", 0, board.getSize() - 1);

            if (board.getCell(row, col) == ' ') {
                board.setCell(row, col, currentPlayer.getMarker());
                checkForWin();
                switchPlayer();
            } else {
                System.out.println("Cell is already occupied. Try again.");
            }

            if (isDraw) {
                System.out.println("It's a draw!");
                break;
            }
        }
    }

    private void checkForWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCell(i, 0) == currentPlayer.getMarker() &&
                    board.getCell(i, 1) == currentPlayer.getMarker() &&
                    board.getCell(i, 2) == currentPlayer.getMarker()) {
                gameOver = true;
                return;
            }

            if (board.getCell(0, i) == currentPlayer.getMarker() &&
                    board.getCell(1, i) == currentPlayer.getMarker() &&
                    board.getCell(2, i) == currentPlayer.getMarker()) {
                gameOver = true;
                return;
            }
        }

        if (board.getCell(0, 0) == currentPlayer.getMarker() &&
                board.getCell(1, 1) == currentPlayer.getMarker() &&
                board.getCell(2, 2) == currentPlayer.getMarker()) {
            gameOver = true;
            return;
        }

        if (board.getCell(0, 2) == currentPlayer.getMarker() &&
                board.getCell(1, 1) == currentPlayer.getMarker() &&
                board.getCell(2, 0) == currentPlayer.getMarker()) {
            gameOver = true;
            return;
        }

        // Check for a draw
        if (isBoardFull()) {
            isDraw = true;
            gameOver = true;
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i, j) == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
    }

    private void displayBoard() {
        System.out.println("\nTic Tac Toe Board:");
        System.out.println(board);
    }

    private int getPlayerInput(String prompt, int min, int max) {
        int input;
        do {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(System.console().readLine());
                if (input < min || input >= max) {
                    System.out.println("Input out of range. Please enter a valid row/column.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                input = -1; // Invalid input, keep asking
            }
        } while (input < min || input >= max);
        return input;
    }
}
