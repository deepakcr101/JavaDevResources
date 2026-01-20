package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];
        resetBoard(board);

        int play = 1;
        int turn = 0;
        System.out.println("Two Player Game, Player1 Start the Game: ");

        while (play == 1) {
            printBoard(board);
            if (turn == 0) {
                System.out.print("Player 1 Enter Your Cordinates: ");
                // System.out.print("Enter Your Coordinates: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                if (r < 0 || c < 0 || r >= 3 || c >= 3 || board[r][c] != 'E') {
                    System.out.println("Invalid Move");
                } else {
                    board[r][c] = 'O';
                    if (checkWin(board, r, c)) {
                        System.out.println("Congratulations Player 1 Win This Game! ");
                        System.out.println("Enter 0 to exit Game and 1 to Continue Playing a New Game: ");
                        play = sc.nextInt();
                        if (play == 1)
                            resetBoard(board);
                    }
                }
                turn = 1;
            } else {
                System.out.print("Player 2 Enter Your Cordinates: ");
                // System.out.print("Enter Your Coordinates: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                if (r < 0 || c < 0 || r >= 3 || c >= 3 || board[r][c] != 'E') {
                    System.out.println("Invalid Move");
                } else {
                    board[r][c] = 'X';
                    if (checkWin(board, r, c)) {
                        System.out.println("Congratulations Player 2 Win This Game! ");
                        System.out.println("Enter 0 to exit Game and 1 to Continue Playing a New Game: ");
                        play = sc.nextInt();
                        if (play == 1)
                            resetBoard(board);
                    }
                }
                turn = 0;
            }

            if (isFilled(board)) {
                System.out.println("Game Over: ");
                System.out.println("Board is Full Enter 0 to exit Game and 1 to Continue Playing a New Game: ");
                play = sc.nextInt();
                if (play == 1)
                    resetBoard(board);
            }
        }
        sc.close();
    }

    private static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isFilled(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'E')
                    return false;
            }
        }
        return false;
    }

    private static void resetBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], 'E');
        }
    }

    private static boolean checkWin(char[][] board, int sr, int sc) {
        // check row
        int count = 0;
        char curr = board[sr][sc];
        for (int j = 0; j < 3; j++) {
            if (board[sr][j] == curr)
                count++;
        }
        if (count == 3)
            return true;
        // check column
        count = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][sc] == curr)
                count++;
        }
        if (count == 3)
            return true;
        // check left diag
        count = 0;
        int i = 0;
        while (i < 3) {
            if (board[i][i] == curr) {
                count++;
            }
            i++;
        }
        if (count == 3)
            return true;
        count = 0;
        // check right diag
        i = 0;
        int j = 2;
        while (i < 3 && j >= 0) {
            if (board[i][j] == curr) {
                count++;
            }
            i++;
            j--;
        }
        if (count == 3)
            return true;
        return false;
    }
}