public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    private static String currentPlayer;

    public static void main(String[] args) {
        clearBoard();
        currentPlayer = "X";
        int moveCounter = 0;

        while (true) {
            display();
            int row, col;
            do {
                row = getPlayerMove("row") - 1; // Get user input (1-3 for row), convert to 0-2
                col = getPlayerMove("col") - 1; // Get user input (1-3 for col), convert to 0-2
            } while (!isValidMove(row, col));

            board[row][col] = currentPlayer; // Record the valid move on the board
            moveCounter++;

            if (moveCounter >= 5) { // Only check for win/tie if moveCounter is 5 or more
                if (isWin(currentPlayer)) {
                    display();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (moveCounter == 9 || isTie()) {
                    display();
                    System.out.println("It's a tie!");
                    break;
                }
            }

            togglePlayer(); // Switch the player
        }
    }

    // Clears the board by setting all elements to a space
    private static void clearBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";
            }
        }
    }

    // Displays the current board state
    private static void display() {
        System.out.println("Current board:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j]);
                if (j < COLS - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < ROWS - 1) System.out.println("---------");
        }
    }

    // Checks if the move at (row, col) is valid (i.e., the space is empty)
    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    // Checks if the current player has won
    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    // Checks if there is a column win
    private static boolean isColWin(String player) {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // Checks if there is a row win
    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    // Checks if there is a diagonal win
    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    // Checks if the game is a tie
    private static boolean isTie() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col].equals(" ")) return false;
            }
        }
        return true;
    }

    // Toggles the current player between X and O
    private static void togglePlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    // Placeholder method to simulate user input; replace with actual input mechanism
    private static int getPlayerMove(String coordinate) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter " + coordinate + " (1-3): ");
        return scanner.nextInt();
    }
}
