// GameBoard class to represent the tic-tac-toe board
class GameBoard {
    private char board[][];
    private int size;

    public GameBoard(int size) {
        this.size = size;
        board = new char[size][size];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, char player) {
        board[row][col] = player;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(board[i][j]).append("|");
            }
            sb.setCharAt(sb.length() - 1, '\n');
            if (i != size - 1) {
                for (int k = 0; k < size * 2 - 1; k++) {
                    sb.append("-");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public int getSize(){
        return size;
    }
}

